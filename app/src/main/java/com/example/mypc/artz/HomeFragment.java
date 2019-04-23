package com.example.mypc.artz;

import android.content.Context;
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
        adapter = new RecyclerViewAdapter(getActivity(),price);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
        private String[] list2;
        private Integer[] img;
        private Context context;
        Integer[] imgids={R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g};
        public RecyclerViewAdapter(Context con,String[] list2){
           this.context=con;
            this.list2=list2;
            this.img=imgids;
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
           holder.album.setImageResource(img[position]);
            holder.album_title.setText(list2[position]);
        }
        @Override
        public int getItemCount() {
            return list2.length;
        }
        public class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView album;
            TextView album_title;
            public MyViewHolder(final View itemView) {
                super(itemView);
                album = itemView.findViewById(R.id.postpicture);
                album_title = itemView.findViewById(R.id.priceimage);
            }
        }
    }

}
