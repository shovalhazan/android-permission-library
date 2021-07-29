package com.main.mylibr;

import android.Manifest;
import android.app.Activity;

public class MicrophonePermission {
    private static final int PERMISSION_MICROPHONE_REQUEST_CODE = 181;

    //check if there is permisson - if not ,  ask one time,return if there is a permission
    public static boolean checkAndRequestMicrophonePermission(Activity activity ,String... permission){
        return Utils.checkAndAskForPermission(activity, PERMISSION_MICROPHONE_REQUEST_CODE, permission);
    }

    //check if i can ask from user permission , if not - go to setting
    public static void askForSettingPermission(Activity activity ,String... permission){
        if(!Utils.checkSelfPermission(activity,permission))
            Utils.requestPermissionWithRationaleCheck(activity, PERMISSION_MICROPHONE_REQUEST_CODE,permission);
    }
}
