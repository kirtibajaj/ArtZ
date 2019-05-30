package com.example.mypc.artz;

import android.content.Intent;
import android.media.audiofx.AudioEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Edit_profile extends AppCompatActivity {
 private ImageView sproflephoto;
 private EditText username;
 private EditText displayname;
 private EditText website;
 private EditText description;
 private EditText email;
 private EditText phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        sproflephoto=(ImageView)findViewById(R.id.profile_photo);
        ImageView imageView=(ImageView)findViewById(R.id.saveChanges);
        username=(EditText)findViewById(R.id.username);
        displayname=(EditText)findViewById(R.id.display_name);
        website=(EditText)findViewById(R.id.website);
        description=(EditText)findViewById(R.id.description);
        email=(EditText)findViewById(R.id.email);
        phone=(EditText)findViewById(R.id.phoneNumber);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Edit_profile.this, "Your Information Edited", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Edit_profile.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
       setProfileImage();
        ImageView backArrow = (ImageView) findViewById(R.id.backArrow_editprofile);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void setProfileImage()
    {
        String ImageUrl="http://2.bp.blogspot.com/-qcMcQ0Zre-g/U7oC0yixcLI/AAAAAAAAdcU/9E8O61ISK6k/s1600/Best-Custom-Icon-Packs-for-Android.jpg";
        Picasso.get().load(ImageUrl).into(sproflephoto);
    }
}
