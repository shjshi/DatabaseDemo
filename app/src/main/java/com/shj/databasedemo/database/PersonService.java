package com.shj.databasedemo.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reus on 2017/5/2.
 */

public class PersonService {

    private DBOpenHandler dbOpenHandler;

    public PersonService(Context context){
        this.dbOpenHandler=new DBOpenHandler(context);
    }
    public void save(Person person){
        SQLiteDatabase db=dbOpenHandler.getWritableDatabase();
        db.execSQL("insert into person (name) values(?)", new Object[]{person.getName()});
    }
    public void delete(Integer id){
        SQLiteDatabase db=dbOpenHandler.getWritableDatabase();
        db.execSQL("delete from person where id=?", new Object[]{id.toString()});

    }
    public void update(Person person){
        SQLiteDatabase db=dbOpenHandler.getWritableDatabase();
        db.execSQL("update person set name=? where" +
                " id=?", new Object[]{person.getName(),person.getId()});
    }
    public Person find(Integer id){
        Person person=null;
        SQLiteDatabase db=dbOpenHandler.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from person where id=?", new String[]{id.toString()});
        if(cursor.moveToFirst()) {
            person=new Person();
            person.setId(cursor.getInt(cursor.getColumnIndex("id")));
            person.setName(cursor.getString(cursor.getColumnIndex("name")));
        }
        return person;
    }
    public List<Person> findAll(Integer offset, Integer maxLength){
        List<Person> lists=new ArrayList<Person>();
        Person person=null;
        SQLiteDatabase db=dbOpenHandler.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from person limit ?,?", new String[]{offset.toString(),maxLength.toString()});
        while(cursor.moveToNext()){
            person=new Person();
            person.setId(cursor.getInt(cursor.getColumnIndex("id")));
            person.setName(cursor.getString(cursor.getColumnIndex("name")));
            lists.add(person);
        }
        return lists;
    }
    public long getCount(){
        SQLiteDatabase db=dbOpenHandler.getReadableDatabase();
        Cursor cursor=db.rawQuery("select count(*) from person ", null );
        cursor.moveToFirst();
        return cursor.getLong(0);
    }
}
