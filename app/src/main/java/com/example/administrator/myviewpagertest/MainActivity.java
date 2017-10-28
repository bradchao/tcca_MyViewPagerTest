package com.example.administrator.myviewpagertest;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<View> views;
    private TextView tv1;
    private ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tv1 = (TextView)findViewById(R.id.tv1);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        initViewPager();
    }

    public void test1(View view){
        tv1.setText("Hello, Brad");
    }


    private void initViewPager(){
        LayoutInflater inflater = LayoutInflater.from(this);

        views = new ArrayList<>();
        View page1 = inflater.inflate(R.layout.page1, null);
        View page2 = inflater.inflate(R.layout.page2, null);
        View page3 = inflater.inflate(R.layout.page3, null);
        views.add(page1);views.add(page2);views.add(page3);

        tv1 = (TextView)page1.findViewById(R.id.tv1);
        flipper = (ViewFlipper)page2.findViewById(R.id.flipper);

        View f0 = flipper.getChildAt(0);
        View f1 = flipper.getChildAt(1);
        View f2 = flipper.getChildAt(2);

        f0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });


        viewPager.setAdapter(new MyPagerAdapter());


    }

    private class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = views.get(position);
            viewPager.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            View view = views.get(position);
            viewPager.removeView(view);
        }
    }



}
