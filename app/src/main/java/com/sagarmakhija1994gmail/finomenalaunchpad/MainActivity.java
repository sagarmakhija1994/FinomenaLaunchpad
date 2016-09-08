package com.sagarmakhija1994gmail.finomenalaunchpad;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity{
    SQLiteDatabase db;
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        db = openOrCreateDatabase("FL", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS MTP(MTPR VARCHAR PRIMARY KEY);");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m1();
            }
        });
    }

    public void m1()
    {
        final Context context = this;
        MultitouchView customView = (MultitouchView) findViewById(R.id.myCustomeView);
        x = customView.s2;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Multi-Touch Result");
        builder.setMessage("Your Device Support Max "+x+" Multi-Touch Points");

        builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Save_data();
                Intent i = new Intent(context,Main_Menue.class);
                startActivity(i);
                finish();
                dialog.dismiss();
            }

        });

        builder.setNegativeButton("Retry", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }
    public void Save_data()
    {
        Cursor c = db.rawQuery("SELECT * FROM MTP", null);
        if (c.getCount() == 0) {
            db.execSQL("INSERT INTO MTP VALUES('"+x+"');");
            return;
        }
        while (c.moveToNext()) {
            db.execSQL("DROP TABLE MTP;");
            db.execSQL("CREATE TABLE IF NOT EXISTS MTP(MTPR VARCHAR PRIMARY KEY);");
            db.execSQL("INSERT INTO MTP VALUES('"+x+"');");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showMessage(String title,String message) {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
