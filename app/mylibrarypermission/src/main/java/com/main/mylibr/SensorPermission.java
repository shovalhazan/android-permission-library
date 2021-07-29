package com.main.mylibr;

import android.app.Activity;

public class SensorPermission {
        private static final int PERMISSION_SENSOR_REQUEST_CODE = 171;

        //check if there is permisson - if not ,  ask one time,return if there is a permission
        public static boolean checkAndRequestSensorPermission(Activity activity,String... permission){
            return Utils.checkAndAskForPermission(activity, PERMISSION_SENSOR_REQUEST_CODE, permission);
        }

        //check if i can ask from user permission , if not - go to setting
        public static void askForSettingPermission(Activity activity,String... permission){
            if(!Utils.checkSelfPermission(activity,permission))
                Utils.requestPermissionWithRationaleCheck(activity, PERMISSION_SENSOR_REQUEST_CODE,permission);
        }
}
