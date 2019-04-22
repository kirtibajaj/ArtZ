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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private CardView  buttonsignin;
    private EditText editTextemail, editTextpassword;
    private TextView textView;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog Progressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonsignin = (CardView) findViewById(R.id.signinbutton);
        textView = (TextView) findViewById(R.id.signup);
        editTextemail = (EditText) findViewById(R.id.Emailidlogin);
        Progressbar = new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        editTextpassword = (EditText) findViewById(R.id.Passwordidlogin);
        buttonsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                 userLogin();
            }
        });
         textView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 finish();
                 startActivity(new Intent(LoginActivity.this,SignUPActivity.class));
             }
         });
    }
        private void userLogin() {
        String email = editTextemail.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            //email is empty
            Toast.makeText(this, "Please Enter email", Toast.LENGTH_SHORT).show();
            //stopping function execution further
            return;
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            return;
            //password is  empty
        }
        //if validation is ok
         Progressbar.setMessage("Processing...");
         Progressbar.show();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Progressbar.dismiss();
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Wrong Email ID or Password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    }
