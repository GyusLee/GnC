package com.example.user.gnc;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    static MainActivity mainActivity;
    String TAG;

    Button bt_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startActivity(new Intent(this, StartActivity.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_setting = (Button)this.findViewById(R.id.bt_setting);
        bt_setting.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Setting(v);
    }

    public void Setting(View view){
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
}
