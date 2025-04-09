package com.example.database;


import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbcreate();
        tablecreate();
        insertdata();
        readdata();
        updatedata();
        deletedata();
    }
        private void dbcreate()
        {
            mydatabase=openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
            Toast.makeText(this, "Database Created", Toast.LENGTH_SHORT).show();
        }

        private void tablecreate()
        {
            mydatabase.execSQL("CREATE TABLE IF NOT EXISTS MYTABLE(username VARCHAR,password VARCHAR);");
            Toast.makeText(this, "Table Created", Toast.LENGTH_SHORT).show();
        }

        private void insertdata()
        {
            mydatabase.execSQL("INSERT INTO mytable VALUES('Kairavi','123')");
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        }

        private void updatedata()
        {
            mydatabase.execSQL("UPDATE mytable SET password='1234' WHERE password='123'");
            Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
        }

        private void deletedata()
        {
            mydatabase.execSQL("DELETE FROM mytable WHERE username='Kairavi'");
            Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show();
        }

        private void readdata()
        {
            Cursor resultset=mydatabase.rawQuery("SELECT * FROM mytable",null);
            resultset.moveToFirst();

            String username=resultset.getString(0);
            String password=resultset.getString(1);

            Toast.makeText(this,username+"and"+password , Toast.LENGTH_SHORT).show();
        }
}