package com.example.tapesh.momarknew;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;

import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.net.URL;

/**
 * Created by TAPESH on 6/10/2016.
 */
public class Activity4 extends Activity implements View.OnClickListener{
    ImageView imageViewphoto;

    Button button3register,button3back;
    EditText editText2name,editText2mobile,editText2email,editText2referralcode;

    // these string are send to server.
   static String nameser,mobileser,emailser,referralcodeser,response;

    FrameLayout frameLayout;
    FragmentTransaction ft;

    int RESULT_LOAD_IMG=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity4);

        button3register=(Button)findViewById(R.id.button3register);
        button3back=(Button)findViewById(R.id.button3back);
        imageViewphoto=(ImageView)findViewById(R.id.imageViewphoto);

        editText2name=(EditText)findViewById(R.id.editText2name);
        editText2mobile=(EditText)findViewById(R.id.editText2mobile);
        editText2email=(EditText)findViewById(R.id.editText2email);
        editText2referralcode=(EditText)findViewById(R.id.editText2referralcode);




        frameLayout=(FrameLayout)findViewById(R.id.your_placeholder);
        frameLayout.setVisibility(View.GONE);


        imageViewphoto.setOnClickListener(this);

        button3register.setOnClickListener(this);
        button3back.setOnClickListener(this);
    }



@Override
    public void onClick(View view)
{

switch(view.getId()) {
    case R.id.imageViewphoto:
               Intent galleryIntent = new Intent(Intent.ACTION_PICK,
               android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               // Start the Intent
              startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    break;

case R.id.button3register:
    Log.i("in on click......", "method");

    nameser=editText2name.getText().toString();
    mobileser=editText2mobile.getText().toString();
    emailser=editText2email.getText().toString();
    referralcodeser=editText2referralcode.getText().toString();

    if((!nameser.equals(""))&& (!mobileser.equals("")) && (!emailser.equals(""))  ) {

        Log.i("in on click", "method");
        new HttpAsyncTask().execute();




        editText2referralcode.setVisibility(View.GONE);
        editText2email.setVisibility(View.GONE);
        editText2mobile.setVisibility(View.GONE);
        editText2name.setVisibility(View.GONE);
        imageViewphoto.setVisibility(View.GONE);
        button3register.setVisibility(View.GONE);
        button3back.setVisibility(View.GONE);
        frameLayout.setVisibility(View.VISIBLE);
        ft = this.getFragmentManager().beginTransaction();
        ft.replace(R.id.your_placeholder, new InnerFragment());
        ft.commit();


    }else
    {
        Toast.makeText(this,"Enter mandatory Fields",Toast.LENGTH_LONG).show();
    }
    break;


case R.id.button3back: Intent intent=new Intent(this,Activity2.class);
                        startActivity(intent);
                        finish();
                        break;


}



}





private class HttpAsyncTask extends AsyncTask<Void,Void,Void>
{
    @Override
    protected void onPreExecute()
    {

        nameser=editText2name.getText().toString();
        mobileser=editText2mobile.getText().toString();
        emailser=editText2email.getText().toString();
        referralcodeser=editText2referralcode.getText().toString();

    }


    @Override
    protected Void doInBackground(Void...argo)
    {

        JSONObject jo = new JSONObject();

        try
        {

            jo.put("mobileNo",mobileser);
            jo.put("name",nameser);
            jo.put("emailId",emailser);
            jo.put("referalCode",referralcodeser);

            Log.i("mobileNo", mobileser);
            Log.i("name",nameser);
            Log.i("emailId",emailser);
            Log.i("referalCode",referralcodeser);


            URL url = new URL("http://192.168.0.22:8080/AOP/c/getotp");
            HttpClient httpClient=new DefaultHttpClient();
            HttpPost httpPost=new HttpPost(url.toURI());

            httpPost.setEntity(new StringEntity(jo.toString(), "UTF-8"));
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

@Override
public void onBackPressed()
{
    frameLayout.setVisibility(View.GONE);
    editText2referralcode.setVisibility(View.VISIBLE);
    editText2email.setVisibility(View.VISIBLE);
    editText2mobile.setVisibility(View.VISIBLE);
    editText2name.setVisibility(View.VISIBLE);
    imageViewphoto.setVisibility(View.VISIBLE);
    button3register.setVisibility(View.VISIBLE);
    button3back.setVisibility(View.VISIBLE);


}

    public String getMyData() {
        return response;
    }

}
