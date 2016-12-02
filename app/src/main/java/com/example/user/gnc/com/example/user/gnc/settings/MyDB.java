package com.example.user.gnc.com.example.user.gnc.settings;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by wbhlkc0 on 2016-12-02.
 */

public class MyDB extends SQLiteOpenHelper{
    String TAG;
    public MyDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        TAG=this.getClass().getName();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG,"onCreate호출");
        //전화 정보 테이블
        StringBuffer sql=new StringBuffer();
        sql.append("create table cal(");
        sql.append("key_id integer primary key,");
        sql.append("key_name varchar(20),");
        sql.append("phone varchar(20)");
        sql.append(");");

        sqLiteDatabase.execSQL(sql.toString());
        Log.d(TAG,"전화 데이터베이스 생성");

        //앱 실행 정보 테이블

        //웹 실행 정보 테이블

        //이미지 변경 정보 테이블

        //초기위치 정보 테이블
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG,"onUpGrade 호출");
    }
}
