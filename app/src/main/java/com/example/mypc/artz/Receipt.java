package com.example.mypc.artz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Receipt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receipt_shop_item);
        Button button=(Button)findViewById(R.id.button_item_shipped);
        ImageView imageView=(ImageView)findViewById(R.id.receipt_item);
        Bundle bundle = getIntent().getExtras();
        String image = bundle.getString("image");
        int result_image = Integer.parseInt(image);
        Picasso.get().load(result_image).into(imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Receipt.this, "Item Added and Processed", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Receipt.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}