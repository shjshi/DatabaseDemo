package com.shj.databasedemo.database;

import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by Reus on 2017/5/2.
 */

public class DBOpenHandlerTest {

    private Context context;
    private static final String TAG = "DBOpenHandlerTest";
    public DBOpenHandlerTest(Context context){
        this.context = context;
    }
    public void testCreate(){
        DBOpenHandler dbHandler=new DBOpenHandler(context);
        dbHandler.getWritableDatabase();
        Log.i(TAG, "testCreate");
    }
    public void testSave() throws Throwable{
        PersonService personService = new PersonService(context);
        Person person = new Person();
        person.setName("xiaoming");
        personService.save(person);

        person = new Person();
        person.setName("xiaoli");
        personService.save(person);

        person = new Person();
        person.setName("xiaowang");
        personService.save(person);

        person = new Person();
        person.setName("xiaozhang");
        personService.save(person);
        Log.i(TAG, "testSave");
    }

    public void testUpate() throws Throwable{
        PersonService personService = new PersonService(context);
        Person person = personService.find(1);
        person.setName("lili");
        personService.update(person);
        Log.i(TAG, "testUpate");
    }

    public void testDelete() throws Throwable{
        PersonService personService = new PersonService(context);
        personService.delete(1);
        Log.i(TAG, "testDelete");
    }

    public void testFind() throws Throwable{
        PersonService personService = new PersonService(context);
        Person person = personService.find(1);
        Log.i(TAG, person.getName());
    }

    public void testFindAll() throws Throwable{
        PersonService personService = new PersonService(context);
        List<Person> persons = personService.findAll(0, 3);
        for(Person person : persons){
            Log.i(TAG, person.getName());
        }
    }

    public void testGetCount() throws Throwable{
        PersonService personService = new PersonService(context);
        Log.i(TAG, personService.getCount()+"");
    }
}
