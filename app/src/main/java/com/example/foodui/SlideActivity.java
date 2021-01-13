package com.example.foodui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideActivity extends AppCompatActivity {
private ViewPager view_Pager;
private SliderAdapter sliderAdapter;
private LinearLayout linear_dots;
private TextView[] tv_dost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        view_Pager = findViewById(R.id.view_pager);
        linear_dots = findViewById(R.id.layout_dots);

        sliderAdapter = new SliderAdapter(SlideActivity.this);
        view_Pager.setAdapter(sliderAdapter);

        addDots(0);

        view_Pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                addDots(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
    private void addDots(int position){
        tv_dost = new TextView[3];
        linear_dots.removeAllViews();
        for (int i=0;i<tv_dost.length;i++){
            tv_dost[i] = new TextView(SlideActivity.this);
            tv_dost[i].setText(Html.fromHtml("&#8226;"));
            tv_dost[i].setTextSize(35);
            tv_dost[i].setTextColor(getResources().getColor(R.color.light_white));

            linear_dots.addView(tv_dost[i]);
        }
        if (tv_dost.length>0){
tv_dost[position].setTextColor(getResources().getColor(R.color.purple_200));
        }
    }
}