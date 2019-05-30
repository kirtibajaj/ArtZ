package com.example.mypc.artz;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Random;

public class SinglePostView extends AppCompatActivity {
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_post_view);
        Bundle bundle = getIntent().getExtras();
        String image = bundle.getString("image");
        String price=bundle.getString("price");
        String likes=bundle.getString("likes");
        ImageView imageView=(ImageView)findViewById(R.id.postpicture);
        ImageView imageView1=(ImageView)findViewById(R.id.display_post);
        TextView textView=(TextView)findViewById(R.id.priceimage);
        TextView textView1=(TextView)findViewById(R.id.likespost);
        final ImageView likeit=(ImageView) findViewById(R.id.heart_post);
        ImageView addtocart=(ImageView)findViewById(R.id.cart_post);
//        Random rand = new Random();
//        int n = rand.nextInt(15);
//        String str1 = Integer.toString(n);
//        textView1.setText(str1);
        int result_likes = Integer.parseInt(likes);
        x=0;
        likeit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             likeit.setColorFilter(ContextCompat.getColor(SinglePostView.this,R.color.icon));
           x+=1;
            }
        });
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SinglePostView.this,CartActivity.class);
                startActivity(intent);
            }
        });
        result_likes+=1;
        String result_like=Integer.toString(result_likes);
        textView.setText(price);
        textView1.setText(result_like);
        String ImageUrl="http://www.freepngimg.com/thumb/android/31133-3-android-image.png";
        Picasso.get().load(ImageUrl).into(imageView1);
       int result_image = Integer.parseInt(image);
        Picasso.get().load(result_image).into(imageView);
    }
}
