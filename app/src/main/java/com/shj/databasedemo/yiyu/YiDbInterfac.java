package com.shj.databasedemo.yiyu;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reus on 2017/5/12.
 * 这个类主要提供数据库的接口
 */

public class YiDbInterfac {
    private static YiDbInterfac instance;
    private YiyuSQLiteOpenHelper helper;
    private SQLiteDatabase db;
    //在构造方法中获取helper，获取db，在获取数据库接口对象的时候，也会对数据库进行初始化，这个是什么设计模式？我的构造方法中有你
    private YiDbInterfac(Context context){
        if (helper==null){
            helper = new YiyuSQLiteOpenHelper(context,"shj");
            db = helper.getWritableDatabase();
        }
    }

    //获取对外提供接口的对象
    public static YiDbInterfac getInstance(Context context){
        if (instance==null){
            instance = new YiDbInterfac(context);
        }
        return instance;
    }
    public List<Person> getAllPerson(){
        List<Person> list = new ArrayList<Person>();
        if (db == null) {
            return list;
        }
        String sql = "select * from "+TableField.TABLE_PERSON;
        //rawQuery
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()) {
            Person person = new Person();
            person.id = cursor.getInt(cursor.getColumnIndex(TableField.FIELD_PERSON_ID));
            person.name = cursor.getString(cursor.getColumnIndex(TableField.FIELD_PERSON_NAME));
            person.sex = cursor.getString(cursor.getColumnIndex(TableField.FIELD_PERSON_SEX));
            list.add(person);
        }
        cursor.close();
        return list;
    }
    public void insertPerson(Person p){
        ContentValues values = new ContentValues();
        values.put(TableField.FIELD_PERSON_ID,p.id);
        values.put(TableField.FIELD_PERSON_NAME,p.name);
        values.put(TableField.FIELD_PERSON_SEX,p.sex);
        db.insert(TableField.TABLE_PERSON,null,values);
    }
    public void del(Person p){
        db.delete(TableField.TABLE_PERSON,TableField.FIELD_PERSON_ID+"=?",new String[]{p.id+""});
    }
    public void del(){
        String sql = "delete * from "+ TableField.TABLE_PERSON;
        db.execSQL(sql);
    }
    public void update(Person p){
        ContentValues values = new ContentValues();
        values.put(TableField.FIELD_PERSON_NAME,p.name);
        db.update(TableField.TABLE_PERSON,values,TableField.FIELD_PERSON_ID+"=?",new String[]{p.id+""});
    }
}

