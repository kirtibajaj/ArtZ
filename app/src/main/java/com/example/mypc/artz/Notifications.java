package com.example.mypc.artz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Notifications extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        ListView list=(ListView)findViewById(R.id.listviewnotify);
        imageView=(ImageView)findViewById(R.id.notifyimage);
        String[] notify={"abc.hii Liked your Picture","aastha.jain started following you","You started following manish.shnl"};
        ListAdapter1 listAdapter;
        listAdapter=new ListAdapter1(Notifications.this,notify);
        list.setAdapter(listAdapter);


    }
    class ListAdapter1 extends BaseAdapter {
        Context context;
        String[] Item;
        LayoutInflater inflater;
        public ListAdapter1(Context context, String[] item) {
            this.context = context;
            this.Item = item;
        }
        public int getCount() {
            return Item.length;
        }
        public Object getItem(int position) {
            return null;
        }
        public long getItemId(int position) {
            return 0;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView Items;
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View itemView = inflater.inflate(R.layout.notification_single_item, parent, false);
            Items = (TextView) itemView.findViewById(R.id.notify);
            Items.setText(Item[position]);
//           // Picasso.get().load(Item[position]).into(Items);
//            String ImageUrl="http://www.freepngimg.com/thumb/android/31133-3-android-image.png";
//            Picasso.get().load(ImageUrl).into(imageView);
            return itemView;
        }
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Notifications.this,HomeActivity.class));
    }
}
