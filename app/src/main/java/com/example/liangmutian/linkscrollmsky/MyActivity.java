/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.liangmutian.linkscrollmsky;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class MyActivity extends AppCompatActivity {


    private RelativeLayout toolsRe, backRe, overRe;
    private ViewPager viewPager;
    private View view1, view2;
    private List<View> viewList;
    private PagerAdapter pagerAdapter;
    public static Handler mHandler;


    private RecyclerView listView;
    private LinearLayoutManager layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolsRe = (RelativeLayout) findViewById(R.id.toolsre);
        backRe = (RelativeLayout) findViewById(R.id.backre);
        overRe = (RelativeLayout) findViewById(R.id.over_re);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        LayoutInflater lf = getLayoutInflater().from(this);
        view1 = lf.inflate(R.layout.layout1, null);
        view2 = lf.inflate(R.layout.layout2, null);
        viewList = new ArrayList<View>();
        viewList.add(view1);
        viewList.add(view2);


        listView = (RecyclerView)view1. findViewById(R.id.list);
        List<String> list = new ArrayList<String>();
        for(int i = 0 ; i < 50 ; ++i){
            list.add(" String "+i);
        }
        listView.setAdapter(new StringAdapter(list));
        layoutManager = new LinearLayoutManager(this);
        listView.setLayoutManager(layoutManager);




        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                float alpha = ((float) msg.what) / 100f;
                Log.e("alpha", msg.what + ":" + alpha);
                overRe.setAlpha(alpha);

                if (msg.what == 0) {
                    backRe.setVisibility(View.INVISIBLE);
                    toolsRe.setVisibility(View.VISIBLE);
                } else {
                    backRe.setVisibility(View.VISIBLE);
                    toolsRe.setVisibility(View.INVISIBLE);

                }


            }
        };


        pagerAdapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {

                return arg0 == arg1;
            }

            @Override
            public int getCount() {

                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(viewList.get(position));

            }

            @Override
            public int getItemPosition(Object object) {

                return super.getItemPosition(object);
            }


            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));

                return viewList.get(position);
            }

        };


        viewPager.setAdapter(pagerAdapter);
        backRe.setPadding(0, 0, 0, DensityUtil.getZhuangtai(this));


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        collapsingToolbar.setBackgroundResource(R.drawable.cheese_2);

    }


    public void dodo(View v) {


        viewPager.setCurrentItem(0);


    }

    public void dodo1(View v) {


        viewPager.setCurrentItem(1);

    }

    class StringAdapter extends RecyclerView.Adapter<ViewHolder>{


        private List<String> list ;
        private LayoutInflater inflater;
        StringAdapter( List<String> list ){
            this.list = list ;
            inflater = LayoutInflater.from(MyActivity.this);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
            super.onBindViewHolder(holder, position, payloads);
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item,null,false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tv.setText(list.get(position));

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv ;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.tv);
        }
    }
}
