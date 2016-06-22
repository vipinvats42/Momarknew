package com.example.tapesh.momarknew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by TAPESH on 6/9/2016.
 */
public class Activity3 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener{
    Button buttonlogin,buttonresendOTP,button2newuser;

    TextView textViewtimer,textViewtime;



    int otp1=123;


    EditText editTextphonenumber,editTextotp;
    int time1=60;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        buttonlogin=(Button)findViewById(R.id.button);
        buttonresendOTP=(Button)findViewById(R.id.buttonresendOTP);
        button2newuser=(Button)findViewById(R.id.button2);


        textViewtimer=(TextView)findViewById(R.id.textViewtimer);
        textViewtime=(TextView)findViewById(R.id.textViewtime);


        editTextphonenumber=(EditText)findViewById(R.id.editText);
        editTextotp=(EditText)findViewById(R.id.editTextotp);


        // hide the views
        textViewtimer.setVisibility(View.GONE);
        textViewtime.setVisibility(View.GONE);
        editTextotp.setVisibility(View.GONE);
        buttonresendOTP.setVisibility(View.GONE);



        buttonlogin.setOnClickListener(this);
        buttonresendOTP.setOnClickListener(this);
        button2newuser.setOnClickListener(this);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
      //  drawer.setDrawerListener(toggle);
//        toggle.syncState();



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);


    }

  @Override
    public void onClick(View view)
  {

      switch(view.getId()) {


          case R.id.button:


                            // views are visible here
                            textViewtimer.setVisibility(View.VISIBLE);
                            textViewtime.setVisibility(View.VISIBLE);
                            editTextotp.setVisibility(View.VISIBLE);

                            button2newuser.setVisibility(View.GONE);


                             // change the text name of get otp to verify



                             final Animation timerrotate = AnimationUtils.loadAnimation(this, R.anim.rotatetimer);
                             textViewtimer.setAnimation(timerrotate);
                             textViewtimer.startAnimation(timerrotate);

                             Timer timer = new Timer();
                             timer.schedule(new TimerTask() {
                                 @Override
                                 public void run() {
                                     runOnUiThread(new Runnable() {
                                         @Override
                                         public void run() {

                                             changeTimeinsecond1();
                                             time1--;
                                         }
                                     });
                                 }
                             }, 100, 1000);



             String buttonlogintext= buttonlogin.getText().toString();
              Log.i("buttontext......",buttonlogintext);

             if(buttonlogintext.equals("verify")) {
                 int otpcheck = 0;
                 // take otp from user edittext;
                 try {
                     otpcheck = Integer.parseInt(editTextotp.getText().toString());
                 } catch (Exception e) {
                     Toast.makeText(this, "Enter right OTP ", Toast.LENGTH_LONG).show();
                 }


                 if (otpcheck == otp1) {
                     Intent intent3 = new Intent(this, MainActivity.class);
                     startActivity(intent3);
                 }
             }
              buttonlogin.setText("verify");
                  break;


          case R.id.buttonresendOTP:
              time1=60;
              final Animation timerrotate1 = AnimationUtils.loadAnimation(this, R.anim.rotatetimer);
              textViewtimer.setAnimation(timerrotate1);
              textViewtimer.startAnimation(timerrotate1);

              Timer timer1 = new Timer();
              timer1.schedule(new TimerTask() {
                  @Override
                  public void run() {
                      runOnUiThread(new Runnable() {
                          @Override
                          public void run() {

                              changeTimeinsecond1();
                              time1--;
                          }
                      });
                  }
              }, 400, 1000);

              break;


          case R.id.button2:
                           Intent intent=new Intent(this,Activity4.class);
                           startActivity(intent);
              break;



      }
  }





    void  changeTimeinsecond1()
    {
        if(time1>=1)
        {
            textViewtime.setText(time1+"");

        }else{

            textViewtimer.clearAnimation();
            buttonresendOTP.setVisibility(View.VISIBLE);
        }
    }

//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

















}
