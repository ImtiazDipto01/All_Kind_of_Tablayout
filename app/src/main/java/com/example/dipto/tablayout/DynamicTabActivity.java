package com.example.dipto.tablayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.dipto.tablayout.fragment.BlankFragment;
import com.example.dipto.tablayout.fragment.home_fragment;
import com.example.dipto.tablayout.fragment.lock_fragment;
import com.example.dipto.tablayout.fragment.love_fragment;
import com.example.dipto.tablayout.fragment.user_fragment;

import java.util.ArrayList;
import java.util.List;

public class DynamicTabActivity extends AppCompatActivity {

    Toolbar toolbar ;
    ViewPager viewPager ;
    TabLayout tabLayout ;
    SharedPreferences sharedPreferences ;
    ViewPagerAdapter viewPagerAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_tab);

        sharedPreferences = getSharedPreferences("PREFS_TABLAYOUT", MODE_PRIVATE) ;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showCustomToolbar();

        viewPager = (ViewPager) findViewById(R.id.viewpager) ;
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_add) {
            int value = sharedPreferences.getInt("TAB_NUMBER", 0) ;
            if(value == 0){
                value += 3 ;
            }
            else {
                value += 1 ;
            }
            sharedPreferences.edit().putInt("TAB_NUMBER", value).apply();
            Bundle bundle = new Bundle();
            bundle.putString("id", String.valueOf(value));
            BlankFragment blankFragment = new BlankFragment();
            blankFragment.setArguments(bundle);
            String tabName = "TAB_"+value ;

            viewPagerAdapter.addFragment(blankFragment, tabName);
            viewPagerAdapter.notifyDataSetChanged();

            return true ;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager){
        Bundle bundle = new Bundle();
        bundle.putString("id", "1");
        Bundle bundle2 = new Bundle();
        bundle2.putString("id", "2");

        BlankFragment blankFragment = new BlankFragment();
        blankFragment.setArguments(bundle);

        BlankFragment blankFragment2 = new BlankFragment();
        blankFragment2.setArguments(bundle);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager()) ;
        viewPagerAdapter.addFragment(blankFragment, "TAB_1");
        viewPagerAdapter.addFragment(blankFragment2, "TAB_2");
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

}
