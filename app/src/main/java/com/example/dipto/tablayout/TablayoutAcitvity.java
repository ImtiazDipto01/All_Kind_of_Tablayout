package com.example.dipto.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.example.dipto.tablayout.fragment.home_fragment;
import com.example.dipto.tablayout.fragment.lock_fragment;
import com.example.dipto.tablayout.fragment.love_fragment;
import com.example.dipto.tablayout.fragment.user_fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dipto on 4/29/2017.
 */

public class TablayoutAcitvity extends AppCompatActivity {

    Toolbar toolbar ;
    ViewPager viewPager ;
    TabLayout tabLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showCustomToolbar();

        viewPager = (ViewPager) findViewById(R.id.viewpager) ;
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager()) ;
        viewPagerAdapter.addFragment(new home_fragment(), "Home");
        viewPagerAdapter.addFragment(new lock_fragment(), "Lock");
        viewPagerAdapter.addFragment(new love_fragment(), "Love");
        viewPagerAdapter.addFragment(new user_fragment(), "User");
        viewPager.setAdapter(viewPagerAdapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentList = new ArrayList<>() ;
        private final List<String> fragmentTitle = new ArrayList<>() ;

        public ViewPagerAdapter(FragmentManager manager){
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position) ;
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }


        public void addFragment(Fragment fragment, String title){
            fragmentList.add(fragment) ;
            fragmentTitle.add(title) ;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position) ;
        }
    }

    private void showCustomToolbar(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
