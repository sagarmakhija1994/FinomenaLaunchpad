package com.sagarmakhija1994gmail.finomenalaunchpad;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class activityAbout extends AppCompatActivity {
    SQLiteDatabase db;
    String strText = "4";
    String aa = "4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_activity_about);
        db = openOrCreateDatabase("FL", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS MTP(MTPR VARCHAR PRIMARY KEY);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Theme(ColorCode VARCHAR PRIMARY KEY);");
        sync_theme();
        apply_theme();
        font();
    }
    public void sync_theme()
    {
        Cursor c = db.rawQuery("SELECT * FROM Theme", null);
        if (c.getCount() == 0) {
            db.execSQL("INSERT INTO Theme VALUES('"+strText+"');");
            aa = strText;
        }
        while (c.moveToNext()) {
            if(c.moveToFirst())
            {
                strText = c.getString(0);
                aa = strText;
            }
        }
    }
    public void font() {
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/grand hotel.otf");
        Typeface face2 = Typeface.createFromAsset(getAssets(), "fonts/timeburner.ttf");

        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setTypeface(face);


        TextView textView15 = (TextView)findViewById(R.id.textView4);
        textView15.setTypeface(face2);
        TextView textView16 = (TextView)findViewById(R.id.textView5);
        textView16.setTypeface(face2);
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setTypeface(face2);

        Button button7 = (Button)findViewById(R.id.button7);
        button7.setTypeface(face2);
        Button button8 = (Button)findViewById(R.id.button8);
        button8.setTypeface(face2);
        Button button9 = (Button)findViewById(R.id.button9);
        button9.setTypeface(face2);
        Button button10 = (Button)findViewById(R.id.button10);
        button10.setTypeface(face2);
    }
    public void Fbtn1(View v) {
        String url = "https://github.com/sagarmakhija1994/FinomenaLaunchpad.git";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void Fbtn2(View v) {
        String url = "https://sagarmakhija.xyz/Angel";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void Fbtn3(View v) {

        String url = "https://sagarmakhija.xyz/Linked";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void Fbtn4(View v) {

        String url = "https://sagarmakhija.xyz";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void apply_theme()
    {
        if (aa.equals("1"))
        {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(R.color.red_dark));
            }

            View someView = findViewById(R.id.layoutSettings);
            View root = someView.getRootView();
            root.setBackgroundColor(getResources().getColor(R.color.red_light));
        }
        else if (aa.equals("2"))
        {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(R.color.pink_dark));
            }

            View someView = findViewById(R.id.layoutSettings);
            View root = someView.getRootView();
            root.setBackgroundColor(getResources().getColor(R.color.pink_light));
        }
        else if (aa.equals("3"))
        {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(R.color.purple_dark));
            }

            View someView = findViewById(R.id.layoutSettings);
            View root = someView.getRootView();
            root.setBackgroundColor(getResources().getColor(R.color.purple_light));
        }
        else if (aa.equals("4"))
        {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(R.color.blue_dark));
            }

            View someView = findViewById(R.id.layoutSettings);
            View root = someView.getRootView();
            root.setBackgroundColor(getResources().getColor(R.color.blue_light));
        }
        else if (aa.equals("5"))
        {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(R.color.cyan_dark));
            }

            View someView = findViewById(R.id.layoutSettings);
            View root = someView.getRootView();
            root.setBackgroundColor(getResources().getColor(R.color.cyan_light));
        }
        else if (aa.equals("6"))
        {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(R.color.teal_dark));
            }

            View someView = findViewById(R.id.layoutSettings);
            View root = someView.getRootView();
            root.setBackgroundColor(getResources().getColor(R.color.teal_light));
        }
        else if (aa.equals("7"))
        {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(R.color.green_dark));
            }

            View someView = findViewById(R.id.layoutSettings);
            View root = someView.getRootView();
            root.setBackgroundColor(getResources().getColor(R.color.green_light));
        }
        else if (aa.equals("8"))
        {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(R.color.lime_dark));
            }

            View someView = findViewById(R.id.layoutSettings);
            View root = someView.getRootView();
            root.setBackgroundColor(getResources().getColor(R.color.lime_light));
        }
        else if (aa.equals("9"))
        {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(R.color.yellow_dark));
            }

            View someView = findViewById(R.id.layoutSettings);
            View root = someView.getRootView();
            root.setBackgroundColor(getResources().getColor(R.color.yellow_light));
        }
        else if (aa.equals("10"))
        {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(R.color.orange_dark));
            }

            View someView = findViewById(R.id.layoutSettings);
            View root = someView.getRootView();
            root.setBackgroundColor(getResources().getColor(R.color.orange_light));
        }
        else if (aa.equals("11"))
        {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(R.color.brown_dark));
            }

            View someView = findViewById(R.id.layoutSettings);
            View root = someView.getRootView();
            root.setBackgroundColor(getResources().getColor(R.color.brown_light));
        }
        else if (aa.equals("12"))
        {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(R.color.gray_dark));
            }

            View someView = findViewById(R.id.layoutSettings);
            View root = someView.getRootView();
            root.setBackgroundColor(getResources().getColor(R.color.gray_light));
        }
        else if (aa.equals("13"))
        {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(R.color.bGray_dark));
            }

            View someView = findViewById(R.id.layoutSettings);
            View root = someView.getRootView();
            root.setBackgroundColor(getResources().getColor(R.color.bGray_light));
        }
        else if (aa.equals("14"))
        {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(getResources().getColor(R.color.tBlak_light));
            }

            View someView = findViewById(R.id.layoutSettings);
            View root = someView.getRootView();
            root.setBackgroundColor(getResources().getColor(R.color.tWhite_dark));
        }
    }
    public void onBackPressed()
    {
        final Context context = this;
        Intent i = new Intent(context,Main_Menue.class);
        startActivity(i);
        finish();
    }
}
