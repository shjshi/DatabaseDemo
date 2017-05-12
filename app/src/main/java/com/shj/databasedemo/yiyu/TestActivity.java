package com.shj.databasedemo.yiyu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.shj.databasedemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Reus on 2017/5/12.
 */

public class TestActivity extends Activity {
    private ListView lv;
    private List<Person> list = new ArrayList<>();
    private PersonAdaper adaper;
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        lv = ((ListView) findViewById(R.id.lv));
        adaper = new PersonAdaper(this,list);
        lv.setAdapter(adaper);
    }

    public void insert(View v){
        Person person = new Person();
        person.id = 1+i;
        person.name = "shj"+i;
        person.sex = "w"+i;
        YiDbInterfac.getInstance(this).insertPerson(person);

    }
    public void delone(View v){
         Person person = new Person();
         person.id = 1;
        YiDbInterfac.getInstance(this).del(person);
        list = YiDbInterfac.getInstance(this).getAllPerson();
        adaper.notifyDataSetChanged();
    }
    public void delall(View v){
        YiDbInterfac.getInstance(this).del();
        list = YiDbInterfac.getInstance(this).getAllPerson();
        adaper.notifyDataSetChanged();
    }
    public void update(View v){
        Person person = new Person();
        person.id = 2;
        person.name = "hshsh";
        person.sex = "nan";
        YiDbInterfac.getInstance(this).update(person);
        list = YiDbInterfac.getInstance(this).getAllPerson();
        adaper.notifyDataSetChanged();
    }
    public void querry(View v){
        list = YiDbInterfac.getInstance(this).getAllPerson();
        adaper.notifyDataSetChanged();
    }
}
