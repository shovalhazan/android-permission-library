package com.main.mylibr;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;

public class CameraAndGalleryPermission {
    private static final int TAKE_PHOTO_REQUEST_CODE=131;
    private static final int CHOOSE_FROM_GALLERY_REQUEST_CODE=132;
    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS =133 ;


    private static void cameraOrGalleryDialog(Activity context){
        Log.d("Pttt", "chooseImage: ");
        final CharSequence[] optionsMenu = {"Take Photo", "Choose from Gallery", "Exit" }; // create a menuOption Array
        // create a dialog for showing the optionsMenu
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // set the items in builder
        builder.setItems(optionsMenu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(optionsMenu[i].equals("Take Photo")){
                    // Open the camera and get the photo
                    Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    context.startActivityForResult(takePicture, TAKE_PHOTO_REQUEST_CODE);
                }
                else if(optionsMenu[i].equals("Choose from Gallery")){
                    // choose from  external storage
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    context.startActivityForResult(pickPhoto , CHOOSE_FROM_GALLERY_REQUEST_CODE);
                }
                else if (optionsMenu[i].equals("Exit")) {
                    dialogInterface.dismiss();
                }
            }
        });
        builder.show();
    }



    public static void askForSettingPermission(Activity activity,String ... permission){
        if(!Utils.checkSelfPermission(activity,permission))
            Utils.requestPermissionWithRationaleCheck(activity,REQUEST_ID_MULTIPLE_PERMISSIONS
                    ,permission);
    }

    public static boolean  checkAndRequestCameraAndGalleryPermission( Activity context,String ... permission) {
        return Utils.checkAndAskForPermission(context, REQUEST_ID_MULTIPLE_PERMISSIONS, permission);
    }
}

