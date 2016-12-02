package com.example.user.gnc.com.example.user.gnc.settings;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.gnc.R;

/**
 * Created by Jusung on 2016. 11. 30..
 */

public class KeySettingActivity extends Activity {
    TextView txt_doubleClick,txt_right,txt_left,txt_bottom,txt_top;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.key_setting_activity);
        txt_doubleClick = (TextView)findViewById(R.id.txt_doubleClick);
        txt_right = (TextView)findViewById(R.id.txt_right);
        txt_left = (TextView)findViewById(R.id.txt_left);
        txt_top = (TextView)findViewById(R.id.txt_top);
        txt_bottom = (TextView)findViewById(R.id.txt_bottom);

        txt_doubleClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        txt_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        txt_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        txt_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        txt_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }
    public void showDialog(){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(
                KeySettingActivity.this);
        alertBuilder.setIcon(R.drawable.logo);
        alertBuilder.setTitle("항목중에 하나를 선택하세요.");

        // List Adapter 생성
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                KeySettingActivity.this,
                android.R.layout.select_dialog_singlechoice);
        adapter.add("전화 걸기");
        adapter.add("앱 실행");
        adapter.add("웹 실행");




        // 버튼 생성
        alertBuilder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        dialog.dismiss();
                    }
                });

        // Adapter 셋팅
        alertBuilder.setAdapter(adapter,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int id) {

                        // AlertDialog 안에 있는 AlertDialog
                        String strName = adapter.getItem(id);
                        AlertDialog.Builder innBuilder = new AlertDialog.Builder(
                                KeySettingActivity.this);
                        innBuilder.setMessage(strName);
                        innBuilder.setTitle("당신이 선택한 것은 ");
                        innBuilder
                                .setPositiveButton(
                                        "확인",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                                                dialog.dismiss();
                                            }
                                        });
                        innBuilder.show();
                    }
                });
        alertBuilder.show();
    }
}
