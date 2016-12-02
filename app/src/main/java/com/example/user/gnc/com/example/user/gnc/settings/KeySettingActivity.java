package com.example.user.gnc.com.example.user.gnc.settings;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.gnc.R;
import com.example.user.gnc.defaultAct;

import static android.R.attr.name;
import static android.content.ContentValues.TAG;

/**
 * Created by Jusung on 2016. 11. 30..
 */

public class KeySettingActivity extends Activity {
    String number;
    String TAG;
    String name, phoneNumber;

    private static final int REQUEST_SELECT_PHONE_NUMBER = 1;
    TextView txt_doubleClick,txt_right,txt_left,txt_bottom,txt_top;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getName();

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

                        /*// AlertDialog 안에 있는 AlertDialog
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
                        innBuilder.show();*/
                        String strName = adapter.getItem(id);
                        if (strName.equals("전화 걸기")) {
                            selectContact();
                        } else if (strName.equals("앱 실행")) {
                            selectApp();
                        } else if (strName.equals("웹 실행")) {

                        }

                        /*Log.d(TAG,"번호"+number);
                        txt_doubleClick.setText(number);*/
                    }
                });
        alertBuilder.show();
    }

    /*전화번호부 가져오기*/
    public void selectContact() {
        // Start an activity for the user to pick a phone number from contacts
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_PHONE_NUMBER);
        }
    }

    public void selectApp() {
        Intent intent = new Intent(this, AppListActivity.class);
        startActivity(intent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SELECT_PHONE_NUMBER && resultCode == RESULT_OK) {
            // Get the URI and query the content provider for the phone number
            Uri contactUri = data.getData();
            String[] projection = new String[]{
                    ContactsContract.CommonDataKinds.Phone.NUMBER
            };
            Cursor cursor = getContentResolver().query(contactUri, projection,
                    null, null, null);
            // If the cursor returned is valid, get the phone number
            if (cursor != null && cursor.moveToFirst()) {
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                number = cursor.getString(numberIndex);
                // Do something with the phone number
                Log.d(TAG,"number는?"+number);
                txt_doubleClick.setText(number);
            }
        }
    }
}
