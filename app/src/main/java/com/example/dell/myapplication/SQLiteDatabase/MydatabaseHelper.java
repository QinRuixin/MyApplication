package com.example.dell.myapplication.SQLiteDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MydatabaseHelper extends SQLiteOpenHelper {

    private static final String CREATE_PASS =
            "create table Pass(" +
            "id integer primary key autoincrement," +
            "name text," +
            "pass integer)";


    private static final String CREATE_WORDS =
            "create table Words(" +
            "id integer primary key autoincrement," +
            "name text," +
            "words text)";

    private Context mContext;

    public MydatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PASS);
        db.execSQL(CREATE_WORDS);
        Toast.makeText(mContext, "开始记录进度", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Pass");
        db.execSQL("drop table if exists Words");
        onCreate(db);
        Toast.makeText(mContext, "更新表", Toast.LENGTH_LONG).show();

    }
}
