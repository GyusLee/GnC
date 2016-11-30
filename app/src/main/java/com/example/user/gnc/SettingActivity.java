package com.example.user.gnc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.user.gnc.R;
import com.example.user.gnc.com.example.user.gnc.settings.IconSettingActivity;
import com.example.user.gnc.com.example.user.gnc.settings.KeySettingActivity;
import com.example.user.gnc.com.example.user.gnc.settings.LocationSettingActivity;
import com.example.user.gnc.com.example.user.gnc.settings.SizeSettingActivity;

/**
 * Created by user on 2016-11-30.
 */

public class SettingActivity extends Activity {
    LinearLayout bt_icon,bt_key,bt_size,bt_location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);
        bt_key=(LinearLayout)findViewById(R.id.bt_key);
        bt_icon=(LinearLayout)findViewById(R.id.bt_icon);
        bt_size=(LinearLayout)findViewById(R.id.bt_size);
        bt_location=(LinearLayout)findViewById(R.id.bt_location);

    }
    public void btnClick(View view){
        switch (view.getId()){
            case R.id.bt_key:
                Toast.makeText(this, "키 변경하기", Toast.LENGTH_SHORT).show();
                Intent key_intent = new Intent(this, KeySettingActivity.class);
                startActivity(key_intent);
                break;
            case R.id.bt_icon:
                Toast.makeText(this, "아이콘 변경하기", Toast.LENGTH_SHORT).show();
                Intent icon_intent = new Intent(this, IconSettingActivity.class);
                startActivity(icon_intent);
                break;
            case R.id.bt_location:
                Toast.makeText(this, "위치 변경하기", Toast.LENGTH_SHORT).show();
                Intent location_intent = new Intent(this, LocationSettingActivity.class);
                startActivity(location_intent);
                break;
            case R.id.bt_size:
                Toast.makeText(this, "크기 변경하기", Toast.LENGTH_SHORT).show();
                Intent size_intent = new Intent(this, SizeSettingActivity.class);
                startActivity(size_intent);
                break;
        }
    }
}
