package com.shj.databasedemo.yiyu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Reus on 2017/5/12.
 *
 */

public class YiyuSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final int  ver = 1;
    public YiyuSQLiteOpenHelper(Context context, String name) {
        super(context, name, null, ver);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    private void createTable(SQLiteDatabase db) {
        String sql_create_table_person = "CREATE TABLE IF NOT EXISTS "+TableField.TABLE_PERSON
                                            +"("
                                                +TableField.FIELD_PERSON_ID +" INTEGER,"
                                                +TableField.FIELD_PERSON_NAME+" text,"
                                                +TableField.FIELD_PERSON_SEX+" text"
                                            +")";
        db.execSQL(sql_create_table_person);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
