package com.example.user.gnc;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

import com.example.user.gnc.com.example.user.gnc.settings.MyDB;
import com.example.user.gnc.db.ImageDAO;
import com.example.user.gnc.db.ShortcutDAO;

/**
 * Created by Jusung on 2016. 11. 29..
 */

public class defaultAct extends Activity {
    String TAG;
    static final int WINDOW_ALERT_REQUEST = 1;
    public static ImageDAO imageDAO;
    public static ShortcutDAO shortcutDAO;
    public static defaultAct defaultAct;
    MyDB myDB;
    public static SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        TAG = this.getClass().getName();
        defaultAct = this;
        imageDAO = new ImageDAO(this, "image_info.db", null, 1);
        shortcutDAO = new ShortcutDAO(this, "shorstcut.db", null, 1);

        //권한 주기
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            boolean floatingWindowPermission = Settings.canDrawOverlays(this);
            Log.d(TAG, floatingWindowPermission + "permission");

            if (floatingWindowPermission == false) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, WINDOW_ALERT_REQUEST);
            } else {
                startService(new Intent(this, StartActivity.class));
            }
        } else {
            startService(new Intent(this, StartActivity.class));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case WINDOW_ALERT_REQUEST:
                if (resultCode == RESULT_CANCELED) {
                }
        }
    }

    public void init(){
        myDB = new MyDB(this,"iot.sqlite",null,1);
        db =myDB.getWritableDatabase();
    }



}
