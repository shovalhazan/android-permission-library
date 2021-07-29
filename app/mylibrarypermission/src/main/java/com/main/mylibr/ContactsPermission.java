package com.main.mylibr;

import android.Manifest;
import android.app.Activity;

public class ContactsPermission {
    private static final int PERMISSION_CONTACT_REQUEST_CODE = 121;

    public static boolean  checkAndRequestPermission(Activity activity,String ... permission) {
        return Utils.checkAndAskForPermission(activity, PERMISSION_CONTACT_REQUEST_CODE,permission);
    }

    public static void askForSettingPermission(Activity activity,String ... permission){
        if(!Utils.checkSelfPermission(activity,Manifest.permission.READ_CONTACTS))
            Utils.requestPermissionWithRationaleCheck(activity, PERMISSION_CONTACT_REQUEST_CODE,permission);
    }
}
