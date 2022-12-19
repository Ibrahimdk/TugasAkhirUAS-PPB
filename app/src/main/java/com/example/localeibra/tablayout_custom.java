package com.example.localeibra;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class tablayout_custom extends AppCompatActivity {
    //variabel
    TabLayout tabLayout;
    ViewPager viewPager;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout_custom);

        //assign variable
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        //initialize adapter
        adapter = new MainAdapter(getSupportFragmentManager());

        //tambahkan fragment
        adapter.AddFragment(new FragTshirt(), "Tshirt");
        adapter.AddFragment(new fragHoodie(), "Hoodie");
        adapter.AddFragment(new fragJacket(), "Jacket");

        //setAdapter
        viewPager.setAdapter(adapter);

        //sambungkan tab layout dengan viewpager
        tabLayout.setupWithViewPager(viewPager);

    }

    private class MainAdapter extends FragmentPagerAdapter {
    //initiallize arraylist
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

         //buat constructor
        public void AddFragment(Fragment fragment, String s){
            //tambahkan fragment
            fragmentArrayList.add(fragment);
            //tambahkan string
             stringArrayList.add(s);
        }



        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            //return fragment position
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
           //return fragment list size
            return fragmentArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            //rerturn tab title
            return stringArrayList.get(position);
        }
    }
}