package com.main.mylibr;

import android.app.Activity;

public class CalendarPermission {
    private static final int PERMISSION_CALENDAR_REQUEST_CODE = 141;

    //check if there is permisson - if not ,  ask one time,return if there is a permission
    public static boolean checkAndRequestPermission(Activity activity,String ... permission){
         return Utils.checkAndAskForPermission(activity, PERMISSION_CALENDAR_REQUEST_CODE,permission);
    }

    //check if i can ask from user permission , if not - go to setting
    public static void askForSettingPermission(Activity activity,String ... permission){
        if(!Utils.checkSelfPermission(activity,permission))
            Utils.requestPermissionWithRationaleCheck(activity, PERMISSION_CALENDAR_REQUEST_CODE,permission);
    }

}
