package com.example.mypc.artz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class SingleCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_cart_item);
        Bundle bundle = getIntent().getExtras();
        final String image = bundle.getString("image");
        int result_image = Integer.parseInt(image);
        Button button=(Button)findViewById(R.id.shopitembtn);
        final ImageView imageView=(ImageView) findViewById(R.id.singlecartimage);
        Picasso.get().load(result_image).into(imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SingleCart.this,Receipt.class);
                final String image_post=Integer.toString(Integer.parseInt(image));
                intent.putExtra("image",image_post);
                startActivity(intent);
            }
        });

    }
}
