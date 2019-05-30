package com.example.mypc.artz;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class GalleryFragment extends Fragment{
    //constants
    private static final int NUM_GRID_COLUMNS = 3;
    //widgets
    private ImageView galleryImage;
    Spinner directorySpinner;
    private  ArrayList<String> directories;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_gallery,container,false);
        galleryImage = (ImageView) view.findViewById(R.id.galleryimageview);
        directorySpinner = (Spinner) view.findViewById(R.id.spinnerDirectory);
        directories = new ArrayList<>();
        ImageView shareClose=(ImageView)view.findViewById(R.id.ivCloseShare);
        shareClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
      Picasso.get().load("http://www.freepngimg.com/thumb/android/31133-3-android-image.png").into(galleryImage);
        TextView nextScreen = (TextView) view.findViewById(R.id.tvNext);
        nextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NextActivity.class);
                startActivity(intent); }
        });
        init();
        return view;
    }

private void init(){
    FilePaths filePaths = new FilePaths();
    //check for other folders indide "/storage/emulated/0/pictures"
    if (FileSearch.getDirectoryPaths(filePaths.PICTURES) != null) {
        directories = FileSearch.getDirectoryPaths(filePaths.PICTURES);
    }
    directories.add(filePaths.CAMERA);
    ArrayList<String> directoryNames = new ArrayList<>();
    for (int i = 0; i < directories.size(); i++) {
        int index = directories.get(i).lastIndexOf("/");
        String string = directories.get(i);//.substring(index);
        Log.d("File path645",string);
        directoryNames.add(string);
    }
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
            android.R.layout.simple_spinner_item, directoryNames);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    directorySpinner.setAdapter(adapter);
}

}
