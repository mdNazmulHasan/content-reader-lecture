package com.example.user.notereader;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private static final Uri ALL_NOTES = Uri.parse("content://com.example.user.todolistprovider/todo");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.notes);
        getAll();
    }

    private void getAll() {
        Cursor cursor = getContentResolver().query(ALL_NOTES,null,null,null,null);
        if(cursor != null && cursor.getCount() > 0){
            String txt = tv.getText()+"\n";
            cursor.moveToFirst();
            do{
                String todo = cursor.getString(cursor.getColumnIndex("todo_list"));
                txt += todo+"\n";
            }while(cursor.moveToNext());
            tv.setText(txt);
        }
    }
}
