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

public class activityStage10_2 extends AppCompatActivity {
    int val;
    Random r = new Random();

    SQLiteDatabase db;
    String strText = "4";
    String aa = "4";int a1=0;
    int a2=0;
    int a3=0;
    int a4=0;
    int a5=0;
    int a6=0;
    int a7=0;
    int a8=0;
    int a9=0;
    int a10=0;
    int correctTile =0;
    int btn1Down=0;
    int btn2Down=0;
    int btn3Down=0;
    int btn4Down=0;
    int btn5Down=0;
    int btn6Down=0;
    int btn7Down=0;
    int btn8Down=0;
    int btn9Down=0;
    int btn10Down=0;
    String alartTitle = "";
    String alartMsg = "";
    private CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_activity_stage10_2);
        db = openOrCreateDatabase("FL", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS MTP(MTPR VARCHAR PRIMARY KEY);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Theme(ColorCode VARCHAR PRIMARY KEY);");
        sync_theme();
        apply_theme();
        stage4_1();
        timer4();
        randm4();
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
    public void randm4()
    {

        timer.cancel();
        timer.start();
        Button btn1x = (Button) findViewById(R.id.button10_1_1);
        Button btn2x = (Button) findViewById(R.id.button10_1_2);
        Button btn3x = (Button) findViewById(R.id.button10_1_3);
        Button btn4x = (Button) findViewById(R.id.button10_1_4);
        Button btn5x = (Button) findViewById(R.id.button10_1_5);
        Button btn6x = (Button) findViewById(R.id.button10_1_6);
        Button btn7x = (Button) findViewById(R.id.button10_1_7);
        Button btn8x = (Button) findViewById(R.id.button10_1_8);
        Button btn9x = (Button) findViewById(R.id.button10_1_9);
        Button btn10x = (Button) findViewById(R.id.button10_1_10);
        int[] ex = new int[]{a1,a2,a3,a4,a5,a6,a7,a8,a9,a10};
        try{
            val = getRandomWithExclusion(r, 0, 10, ex);
        }
        catch (Exception e){val=18;}
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
        if(val == 5)
        { a5 = 5;
            btn5x.setText("*");}
        else
        if(val == 6)
        { a6 = 6;
            btn6x.setText("*");}
        else
        if(val == 7)
        { a7 = 7;
            btn7x.setText("*");}
        else
        if(val == 8)
        { a8 = 8;
            btn8x.setText("*");}
        else
        if(val == 9)
        { a9 = 9;
            btn9x.setText("*");}
        else
        if(val == 10)
        { a10 = 10;
            btn10x.setText("*");}
        else
        if(a1==1 && a2==2 &a3==3 && a4==4 && a5==5 && a6==6 && a7==7 && a8==8 && a9==9 && a10==10 && val ==0)
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
                if(btn1Down == 2 ||btn3Down == 2 || btn5Down == 2 || btn7Down == 2 || btn9Down == 2 ||  btn1Down == 3 || btn3Down == 3 || btn5Down == 3 || btn7Down == 3 || btn9Down == 3 )
                {
                    timer.cancel();
                    alartTitle="Information";
                    alartMsg = "Player 1 Won";
                    Complete();
                    //reset();

                }
                else
                if(btn2Down == 2 ||btn4Down == 2 || btn6Down == 2 ||  btn8Down == 2 || btn10Down == 2 || btn2Down == 3 || btn4Down == 3 || btn6Down == 3 ||  btn8Down == 3 ||btn10Down == 3)
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
        Button btn1x = (Button) findViewById(R.id.button6_1_1);
        Button btn2x = (Button) findViewById(R.id.button6_1_2);
        Button btn3x = (Button) findViewById(R.id.button6_1_3);
        Button btn4x = (Button) findViewById(R.id.button6_1_4);
        Button btn5x = (Button) findViewById(R.id.button6_1_5);
        Button btn6x = (Button) findViewById(R.id.button6_1_6);
        btn1x.setText("");
        btn2x.setText("");
        btn3x.setText("");
        btn4x.setText("");
        btn5x.setText("");
        btn6x.setText("");
        a1 = 0;
        a2 = 0;
        a3 = 0;
        a4 = 0;
        a5 = 0;
        a6 = 0;
        val=0;
        btn1Down=0;
        btn2Down=0;
        btn3Down=0;
        btn4Down=0;
        btn5Down=0;
        btn6Down=0;
        onBackPressed();
    }
    public void stage4_1()
    {
        Button btn1x = (Button) findViewById(R.id.button10_1_1);
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
                            if (val == 5)
                            {btn5Down=3;}
                            if (val == 6)
                            {btn6Down=3;}
                            if (val == 7)
                            {btn7Down=3;}
                            if (val == 8)
                            {btn8Down=3;}
                            if (val == 9)
                            {btn9Down=3;}
                            if (val == 10)
                            {btn10Down=3;}

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
        Button btn2x = (Button) findViewById(R.id.button10_1_2);
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
                            if (val == 5)
                            {btn5Down=3;}
                            if (val == 6)
                            {btn6Down=3;}
                            if (val == 7)
                            {btn7Down=3;}
                            if (val == 8)
                            {btn8Down=3;}
                            if (val == 9)
                            {btn9Down=3;}
                            if (val == 10)
                            {btn10Down=3;}

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
        Button btn3x = (Button) findViewById(R.id.button10_1_3);
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
                            if (val == 5)
                            {btn5Down=3;}
                            if (val == 6)
                            {btn6Down=3;}
                            if (val == 7)
                            {btn7Down=3;}
                            if (val == 8)
                            {btn8Down=3;}
                            if (val == 9)
                            {btn9Down=3;}
                            if (val == 10)
                            {btn10Down=3;}

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
        Button btn4x = (Button) findViewById(R.id.button10_1_4);
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
                            if (val == 5)
                            {btn5Down=3;}
                            if (val == 6)
                            {btn6Down=3;}
                            if (val == 7)
                            {btn7Down=3;}
                            if (val == 8)
                            {btn8Down=3;}
                            if (val == 9)
                            {btn9Down=3;}
                            if (val == 10)
                            {btn10Down=3;}

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
        Button btn5x = (Button) findViewById(R.id.button10_1_5);
        btn5x.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        v.setPressed(true);
                        // Start action ...
                        correctTile=5;
                        if(val == correctTile)
                        {

                            btn5Down=1;
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
                            if (val == 5)
                            {btn5Down=3;}
                            if (val == 6)
                            {btn6Down=3;}
                            if (val == 7)
                            {btn7Down=3;}
                            if (val == 8)
                            {btn8Down=3;}
                            if (val == 9)
                            {btn9Down=3;}
                            if (val == 10)
                            {btn10Down=3;}

                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        v.setPressed(false);
                        // Stop action ...
                        btn5Down=2;
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.setPressed(false);
                        // Stop action ...
                        btn5Down=2;
                        break;
                }

                return true;
            }

        });
        Button btn6x = (Button) findViewById(R.id.button10_1_6);
        btn6x.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        v.setPressed(true);
                        // Start action ...
                        correctTile=6;
                        if(val == correctTile)
                        {

                            btn6Down=1;
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
                            if (val == 5)
                            {btn5Down=3;}
                            if (val == 6)
                            {btn6Down=3;}
                            if (val == 7)
                            {btn7Down=3;}
                            if (val == 8)
                            {btn8Down=3;}
                            if (val == 9)
                            {btn9Down=3;}
                            if (val == 10)
                            {btn10Down=3;}

                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        v.setPressed(false);
                        // Stop action ...
                        btn6Down=2;
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.setPressed(false);
                        // Stop action ...
                        btn6Down=2;
                        break;
                }

                return true;
            }

        });
        Button btn7x = (Button) findViewById(R.id.button10_1_7);
        btn7x.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        v.setPressed(true);
                        // Start action ...
                        correctTile=7;
                        if(val == correctTile)
                        {

                            btn7Down=1;
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
                            if (val == 5)
                            {btn5Down=3;}
                            if (val == 6)
                            {btn6Down=3;}
                            if (val == 7)
                            {btn7Down=3;}
                            if (val == 8)
                            {btn8Down=3;}
                            if (val == 9)
                            {btn9Down=3;}
                            if (val == 10)
                            {btn10Down=3;}

                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        v.setPressed(false);
                        // Stop action ...
                        btn7Down=2;
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.setPressed(false);
                        // Stop action ...
                        btn7Down=2;
                        break;
                }

                return true;
            }

        });
        Button btn8x = (Button) findViewById(R.id.button10_1_8);
        btn8x.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        v.setPressed(true);
                        // Start action ...
                        correctTile=8;
                        if(val == correctTile)
                        {

                            btn8Down=1;
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
                            if (val == 5)
                            {btn5Down=3;}
                            if (val == 6)
                            {btn6Down=3;}
                            if (val == 7)
                            {btn7Down=3;}
                            if (val == 8)
                            {btn8Down=3;}
                            if (val == 9)
                            {btn9Down=3;}
                            if (val == 10)
                            {btn10Down=3;}

                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        v.setPressed(false);
                        // Stop action ...
                        btn8Down=2;
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.setPressed(false);
                        // Stop action ...
                        btn8Down=2;
                        break;
                }

                return true;
            }

        });
        Button btn9x = (Button) findViewById(R.id.button10_1_9);
        btn9x.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        v.setPressed(true);
                        // Start action ...
                        correctTile=9;
                        if(val == correctTile)
                        {

                            btn9Down=1;
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
                            if (val == 5)
                            {btn5Down=3;}
                            if (val == 6)
                            {btn6Down=3;}
                            if (val == 7)
                            {btn7Down=3;}
                            if (val == 8)
                            {btn8Down=3;}
                            if (val == 9)
                            {btn9Down=3;}
                            if (val == 10)
                            {btn10Down=3;}

                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        v.setPressed(false);
                        // Stop action ...
                        btn9Down=2;
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.setPressed(false);
                        // Stop action ...
                        btn9Down=2;
                        break;
                }

                return true;
            }

        });
        Button btn10x = (Button) findViewById(R.id.button10_1_10);
        btn10x.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        v.setPressed(true);
                        // Start action ...
                        correctTile=10;
                        if(val == correctTile)
                        {

                            btn10Down=1;
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
                            if (val == 5)
                            {btn5Down=3;}
                            if (val == 6)
                            {btn6Down=3;}
                            if (val == 7)
                            {btn7Down=3;}
                            if (val == 8)
                            {btn8Down=3;}
                            if (val == 9)
                            {btn9Down=3;}
                            if (val == 10)
                            {btn10Down=3;}

                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        v.setPressed(false);
                        // Stop action ...
                        btn10Down=2;
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.setPressed(false);
                        // Stop action ...
                        btn10Down=2;
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
        Intent i = new Intent(context,activityStage10.class);
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
                Intent i = new Intent(context,activityStage10.class);
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
