package com.example.user.gnc;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/**
 * Created by user on 2016-11-30.
 */
public class StartActivity extends Activity{
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logo = (ImageView)findViewById(R.id.logo);


        setContentView(R.layout.stater_layout);

        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                finish();

                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        };
        handler.sendEmptyMessageDelayed(0, 2000);
    }
    public void onBackPressed(){

    }
}
