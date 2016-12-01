package com.example.user.gnc.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user on 2016-12-02.
 */

public class ShortcutDAO extends SQLiteOpenHelper{
    String TAG = this.getClass().getName();
    public ShortcutDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "shortcut 테이블 생성");
        db.execSQL("create table shortcut (short_cut int, path varchar(200), method int);");
        insert();   //풀 후 첫 포팅 후 삭제
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "shortcut 테이블 호출");
        db.execSQL("drop table shortcut");//풀 후 첫 포팅 후 삭제
        onCreate(db);//풀 후 첫 포팅 후 삭제
    }

    public void insert(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("insert into shortcut ( short_cut) values (1)");
        db.execSQL("insert into shortcut ( short_cut) values (2)");
        db.execSQL("insert into shortcut ( short_cut) values (3)");
        db.execSQL("insert into shortcut ( short_cut) values (4)");
        db.execSQL("insert into shortcut ( short_cut) values (5)");
        db.close();
    }
}
