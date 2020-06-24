package com.example.tabssample;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    ViewPager viewPager;
    TabLayout tabLayout;
    MyAdapter adapter;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Exit");
        AlertDialog.Builder builder = alertDialogBuilder.setMessage("Do you really want to exit?").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();
       // super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         //initilyse the variable reference
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        //assign the addapter and take tabs count
        adapter = new MyAdapter(getSupportFragmentManager(), 3);
       //set adapter to view pager
        viewPager.setAdapter(adapter);
        //assign viewpager to tablayout
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.getTabAt(0).setText("A").setIcon(R.drawable.ic_launcher_background);
        tabLayout.getTabAt(1).setText("B");
        tabLayout.getTabAt(2).setText("C");



    }
//MyAdapter class ectends FragmentPageAdapter
    public class MyAdapter extends FragmentPagerAdapter {
        int tabsCount;

        public MyAdapter(@NonNull FragmentManager fm, int tabsCount) {
            super(fm);
            this.tabsCount = tabsCount;
        }

        @Override
        public int getCount() {
           //give tabs count
            return tabsCount;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            //take fragment and give position what you have
            switch (position) {
                case 0:
                    fragment = new TabFragment1();
                    break;
                case 1:
                    fragment = new TabFragment2();
                    break;
                case 2:
                    fragment = new TabFragment3();
                    break;
            }


            return fragment;
        }


      /*  @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String title = "";
            if (position == 0) {
                title = "Tab_1";
            }
            if (position == 1) {
                title = "Tab_2";
            }

            if (position == 2) {
                title = "Tab_3";
            }

            return title;
        }*/
    }
}
