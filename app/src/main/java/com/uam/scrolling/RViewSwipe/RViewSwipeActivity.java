package com.uam.scrolling.RViewSwipe;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.tubb.smrv.SwipeMenuRecyclerView;
import com.uam.scrolling.MyRecycleView;
import com.uam.scrolling.R;

import java.util.ArrayList;
import java.util.List;

public class RViewSwipeActivity extends AppCompatActivity {

    private Toolbar toolbar;
//    private TabLayout tabLayout;
//    private ViewPager viewPager;

    protected SwipeMenuRecyclerView mRecyclerView;
    protected SwipeRefreshLayout swipeRefreshLayout;
    protected RVAdapter mAdapter;
    private ArrayList<RVModel> listContentArr= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
        setContentView(R.layout.activity_rview_swipe);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RViewSwipeActivity.this, MyRecycleView.class);
                startActivity(i);

            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
         **/

        setContentView(R.layout.activity_swiper_rv);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RViewSwipeActivity.this, MyRecycleView.class);
                startActivity(i);

            }
        });


        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getApplicationContext(), "Refresh success", Toast.LENGTH_LONG).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        mRecyclerView = (SwipeMenuRecyclerView) findViewById(R.id.listView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        mAdapter = new RVAdapter(getApplicationContext());
        listContentArr.add(new RVModel("02BW01803","12-01-2017","Off Highway Trucks 789C", 90));
        listContentArr.add(new RVModel("0B1P06084","12-02-2017","Articulated Trucks 740", (float) 85.5));
        listContentArr.add(new RVModel("0DFM00849","12-03-2017","Hydraulic Excavators 320D2", 70));

        mAdapter.setListContent(listContentArr);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setupViewPager(ViewPager viewPager) {
        RViewSwipeActivity.ViewPagerAdapter adapter = new RViewSwipeActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RVFragment(), "IN Progress");
        adapter.addFragment(new RVFragment(), "Complete");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
