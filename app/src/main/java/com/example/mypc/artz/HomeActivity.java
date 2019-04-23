package com.example.mypc.artz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
      private FirebaseAuth mauth;
      private FirebaseAuth.AuthStateListener mauthlistener;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   final HomeFragment homeFragment=new HomeFragment();
                   setfragment(homeFragment);
                    return true;
                case R.id.navigation_camera:
                  startActivity(new Intent(HomeActivity.this,ShareActivity.class));
                    return true;
                case R.id.navigation_profile:
                  // final ProfileFragment profileFragment=new ProfileFragment();
                   //setfragment(profileFragment);
                    startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                    return true;
            }
            return false;
        }
    };
   /* private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(HomeActivity.this);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }*/
//---------------------------------------FireBAse----------------------------------------
private void checkCurrentUser(FirebaseUser user)
{
    if(user==null)
    {
        Intent intent=new Intent(HomeActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
    private void setUpFirebaseAuth()
    {
        mauth=FirebaseAuth.getInstance();
        mauthlistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                //check if the user is logged in
              checkCurrentUser(user);
                if (user != null) {
                    // User is signed in
                } else {
                    // User is signed out
                }
                // ...
            }
        };
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        mauth.addAuthStateListener(mauthlistener);
//       checkCurrentUser(mauth.getCurrentUser());
//    }

    @Override
    public void onStop() {
        super.onStop();
        if (mauthlistener != null) {
            mauth.removeAuthStateListener(mauthlistener);
        }
    }

    //---------------------------------------FireBAse----------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        android.support.v7.widget.Toolbar myToolbar = findViewById(R.id.custom_toolbar_home);
        setSupportActionBar(myToolbar);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setUpFirebaseAuth();
    }
    private void setfragment(Fragment fragment)
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }
    public void seeNotifications(View v){
        Intent intent=new Intent(HomeActivity.this,Notifications.class);
        startActivity(intent);
    }
    public void see_cart(View v){
        Intent intent=new Intent(HomeActivity.this,Notifications.class);
        startActivity(intent);
    }

}
