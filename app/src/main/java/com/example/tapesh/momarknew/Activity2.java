package com.example.tapesh.momarknew;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by TAPESH on 6/8/2016.
 */
public class Activity2 extends Activity implements View.OnClickListener {

    int noofsize = 5;
    ViewPager myPager = null;
    int count = 0;
    Timer timer;

    Button btnlogin,btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity2);

        btnlogin=(Button)findViewById(R.id.btnlogin);
        btnsignup=(Button)findViewById(R.id.btnsignup);



        ViewPagerAdapter adapter = new ViewPagerAdapter(Activity2.this,noofsize);
        myPager = (ViewPager) findViewById(R.id.reviewpager);
        myPager.setAdapter(adapter);
        myPager.setCurrentItem(0);


        // Timer for auto sliding
        timer  = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(count<=5){
                            myPager.setCurrentItem(count);
                            count++;
                        }else{
                            count = 0;
                            myPager.setCurrentItem(count);
                        }
                    }
                });
            }
        }, 500, 5000);

       btnlogin.setOnClickListener(this);
        btnsignup.setOnClickListener(this);
    }



    @Override
    public void onClick(View view)
    {
        switch(view.getId()) {


            case R.id.btnlogin:   Intent intent = new Intent(this, Activity3.class);
                                   startActivity(intent);
                                   finish();
                                   break;


            case R.id.btnsignup:
                                Intent intent1=new Intent(this,Activity4.class);
                                startActivity(intent1);

                                break;
        }

        }




   @Override
   public void onBackPressed()
   {
       super.onBackPressed();
       finish();

   }



}
