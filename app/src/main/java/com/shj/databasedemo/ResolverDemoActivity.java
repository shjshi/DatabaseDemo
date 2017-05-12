package com.shj.databasedemo;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Reus on 2017/5/2.
 */

public class ResolverDemoActivity extends Activity {
    /** Called when the activity is first created. */
    private   SimpleCursorAdapter adapter;
    private ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView=(ListView) this.findViewById(R.id.listView);
        ContentResolver contentResolver = getContentResolver();
        Uri selectUri = Uri.parse("content://com.shj.personProvider/person");
        Cursor cursor=contentResolver.query(selectUri, null, null, null, null);
        adapter = new SimpleCursorAdapter(this, R.layout.test_cp, cursor,
                new String[]{"_id", "name", "age"}, new int[]{R.id.id, R.id.name, R.id.age});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView lView = (ListView)parent;
                Cursor data = (Cursor)lView.getItemAtPosition(position);
                int _id = data.getInt(data.getColumnIndex("_id"));
                Toast.makeText(ResolverDemoActivity.this, _id+"", Toast.LENGTH_SHORT).show();
            }
        });

        Button button = (Button) this.findViewById(R.id.insertbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1
                ContentResolver contentResolver = getContentResolver();
                //2
                Uri insertUri = Uri.parse("content://com.shj.personProvider/person");
                //3
                ContentValues values = new ContentValues();
                //4
                values.put("name", "wangkuifeng");
                values.put("age", 23);
                //5
                Uri uri = contentResolver.insert(insertUri, values);
                Toast.makeText(ResolverDemoActivity.this, "添加完成", Toast.LENGTH_LONG).show();
            }
        });
    }
}
