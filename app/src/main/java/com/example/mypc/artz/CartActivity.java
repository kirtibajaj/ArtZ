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

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ListView list=(ListView)findViewById(R.id.listviewcart);
        final Integer[] imgids={R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g};
        ListAdapter listAdapter;
        listAdapter=new ListAdapter(CartActivity.this,imgids);
        list.setAdapter(listAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(CartActivity.this,SingleCart.class);
                final String image_post=Integer.toString(imgids[position]);
                intent.putExtra("image",image_post);
                startActivity(intent);
            }
        });

    }
    class ListAdapter extends BaseAdapter {
        Context context;
        Integer[] Item;
        LayoutInflater inflater;

        public ListAdapter(Context context, Integer[] item) {
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
            ImageView Items;
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View itemView = inflater.inflate(R.layout.singlecartitem, parent, false);
            Items = (ImageView) itemView.findViewById(R.id.selectedimagepost);

            //Items.setText(Item[position]);
            Picasso.get().load(Item[position]).into(Items);
            return itemView;
        }
    }
}
