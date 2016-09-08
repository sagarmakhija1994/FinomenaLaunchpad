package com.sagarmakhija1994gmail.finomenalaunchpad;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class activityTheme extends AppCompatActivity {
    String aa = "1";
    String strText = "4";
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_activity_theme);
        db = openOrCreateDatabase("FL", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Theme(ColorCode VARCHAR PRIMARY KEY);");
        sync_theme();
        apply_theme();
        font();
    }
    public void font() {
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/grand hotel.otf");
        TextView txt = (TextView) findViewById(R.id.textView0);
        txt.setTypeface(face);

        Typeface face2 = Typeface.createFromAsset(getAssets(), "fonts/timeburner.ttf");

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setTypeface(face2);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setTypeface(face2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setTypeface(face2);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setTypeface(face2);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setTypeface(face2);
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        textView6.setTypeface(face2);
        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setTypeface(face2);
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setTypeface(face2);
        TextView textView9 = (TextView) findViewById(R.id.textView9);
        textView9.setTypeface(face2);
        TextView textView10 = (TextView) findViewById(R.id.textView10);
        textView10.setTypeface(face2);
        TextView textView11 = (TextView) findViewById(R.id.textView11);
        textView11.setTypeface(face2);
        TextView textView12 = (TextView) findViewById(R.id.textView12);
        textView12.setTypeface(face2);
        TextView textView13 = (TextView) findViewById(R.id.textView13);
        textView13.setTypeface(face2);
        TextView textView14 = (TextView) findViewById(R.id.textView14);
        textView14.setTypeface(face2);

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setTypeface(face2);
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setTypeface(face2);
        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setTypeface(face2);
        Button btn4 = (Button) findViewById(R.id.button4);
        btn4.setTypeface(face2);
        Button btn5 = (Button) findViewById(R.id.button5);
        btn5.setTypeface(face2);
        Button btn6 = (Button) findViewById(R.id.button6);
        btn6.setTypeface(face2);
        Button btn7 = (Button) findViewById(R.id.button7);
        btn7.setTypeface(face2);
        Button btn8 = (Button) findViewById(R.id.button8);
        btn8.setTypeface(face2);
        Button btn9 = (Button) findViewById(R.id.button9);
        btn9.setTypeface(face2);
        Button btn10 = (Button) findViewById(R.id.button10);
        btn10.setTypeface(face2);
        Button btn11 = (Button) findViewById(R.id.button11);
        btn11.setTypeface(face2);
        Button btn12 = (Button) findViewById(R.id.button12);
        btn12.setTypeface(face2);
        Button btn13 = (Button) findViewById(R.id.button13);
        btn13.setTypeface(face2);
        Button btn14 = (Button) findViewById(R.id.button14);
        btn14.setTypeface(face2);


    }
    public void set_theme()
    {
        db.execSQL("DROP TABLE Theme;");
        db.execSQL("CREATE TABLE IF NOT EXISTS Theme(ColorCode VARCHAR PRIMARY KEY);");
        db.execSQL("INSERT INTO Theme VALUES('"+strText+"');");
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

    public void btn1(View v)
    {
        strText = "1";
        set_theme();
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
    public void btn2(View v)
    {
        strText = "2";
        set_theme();

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
    public void btn3(View v)
    {
        strText = "3";
        set_theme();

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
    public void btn4(View v)
    {
        strText = "4";
        set_theme();

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
    public void btn5(View v)
    {
        strText = "5";
        set_theme();

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
    public void btn6(View v)
    {
        strText = "6";
        set_theme();

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
    public void btn7(View v)
    {
        strText = "7";
        set_theme();
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
    public void btn8(View v)
    {
        strText = "8";
        set_theme();

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
    public void btn9(View v)
    {
        strText = "9";
        set_theme();

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
    public void btn10(View v)
    {
        strText = "10";
        set_theme();

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
    public void btn11(View v)
    {
        strText = "11";
        set_theme();

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
    public void btn12(View v)
    {
        strText = "12";
        set_theme();

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
    public void btn13(View v)
    {
        strText = "13";
        set_theme();

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
    public void btn14(View v)
    {
        strText = "14";
        set_theme();

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
    public void onBackPressed() {
        set_theme();
        final Context context = this;
        Intent i = new Intent(context,Main_Menue.class);
        startActivity(i);
        finish();
    }
}
