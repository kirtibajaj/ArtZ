package com.example.mypc.artz;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private static final int ACTIVITY_NUM = 2;
    private Context mContext=ProfileActivity.this;
    private ImageView profilephoto;
    Integer[] imgids={R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g};
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setUpToolbar();
        setupActivityWidget();
         setupProfilePhoto();
       // viewImageGrid();
        setupImageGrid();
        TextView textView=(TextView)findViewById(R.id.textEditProfile);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this,Edit_profile.class));
            }
        });
    }
    private void setupImageGrid()
    {
        GridView gridView=(GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapterGridView(this));
    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
                String message=Integer.toString(imgids[position]);
                Intent intent=new Intent(ProfileActivity.this,SinglePostView.class);
                intent.putExtra("message", message);
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Item " + (position + 1) + " Selected", Toast.LENGTH_LONG).show();
            }
        });
        //GridImageAdapter adapter=new GridImageAdapter(mContext,R.layout.layout_grid_imageview,"",ImgURL);
        //gridView.setAdapter(adapter);
    }
    private void setupProfilePhoto()
    {
        String ImageUrl="http://www.freepngimg.com/thumb/android/31133-3-android-image.png";
        Picasso.get().load(ImageUrl).into(profilephoto);
    }
    private void setupActivityWidget() {
    profilephoto = (ImageView)findViewById(R.id.profile_photo);
    }
    //-------------------------------------Tool Bar Set Up----------------------------------------------------------------------
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);
        ImageView imageview=(ImageView)findViewById(R.id.profileMenu);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, ActivityAccountSetting.class));
            }
        });
            }

public class ImageAdapterGridView extends BaseAdapter {
    private Context mContext;

    public ImageAdapterGridView(Context c) {
        mContext = c;
    }

    public int getCount() {
        return imgids.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView mImageView;
        if (convertView == null) {
            mImageView = new ImageView(mContext);
            mImageView.setLayoutParams(new GridView.LayoutParams(330, 330));
           mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
         //   mImageView.setPadding(16, 16, 16, 16);
        } else {
            mImageView = (ImageView) convertView;
        }
        mImageView.setImageResource(imgids[position]);
        return mImageView;
    }
}
}