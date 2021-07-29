package com.main.permissionsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import com.main.mylibr.CalendarPermission;
import com.main.mylibr.CameraAndGalleryPermission;
import com.main.mylibr.ContactsPermission;
import com.main.mylibr.MicrophonePermission;
import com.main.mylibr.PhonePermission;
import com.main.mylibr.SensorPermission;
import com.main.mylibr.SmsPermission;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}