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
 * Created by Dipto on 5/1/2017.
 */

public class BottomScrollTablayout extends AppCompatActivity {

    TabLayout tabLayout ;
    ViewPager viewPager ;
    Toolbar toolbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_scroll_tablayout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showCustomToolbar();

        viewPager = (ViewPager) findViewById(R.id.viewpager) ;
        setUpViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        setupicon();
    }

    private void setUpViewPager(ViewPager viewPager){

        ViewPagerAdapter_bottom adapter = new ViewPagerAdapter_bottom(getSupportFragmentManager()) ;
        adapter.addfragment(new home_fragment(), "About Us");
        adapter.addfragment(new lock_fragment(), "Categories");
        adapter.addfragment(new love_fragment(), "Call Ambulance");
        adapter.addfragment(new user_fragment(), "Profile");
        adapter.addfragment(new home_fragment(), "Cash Sheet");
        adapter.addfragment(new lock_fragment(), "Book Appt");
        adapter.addfragment(new love_fragment(), "Cancle Appt");
        adapter.addfragment(new user_fragment(), "Lab Report");
        viewPager.setAdapter(adapter);
    }

    private void setupicon(){

        tabLayout.getTabAt(0).setIcon(R.drawable.forma);
        tabLayout.getTabAt(1).setIcon(R.drawable.menu);
        tabLayout.getTabAt(2).setIcon(R.drawable.ambu);
        tabLayout.getTabAt(3).setIcon(R.drawable.account);
        tabLayout.getTabAt(4).setIcon(R.drawable.sheet);
        tabLayout.getTabAt(5).setIcon(R.drawable.calendarm);
        tabLayout.getTabAt(6).setIcon(R.drawable.shape);
        tabLayout.getTabAt(7).setIcon(R.drawable.shape_two);
    }


    class ViewPagerAdapter_bottom extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<>() ;
        List<String> fragmenttitle = new ArrayList<>() ;

        public ViewPagerAdapter_bottom(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addfragment(Fragment fragment, String title){
            fragmentList.add(fragment) ;
            fragmenttitle.add(title) ;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return fragmenttitle.get(position);
                case 1:
                    return fragmenttitle.get(position);
                case 2:
                    return fragmenttitle.get(position);
                case 3:
                    return fragmenttitle.get(position);
                case 4:
                    return fragmenttitle.get(position);
                case 5:
                    return fragmenttitle.get(position);
                case 6:
                    return fragmenttitle.get(position);
                case 7:
                    return fragmenttitle.get(position);
                default:
                    return "";
            }
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
