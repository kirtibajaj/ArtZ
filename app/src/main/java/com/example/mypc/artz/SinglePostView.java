package com.example.mypc.artz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Random;

public class SinglePostView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_post_view);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        ImageView imageView=(ImageView)findViewById(R.id.postpicture);
        ImageView imageView1=(ImageView)findViewById(R.id.display_post);
        TextView textView=(TextView)findViewById(R.id.priceimage);
        TextView textView1=(TextView)findViewById(R.id.likespost);
        Random rand = new Random();
        int n = rand.nextInt(15);
        String str1 = Integer.toString(n);
        textView1.setText(str1);
        String ImageUrl="http://www.freepngimg.com/thumb/android/31133-3-android-image.png";
        Picasso.get().load(ImageUrl).into(imageView1);
        int result = Integer.parseInt(message);
    }
}
