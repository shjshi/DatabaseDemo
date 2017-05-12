package com.shj.databasedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shj.databasedemo.database.DBOpenHandlerTest;

public class MainActivity extends AppCompatActivity {

    private DBOpenHandlerTest test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         test = new DBOpenHandlerTest(this);

    }
    public void create(View v){
        test.testCreate();
    }
    public void del(View v){
        try {
            test.testDelete();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    public void save(View v){
        try {
            test.testSave();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    public void find(View v){
        try {
            test.testFind();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    public void findall(View v){
        try {
            test.testFindAll();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    public void update(View v){
        try {
            test.testUpate();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    public void count(View v){
        try {
            test.testGetCount();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
