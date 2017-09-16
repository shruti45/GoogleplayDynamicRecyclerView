package com.example.user.googleplaydynamicrecyclerview;

/**
 * Created by user on 3/30/2016.
 */
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class Tab1 extends Fragment  {

    private RecyclerView recyclerview, recyclerView2;
    private static final String TAG = "Tab1";
    RecyclerAdapter adapter;
    Context context;
    View vw;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vw = inflater.inflate(R.layout.tab1, container, false);

        Integer value = getActivity().getIntent().getExtras().getInt("value_1");
        Integer value2=getActivity().getIntent().getExtras().getInt("value_2");
        System.out.println("val2" + value2);


        // to create buttons dynamically
        RelativeLayout rl = (RelativeLayout) vw.findViewById(R.id.rel);

        HorizontalScrollView sv = new HorizontalScrollView(this.getActivity());
        sv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        sv.setHorizontalScrollBarEnabled(false);
        LinearLayout ll = new LinearLayout(this.getActivity());
        ll.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ll.setOrientation(LinearLayout.HORIZONTAL);
        sv.addView(ll);

        for (
                int i = 0;
                i < value; i++)

        {
            Button b = new Button(this.getActivity());
            b.setBackground(this.getResources().getDrawable(R.drawable.layou_border));
            LinearLayout.LayoutParams rel_button1 = new LinearLayout.LayoutParams(190, 60);
            rel_button1.setMargins(5, 10, 0, 0);
            b.setLayoutParams(rel_button1);
            b.setText("Button " + i);
            b.setTextColor(Color.WHITE);
            b.setTextSize(15);
            ll.addView(b);
        }

        rl.addView(sv);

        //to create dynamic recyclerview
        LinearLayout linrcv = (LinearLayout) vw.findViewById(R.id.linrecyclertab1);
        linrcv.setOrientation(LinearLayout.VERTICAL);

        for (
                int j= 0;
                j < value2; j++)

        {
            adapter=new RecyclerAdapter(this);
            recyclerview=new RecyclerView(this.getActivity());
            LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 480));
            params.setMargins(0, 0, 0, 0);
            recyclerview.setLayoutParams(params);
            recyclerview.setRecycledViewPool(new RecyclerView.RecycledViewPool());
            recyclerview.setNestedScrollingEnabled(false);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
            // Control orientation of the items
            // also supports LinearLayoutManager.HORIZONTAL
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
         // Optionally customize the position you want to default scroll to
           // layoutManager.scrollToPosition(0);
            // Attach layout manager to the RecyclerView
            recyclerview.setLayoutManager(layoutManager);
           /* RecyclerView.LayoutManager layoutmanager=new LinearLayoutManager(getActivity().getBaseContext());
            LinearLayoutManager layoutManager1
                    = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);

            recyclerview.setLayoutManager(layoutManager1);*/
            vw.setTag(TAG);
            recyclerview.setAdapter(adapter);
            linrcv.addView(recyclerview);
        }

        return vw;
    }
}





