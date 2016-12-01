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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "shortcut 테이블 호출");
    }
}
