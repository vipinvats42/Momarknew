package com.example.tapesh.momarknew;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by TAPESH on 6/6/2016.
 */
public class Activity1 extends AppCompatActivity {
    Timer t;
    int height;
    int height1;
    ImageView rocketImage;
    TextView orgname;
    Animation mytextAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity1);





        orgname=(TextView)findViewById(R.id.orgname);
        orgname.setVisibility(View.GONE);

        rocketImage = (ImageView) findViewById(R.id.rocket_image);


        rocketImage.setImageResource(R.drawable.image2);


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
         height = size.y;
         height1=height/3;
        Log.i("width",width+"");
        Log.i("height", height + "");

        int width1=width/2;
        moveImageToRightToCenter(rocketImage, width1);



    }

    public void moveImageToRightToCenter(ImageView img ,int screenWidth)
    {
        rocketImage.setTranslationX(0);
        rocketImage.setTranslationY(-1000);

        rocketImage.animate()




                .translationY(height/2)

                .setDuration(1200)
                .setStartDelay(1000);




        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                changeSize();
            }
        }, 2200);




        }


   void changeSize()
   {
       rocketImage.setTranslationX(0);
       rocketImage.setTranslationY(height/2);
       rocketImage.animate()
       .translationY(height / 3)

           .setDuration(800)
            .setStartDelay(0);

       Handler handler = new Handler();
       handler.postDelayed(new Runnable() {
           @Override
           public void run() {

               changeSize1();
           }
       }, 900);




   }






    void changeSize1()
    {


        Animation zoomout = AnimationUtils.loadAnimation(this, R.anim.zoomout);

        rocketImage.setAnimation(zoomout);
        rocketImage.startAnimation(zoomout);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeSize2();


            }
        }, 2500);


    }


         void changeSize2()
         {
             Animation zoomin = AnimationUtils.loadAnimation(this, R.anim.zoomin);
             rocketImage.setAnimation(zoomin);
             rocketImage.startAnimation(zoomin);

             orgname.setVisibility(View.VISIBLE);
             mytextAnimation = AnimationUtils.loadAnimation(this, R.anim.textanim);
             orgname.startAnimation(mytextAnimation);


             Handler handler = new Handler();
             handler.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     changeSize3();


                 }
             }, 3000);



         }


            void changeSize3()
            {
                Intent intent=new Intent(this,Activity2.class);
                startActivity(intent);
                finish();
            }





}
