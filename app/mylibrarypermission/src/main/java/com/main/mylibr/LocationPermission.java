package com.main.mylibr;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class LocationPermission {

    private static final int PERMISSION_REGULAR_LOCATION_REQUEST_CODE = 111;
    private static final int PERMISSION_BACKGROUND_LOCATION_REQUEST_CODE = 112;

    /*An app requires background location access if a feature within the app constantly shares location with other users or uses the Geofencing API.
    fine-Provides an estimate of the device's location, to within about 1 mile (0.6 km).
        coarse-Provides an estimate of the device's location that is as accurate as possible, usually within about 160 feet (50 meters) and sometimes as accurate as within 10 feet (a few meters) or better.
         */
    public static boolean  checkAndRequestLocationPermission(Activity activity) {
        boolean flag = true;
        boolean t = Utils.checkAndAskForPermission(activity,PERMISSION_REGULAR_LOCATION_REQUEST_CODE,Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION);
        boolean per3 = android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.Q || Utils.checkSelfPermission(activity, Manifest.permission.ACCESS_BACKGROUND_LOCATION);

        if(!t&&!per3)
           flag= Utils.checkAndAskForPermission(activity,PERMISSION_BACKGROUND_LOCATION_REQUEST_CODE,Manifest.permission.ACCESS_BACKGROUND_LOCATION);
        return flag;
    }



    public static void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults, Activity activity){
        switch (requestCode) {
            case PERMISSION_REGULAR_LOCATION_REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("pttt", "test: GRANT");
                }else {
                    Utils.requestPermissionWithRationaleCheck(activity,PERMISSION_REGULAR_LOCATION_REQUEST_CODE,Manifest.permission.ACCESS_FINE_LOCATION);
                }
                return;
            }
            case PERMISSION_BACKGROUND_LOCATION_REQUEST_CODE: {
                Log.d("pttt", "BACKGROUND_LOCATION_CODE");
                Utils.requestPermissionWithRationaleCheck(activity,PERMISSION_BACKGROUND_LOCATION_REQUEST_CODE,Manifest.permission.ACCESS_BACKGROUND_LOCATION);
                return;
            }
        }
    }

}
