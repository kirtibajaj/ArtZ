package com.example.mypc.artz;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PhotoFragment extends Fragment {
    private static final int PHOTO_FRAGMENT_NUM = 1;
    private static final int  CAMERA_REQUEST_CODE = 5;
    private static final String TAG = "PhotoFragment";
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle SavedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_camera,container,false);
        Button buttonlaunchcamera=(Button)view.findViewById(R.id.buttononcamera);
        buttonlaunchcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((ShareActivity)getActivity()).getCurrentTabNumber() == PHOTO_FRAGMENT_NUM){
                    if(((ShareActivity)getActivity()).checkPermissions(Permissions.CAMERA_PERMISSION[0])){
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
                    }else {
                        Intent intent = new Intent(getActivity(), ShareActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }}
            }
        });
        return view;
    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode == CAMERA_REQUEST_CODE){
//            Log.d(TAG, "onActivityResult: done taking a photo.");
//            Log.d(TAG, "onActivityResult: attempting to navigate to final share screen.");
//
//            Bitmap bitmap;
//            bitmap = (Bitmap) data.getExtras().get("data");
//
//            if(isRootTask()){
//                try{
//                    Log.d(TAG, "onActivityResult: received new bitmap from camera: " + bitmap);
//                    Intent intent = new Intent(getActivity(), NextActivity.class);
//                    intent.putExtra(getString(R.string.selected_bitmap), bitmap);
//                    startActivity(intent);
//                }catch (NullPointerException e){
//                    Log.d(TAG, "onActivityResult: NullPointerException: " + e.getMessage());
//                }
//            }else{
//                try{
//                    Log.d(TAG, "onActivityResult: received new bitmap from camera: " + bitmap);
//                    Intent intent = new Intent(getActivity(), AccountSettingsActivity.class);
//                    intent.putExtra(getString(R.string.selected_bitmap), bitmap);
//                    intent.putExtra(getString(R.string.return_to_fragment), getString(R.string.edit_profile_fragment));
//                    startActivity(intent);
//                    getActivity().finish();
//                }catch (NullPointerException e){
//                    Log.d(TAG, "onActivityResult: NullPointerException: " + e.getMessage());
//                }
//            }
//
//        }
 //   }
}
