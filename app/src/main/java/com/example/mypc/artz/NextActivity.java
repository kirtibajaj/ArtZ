package com.example.mypc.artz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NextActivity extends AppCompatActivity {
  private String imgUrl;

    ImageView imageView;
    Bitmap bitmap;
    TextView nextpost;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
//        Bundle bundle = getIntent().getExtras();
//        String message = bundle.getString("selected_Bitmap");
        imageView= (ImageView)findViewById(R.id.selectedimagepost);
       nextpost=(TextView)findViewById(R.id.sharepost);
       nextpost.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(NextActivity.this,HomeActivity.class);
               startActivity(intent);
           }
       });
        setImage();
        ImageView backArrow = (ImageView) findViewById(R.id.backArrow_nextprofile);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void setImage(){
       Intent intent = getIntent();
//        if(intent.hasExtra("selected_image"))
//        {
//            imgUrl = intent.getStringExtra("selected_Bitmap");
//            Picasso.get().load(imgUrl).into(imageView);
//            //UniversalImageLoader.setImage(imgUrl, image, null, mAppend);
//        }
//        else
if(intent.hasExtra("selected_Bitmap")){
            bitmap = (Bitmap) intent.getParcelableExtra("selected_Bitmap");
            imageView.setImageBitmap(bitmap);
        }
    }
}
