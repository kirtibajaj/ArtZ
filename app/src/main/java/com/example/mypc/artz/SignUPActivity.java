package com.example.mypc.artz;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SignUPActivity extends AppCompatActivity {

    private CardView buttonRegister;
    private EditText editTextemail;
    private EditText editTextpassswd;
    private EditText editTextusername;
    private TextView textsignup;
    private ProgressDialog Progressbar;
    private FirebaseAuth firebaseAuth;
    private String append = "";
    private FirebaseMethod firebaseMethods;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference myref;
    private String email, username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firebaseDatabase=FirebaseDatabase.getInstance();
        Progressbar =new ProgressDialog(this);
        firebaseMethods = new FirebaseMethod(SignUPActivity.this);
        buttonRegister=(CardView) findViewById(R.id.register);
        editTextemail=(EditText)findViewById(R.id.Emailid);
        editTextpassswd=(EditText)findViewById(R.id.Passwordid);
        editTextusername=(EditText)findViewById(R.id.username);
        textsignup=(TextView)findViewById(R.id.signin);
         setupFirebaseAuth();
          init();
        textsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUPActivity.this,LoginActivity.class));
            }
        });
    }
    private void init(){
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextemail.getText().toString();
                username = editTextusername.getText().toString();
                password = editTextpassswd.getText().toString();

                if(checkInputs(email, username, password)){
                    //setupFirebaseAuth();
                    Progressbar.setMessage("Processing...");
                    Progressbar.show();
                    firebaseMethods.registerNewEmail(email, password, username);
                    //Progressbar.dismiss();
                }
            }
        });
    }

    private boolean checkInputs(String email, String username, String password){
        if(email.equals("") || username.equals("") || password.equals("")){
            Toast.makeText(SignUPActivity.this, "All fields must be filled out.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void checkIfUsernameExists(final String username) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        Query query = reference.child("users").orderByChild("user_name").equalTo(username);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot singleSnapshot: dataSnapshot.getChildren()){
                    if (singleSnapshot.exists()){
                        append = myref.push().getKey().substring(3,10);
                    }
                }
                String mUsername = "";
                mUsername = username + append;
                //add new user to the database
               firebaseMethods.addNewUser(email, mUsername, "", "", "");
                Toast.makeText(SignUPActivity.this, "Signup successful.", Toast.LENGTH_SHORT).show();
                firebaseAuth.signOut();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Progressbar.dismiss();
                    Toast.makeText(SignUPActivity.this, "Could not register ...", Toast.LENGTH_SHORT).show();
            }
        });
    }
    /**
     * Setup the firebase auth object
     */
    private void setupFirebaseAuth(){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        myref = firebaseDatabase.getReference();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    myref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            checkIfUsernameExists(username);
                            //check the user name
                        //add new user to database
                            //add new user account setting to database
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Progressbar.dismiss();
                            Toast.makeText(SignUPActivity.this, "Could not register ...", Toast.LENGTH_SHORT).show();
                        }
                    });
                    finish();
                } else {
                    // User is signed out
                }
                // ...
            }
        };
    }
    @Override
    public void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            firebaseAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
