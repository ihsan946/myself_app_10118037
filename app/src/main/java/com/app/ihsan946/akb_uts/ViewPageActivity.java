package com.app.ihsan946.akb_uts;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.app.ihsan946.adapter.SectionAdapter;
import com.app.ihsan946.fragment.FutureFragment;
import com.app.ihsan946.fragment.UserFragment;
import com.app.ihsan946.fragment.homeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;


public class ViewPageActivity extends AppCompatActivity {

    ViewPager view;
    BottomNavigationView navigation;
    FutureFragment future;
    homeFragment home;
    UserFragment user;
    MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        view = findViewById(R.id.view_pager);
        setupViewPager(view);
        DotsIndicator dotsIndicator = findViewById(R.id.indicator_view);
        dotsIndicator.setViewPager(view);


//        navigation = findViewById(R.id.bottom_nav);
//        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.menu1 :
//                        view.setCurrentItem(0);
//                        break;
//                    case R.id.menu2 :
//                        view.setCurrentItem(1);
//                        break;
//                    case R.id.menu3 :
//                        view.setCurrentItem(2);
//                        break;
//
//                }
//                return false;
//            }
//        });
//
//        view.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                navigation.getMenu().getItem(position).setChecked(true);
//                menuItem = navigation.getMenu().getItem(position);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionAdapter adapter = new SectionAdapter(getSupportFragmentManager());
        home = new homeFragment();
        future = new FutureFragment();
        user = new UserFragment();

        adapter.addFragment(home);
        adapter.addFragment(future);
        adapter.addFragment(user);
        viewPager.setAdapter(adapter);

    }




}