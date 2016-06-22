package com.example.tapesh.momarknew;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by TAPESH on 6/8/2016.
 */
public class ViewPagerAdapter extends PagerAdapter {
    int size;
    Activity act;
    View layout;
    TextView pagenumber1,pagenumber2,pagenumber3,pagenumber4,pagenumber5;
    ImageView pageImage;
    Button click;


    public ViewPagerAdapter(Activity2 mainActivity, int noofsize) {
        // TODO Auto-generated constructor stub
        size = noofsize;
        act = mainActivity;
    }



    @Override
    public Object instantiateItem(View container, int position) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = (LayoutInflater) act
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = inflater.inflate(R.layout.pages, null);
        pagenumber1 = (TextView)layout.findViewById(R.id.pagenumber1);
        pagenumber2 = (TextView)layout.findViewById(R.id.pagenumber2);
        pagenumber3 = (TextView)layout.findViewById(R.id.pagenumber3);
        pagenumber4 = (TextView)layout.findViewById(R.id.pagenumber4);
        pagenumber5 = (TextView)layout.findViewById(R.id.pagenumber5);
        pageImage = (ImageView)layout.findViewById(R.id.imageView1);
        int pagenumberTxt=position + 1;
        //pagenumber1.setText("Now your in Page No  " +pagenumberTxt );

        String myHexColor = "#CC2233";
        try {
            if(pagenumberTxt == 1){
                pageImage.setBackgroundResource(R.drawable.im1);
                pagenumber1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.textpage1, 0, 0, 0);
                pagenumber2.setTextColor(Color.WHITE);
                pagenumber3.setTextColor(Color.WHITE);
                pagenumber4.setTextColor(Color.WHITE);
                pagenumber5.setTextColor(Color.WHITE);
            }
            else if(pagenumberTxt == 2){
                pageImage.setBackgroundResource(R.drawable.im2);
                pagenumber1.setTextColor(Color.WHITE);
                pagenumber2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.textpage1, 0, 0, 0);
                pagenumber3.setTextColor(Color.WHITE);
                pagenumber4.setTextColor(Color.WHITE);
                pagenumber5.setTextColor(Color.WHITE);
            }else if(pagenumberTxt == 3){
                pageImage.setBackgroundResource(R.drawable.im3);
                pagenumber1.setTextColor(Color.WHITE);
                pagenumber2.setTextColor(Color.WHITE);
                pagenumber3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.textpage1, 0, 0, 0);
                pagenumber4.setTextColor(Color.WHITE);
                pagenumber5.setTextColor(Color.WHITE);
            }
            else if(pagenumberTxt == 4){
                pageImage.setBackgroundResource(R.drawable.im4);
                pagenumber1.setTextColor(Color.WHITE);
                pagenumber2.setTextColor(Color.WHITE);
                pagenumber3.setTextColor(Color.WHITE);
                pagenumber4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.textpage1, 0, 0, 0);
                pagenumber5.setTextColor(Color.WHITE);
            }
            else if(pagenumberTxt == 5){
                pageImage.setBackgroundResource(R.drawable.im5);
                pagenumber1.setTextColor(Color.WHITE);
                pagenumber2.setTextColor(Color.WHITE);
                pagenumber3.setTextColor(Color.WHITE);
                pagenumber4.setTextColor(Color.WHITE);
                pagenumber5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.textpage1, 0, 0, 0);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ((ViewPager) container).addView(layout, 0);
        return layout;
    }



    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);
    }


    @Override
    public Parcelable saveState() {
        return null;
    }









    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return size;
    }
}
