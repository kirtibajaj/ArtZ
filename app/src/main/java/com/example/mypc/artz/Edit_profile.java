package com.example.mypc.artz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Edit_profile extends AppCompatActivity {
 private ImageView sproflephoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        sproflephoto=(ImageView)findViewById(R.id.profile_photo);
      //  initImageLoader();
       setProfileImage();
        ImageView backArrow = (ImageView) findViewById(R.id.backArrow_editprofile);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initImageLoader(){
       // UniversalImageLoader universalImageLoader = new UniversalImageLoader(Edit_profile.this);
      //  ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }

    private void setProfileImage()
    {
        String ImageUrl="http://2.bp.blogspot.com/-qcMcQ0Zre-g/U7oC0yixcLI/AAAAAAAAdcU/9E8O61ISK6k/s1600/Best-Custom-Icon-Packs-for-Android.jpg";
        Picasso.get().load(ImageUrl).into(sproflephoto);

    }

}
