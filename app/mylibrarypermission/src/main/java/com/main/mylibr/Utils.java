package com.main.mylibr;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Utils {
    private static final int PERMISSION_FROM_SETTING_REQUEST_CODE = 113;

    protected static boolean checkAndAskForPermission(Activity activity,int code,String ... permission) {
        boolean flag = true;
        flag = flag && (checkSelfPermission(activity, permission));
        if (!flag)
            requestPermissions(activity, code, permission);
        return flag;
    }

    protected static void requestPermissions(Activity activity,int code,String ...permission) {
                Log.d("pttt", "shouldShowRequestPermissionRationale = true");
                // Show user description for what we need the permission
                ActivityCompat.requestPermissions(activity,
                        permission,
                        code);
    }
    protected static void requestPermissionWithRationaleCheck(Activity activity,int code,String ...permission) {
        for (String p : permission) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, p)) {
                Log.d("pttt", "shouldShowRequestPermissionRationale = true");
                // Show user description for what we need the permission
                ActivityCompat.requestPermissions(activity,
                        permission,
                        code);
                return;
            } else {
                openPermissionSettingDialog(activity, PERMISSION_FROM_SETTING_REQUEST_CODE);
                return;
            }
        }
    }


    protected static boolean checkSelfPermission(Activity activity,String... permission){
        boolean flag = true;
        for (String s : permission) {
            flag = (ContextCompat.checkSelfPermission(activity, s)==PackageManager.PERMISSION_GRANTED);
        }
        return flag;
    }

    protected  static void openPermissionSettingDialog(Activity activity, int code) {
        String message = "Setting screen user have permanently d" +
                "isable the permission by clicking Don't ask again checkbox.-WE HAVE TO GET YOUR PERMISSION";
        AlertDialog alertDialog =
                new AlertDialog.Builder(activity)
                        .setMessage(message)
                        .setPositiveButton(activity.getString(android.R.string.ok),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent();
                                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                        Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
                                        intent.setData(uri);
                                        activity.startActivityForResult(intent, code);
                                        dialog.cancel();
                                    }
                                }).show();
        alertDialog.setCanceledOnTouchOutside(false);
    }

}
