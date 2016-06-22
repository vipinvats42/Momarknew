package com.example.tapesh.momarknew;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by TAPESH on 5/19/2016.
 */
public class InnerFragment extends Fragment {

    String response,otp;
    static int time1;
    View view;

    Timer timeer1;
    TextView textViewtimer,Textview5time;
    EditText editText2otp;
    Button button3verify,button3resendotp;
    public InnerFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.innerfragment,container,false);

        //get otp from activity4
        Activity4 activity=(Activity4)getActivity();
        otp=activity.getMyData();

        Log.i("otp..fragment",otp+"");

        textViewtimer=(TextView)view.findViewById(R.id.textViewtimer);
        Textview5time=(TextView)view.findViewById(R.id.Textview5time);

        editText2otp=(EditText)view.findViewById(R.id.editText2otp);

        button3verify=(Button)view.findViewById(R.id.button3verify);
        button3resendotp=(Button)view.findViewById(R.id.button3resendotp);
        button3resendotp.setVisibility(View.GONE);

        final Animation timerrotate = AnimationUtils.loadAnimation(getActivity(), R.anim.rotatetimer);
        Textview5time.setAnimation(timerrotate);
        Textview5time.startAnimation(timerrotate);

        timeer1=new Timer();
        functiontimer();









        button3verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new HttpAsyncTask().execute();

                time1=60;
                timeer1.cancel();
                Intent intent2 = new Intent(getActivity(), MainActivity.class);
                startActivity(intent2);
                getActivity().finish();
            }
        });








        button3resendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time1 = 60;
                timeer1 = new Timer();
                final Animation timerrotate = AnimationUtils.loadAnimation(getActivity(), R.anim.rotatetimer);
                Textview5time.setAnimation(timerrotate);
                Textview5time.startAnimation(timerrotate);
                functiontimer();
            }
        });





















        // Inflate the layout for this fragment
       return view;
    }



    void changeTime()
    {

        time1=time1-1;


    }


   void functiontimer()
   {
       time1=60;

           timeer1.scheduleAtFixedRate(new TimerTask() {
               @Override
               public void run() {
                   if (time1 >= 1) {
                       getActivity().runOnUiThread(new Runnable() {
                           @Override
                           public void run() {

                               textViewtimer.setText(time1 + "");
                               if (time1 == 0) {
                                   Textview5time.clearAnimation();
                                   button3resendotp.setVisibility(View.VISIBLE);
                                   timeer1.cancel();
                               }
                           }
                       });

                   }
                   changeTime();
               }
           }, 0, 1000);



       }


@Override
    public void onDestroy()
{
    super.onDestroy();
    timeer1.cancel();
}




    private class HttpAsyncTask extends AsyncTask<Void,Void,Void>
    {
        @Override
        protected void onPreExecute()
        {

        }

        @Override
        protected Void doInBackground(Void...argo)
        {
            JSONObject jo = new JSONObject();
            String success="success";
            try
            {
                jo.put("success",success);
                URL Url=new URL("");
                HttpClient httpClient=new DefaultHttpClient();
                HttpPost httpPost=new HttpPost(Url.toURI());

                httpPost.setHeader("Content-Type", "application/json");
                httpPost.setHeader("Accept-Encoding", "application/json");
                httpPost.setHeader("Accept-Language", "en-US");
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                // HttpResponse response=httpClient.execute(httpPost,responseHandler);
                 response=httpClient.execute(httpPost,responseHandler);
                Log.i("response",response);
            }catch(Exception e)
            {
                Log.i("error",e.toString());
            }


            return null;
        }

    }

}
