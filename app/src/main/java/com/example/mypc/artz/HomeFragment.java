package com.example.mypc.artz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HomeFragment extends Fragment {
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter adapter;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container,
                false);
        RecyclerView recyclerView=(RecyclerView) rootView.findViewById(R.id.home_grid);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
       recyclerView.setLayoutManager(layoutManager);
        String[] price={"1200/-","200/-","1600/-","345/-","220/-","640/-","449/-"};
        Integer[] Likes={4,12,3,16,9,8,11};
        Integer[] imgids={R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g};
        adapter = new RecyclerViewAdapter(getActivity(),price,Likes,imgids);
        recyclerView.setAdapter(adapter);
        return rootView;
    }
    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
        private String[] list2;//price
        private Integer[] img;
        private Integer[] list1;//likes
        private Context context;
        public RecyclerViewAdapter(Context con,String[] list2, Integer[] list1, Integer[] img){
           this.context=con;
            this.list2=list2;
            this.list1=list1;
            this.img=img;
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_single_post_view,parent,false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }
        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
           holder.postimage.setImageResource(img[position]);
            holder.price.setText(list2[position]);
            holder.likes.setText(Integer.toString(list1[position]));
            final String image_post=Integer.toString(img[position]);
            final String price_post=list2[position];
            final String likes_post=Integer.toString(list1[position]);
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getActivity(),SinglePostView.class);
                    intent.putExtra("image",image_post);
                    intent.putExtra("price",price_post);
                    intent.putExtra("likes",likes_post);
                    startActivity(intent);
                }
            });
        }
        @Override
        public int getItemCount() {
            return list2.length;
        }
        public class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView postimage;
            TextView likes;
            TextView price;
            LinearLayout linearLayout;
            public MyViewHolder(final View itemView) {
                super(itemView);
                postimage = itemView.findViewById(R.id.postpicture);
                price = itemView.findViewById(R.id.priceimage);
                likes=itemView.findViewById(R.id.likespost);
                linearLayout=itemView.findViewById(R.id.heystart);
            }
        }
    }

}
