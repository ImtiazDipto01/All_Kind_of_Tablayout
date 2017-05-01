package com.example.dipto.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.dipto.tablayout.fragment.home_fragment;
import com.example.dipto.tablayout.fragment.lock_fragment;
import com.example.dipto.tablayout.fragment.love_fragment;
import com.example.dipto.tablayout.fragment.user_fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dipto on 5/1/2017.
 */

public class TextandIconTablyout extends AppCompatActivity {

    TabLayout tabLayout ;
    ViewPager viewPager ;
    Toolbar toolbar ;
    private int icons[] = {R.drawable.home,
                        R.drawable.lock,
                        R.drawable.love,
                        R.drawable.user} ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_icon_tablayout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showCustomToolbar();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setUpViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        setupicon();
    }

    private void setUpViewPager(ViewPager viewPager){

        ViewPagerAdapter_icon_text adapter = new ViewPagerAdapter_icon_text(getSupportFragmentManager()) ;
        adapter.addfragment(new home_fragment(), "Home");
        adapter.addfragment(new lock_fragment(), "Lock");
        adapter.addfragment(new love_fragment(), "Love");
        adapter.addfragment(new user_fragment(), "User");
        viewPager.setAdapter(adapter);
    }

    private void setupicon(){

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.lock);
        tabLayout.getTabAt(2).setIcon(R.drawable.love);
        tabLayout.getTabAt(3).setIcon(R.drawable.user);
    }

    class ViewPagerAdapter_icon_text extends FragmentPagerAdapter{

        List<Fragment> fragmentList = new ArrayList<>() ;
        List<String> fragmenttitle = new ArrayList<>() ;

        public ViewPagerAdapter_icon_text(FragmentManager fm) {
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
