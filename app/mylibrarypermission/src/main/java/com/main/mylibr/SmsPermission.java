package com.main.mylibr;

import android.app.Activity;

public class SmsPermission {
    private static final int PERMISSION_SMS_REQUEST_CODE = 161;

    //check if there is permisson - if not ,  ask one time,return if there is a permission
    public static boolean checkAndRequestSmsPermission(Activity activity,String... permission){
        return Utils.checkAndAskForPermission(activity, PERMISSION_SMS_REQUEST_CODE,permission);
    }

    //check if i can ask from user permission , if not - go to setting
    public static void askForSettingPermission(Activity activity,String... permission){
        if(!Utils.checkSelfPermission(activity,permission))
            Utils.requestPermissionWithRationaleCheck(activity, PERMISSION_SMS_REQUEST_CODE,permission);
    }
}
