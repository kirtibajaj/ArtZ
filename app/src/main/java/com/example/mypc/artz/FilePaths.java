package com.example.mypc.artz;

import android.os.Environment;

public class FilePaths {
    //"storage/emulated/0"
    public String ROOT_DIR = Environment.getExternalStorageDirectory().getPath();
    public String PICTURES = ROOT_DIR + "/Pictures";
    public String CAMERA = ROOT_DIR + "/DCIM/camera";
   // public String STORIES = ROOT_DIR + "/Stories";
   // public String FIREBASE_STORY_STORAGE = "stories/users";
   // public String FIREBASE_IMAGE_STORAGE = "photos/users/";
}
