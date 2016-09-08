package com.sagarmakhija1994gmail.finomenalaunchpad;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Random;

public class activityStage4_3 extends AppCompatActivity {
    SQLiteDatabase db;
    String strText = "4";
    String aa = "4";
    int val;
    Random r = new Random();
    int a1=0;
    int a2=0;
    int a3=0;
    int a4=0;
    int correctTile =0;
    int btn1Down=0;
    int btn2Down=0;
    int btn3Down=0;
    int btn4Down=0;
    String alartTitle = "";
    String alartMsg = "";
    private CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_activity_stage4_3);
        db = openOrCreateDatabase("FL", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS MTP(MTPR VARCHAR PRIMARY KEY);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Theme(ColorCode VARCHAR PRIMARY KEY);");
        stage4_1();
        timer4();
        randm4(); sync_theme();
        apply_theme();
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
    public int getRandomWithExclusion(Random rnd, int start, int end, int[] exclude) {
        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }

    public void randm4()
    {

        timer.cancel();
        timer.start();
        Button btn1x = (Button) findViewById(R.id.button4_2_1);
        Button btn2x = (Button) findViewById(R.id.button4_2_2);
        Button btn3x = (Button) findViewById(R.id.button4_2_3);
        Button btn4x = (Button) findViewById(R.id.button4_2_4);
        int[] ex = new int[]{a1,a2,a3,a4};
        try{
            val = getRandomWithExclusion(r, 0, 4, ex);
        }
        catch (Exception e){val=8;}
        if(val == 1)
        { a1= 1;
            btn1x.setText("*");
        }
        else
        if(val == 2)
        { a2 = 2;
            btn2x.setText("*");}
        else
        if(val == 3)
        { a3 = 3;
            btn3x.setText("*");}
        else
        if(val == 4)
        { a4 = 4;
            btn4x.setText("*");}
        else
        if(a1==1 && a2==2 &a3==3 && a4==4 && val ==0)
        {
            timer.cancel();
            alartTitle="Information";
            alartMsg = "Game Draw";
            Complete();
            //reset();

        }

        //showMessage("Randome Value:",""+val);

    }

    public void timer4()
    {
        timer = new CountDownTimer(500000,100) {

            @Override
            public void onTick(long millisUntilFinished) {
                if(btn1Down == 2 ||btn3Down == 2 || btn1Down == 3 ||btn3Down == 3)
                {
                    timer.cancel();
                    alartTitle="Information";
                    alartMsg = "Player 1 Won";
                    Complete();
                    //reset();

                }
                else
                if(btn2Down == 2 ||btn4Down == 2 || btn2Down == 3 ||btn4Down == 3)
                {
                    timer.cancel();
                    alartTitle="Information";
                    alartMsg = "Player 2 Won";
                    Complete();
                    //reset();

                }
            }

            @Override
            public void onFinish() {
                timer.start();
            }
        }.start();
    }
    public void reset ()
    {
        Button btn1x = (Button) findViewById(R.id.button4_2_1);
        Button btn2x = (Button) findViewById(R.id.button4_2_2);
        Button btn3x = (Button) findViewById(R.id.button4_2_3);
        Button btn4x = (Button) findViewById(R.id.button4_2_4);
        btn1x.setText("");
        btn2x.setText("");
        btn3x.setText("");
        btn4x.setText("");
        a1 = 0;
        a2 = 0;
        a3 = 0;
        a4 = 0;
        val=0;
        btn1Down=0;
        btn2Down=0;
        btn3Down=0;
        btn4Down=0;
        onBackPressed();
    }

    public void stage4_1()
    {
        Button btn1x = (Button) findViewById(R.id.button4_2_1);
        btn1x.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        v.setPressed(true);
                        // Start action ...
                        correctTile=1;
                        if(val == correctTile)
                        {
                            btn1Down=1;
                            randm4();
                        }
                        else {
                            v.setPressed(false);
                            if (val == 1)
                            {btn1Down=3;}
                            if (val == 2)
                            {btn2Down=3;}
                            if (val == 3)
                            {btn3Down=3;}
                            if (val == 4)
                            {btn4Down=3;}

                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        v.setPressed(false);
                        btn1Down=2;
                        // Stop action ...
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.setPressed(false);
                        btn1Down=2;
                        // Stop action ...
                        break;
                }

                return true;
            }

        });
        Button btn2x = (Button) findViewById(R.id.button4_2_2);
        btn2x.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        v.setPressed(true);
                        // Start action ...

                        correctTile=2;
                        if(val == correctTile)
                        {

                            btn2Down=1;
                            randm4();
                        }
                        else {
                            v.setPressed(false);
                            if (val == 1)
                            {btn1Down=3;}
                            if (val == 2)
                            {btn2Down=3;}
                            if (val == 3)
                            {btn3Down=3;}
                            if (val == 4)
                            {btn4Down=3;}

                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        v.setPressed(false);
                        // Stop action ...
                        btn2Down=2;
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.setPressed(false);
                        // Stop action ...
                        btn2Down=2;
                        break;
                }

                return true;
            }

        });
        Button btn3x = (Button) findViewById(R.id.button4_2_3);
        btn3x.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        v.setPressed(true);
                        // Start action ...
                        correctTile=3;
                        if(val == correctTile)
                        {
                            btn3Down=1;
                            randm4();
                        }
                        else {
                            v.setPressed(false);
                            if (val == 1)
                            {btn1Down=3;}
                            if (val == 2)
                            {btn2Down=3;}
                            if (val == 3)
                            {btn3Down=3;}
                            if (val == 4)
                            {btn4Down=3;}

                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        v.setPressed(false);
                        // Stop action ...
                        btn3Down=2;
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.setPressed(false);
                        // Stop action ...
                        btn3Down=2;
                        break;
                }

                return true;
            }

        });
        Button btn4x = (Button) findViewById(R.id.button4_2_4);
        btn4x.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        v.setPressed(true);
                        // Start action ...
                        correctTile=4;
                        if(val == correctTile)
                        {

                            btn4Down=1;
                            randm4();
                        }
                        else {
                            v.setPressed(false);
                            if (val == 1)
                            {btn1Down=3;}
                            if (val == 2)
                            {btn2Down=3;}
                            if (val == 3)
                            {btn3Down=3;}
                            if (val == 4)
                            {btn4Down=3;}

                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        v.setPressed(false);
                        // Stop action ...
                        btn4Down=2;
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.setPressed(false);
                        // Stop action ...
                        btn4Down=2;
                        break;
                }

                return true;
            }

        });
    }
    public void showMessage(String title,String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void onBackPressed()
    {
        final Context context = this;
        Intent i = new Intent(context,activityStage4.class);
        startActivity(i);
        finish();
    }
    public void Complete()
    {
        final Context context = this;
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle(alartTitle);
        builder.setMessage(alartMsg);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(context,activityStage4.class);
                startActivity(i);
                finish();
                dialog.dismiss();
            }
        });
        android.support.v7.app.AlertDialog alert = builder.create();
        alert.show();
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
}
