package ru.ateams.exam;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    @BindView(R.id.coordinator)
    CoordinatorLayout mCoordinator;
    @BindView(R.id.navigation)
    AHBottomNavigation mBottomNavigation;
    @BindView(R.id.viewpager)
    AHBottomNavigationViewPager mViewPager;

    private int[] mTabColors;
    private AHBottomNavigationAdapter mNavigationAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(R.string.app_title);

        mViewPager.setAdapter(new NavigationAdapter(getSupportFragmentManager()));

        mTabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
        mNavigationAdapter = new AHBottomNavigationAdapter(this, R.menu.navigation);
        mNavigationAdapter.setupWithBottomNavigation(mBottomNavigation, mTabColors);

        //mBottomNavigation.setTranslucentNavigationEnabled(true);

        mBottomNavigation.setColored(true);
        mBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        mBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                if (!wasSelected) {
                    mViewPager.setCurrentItem(position);
                    return true;
                }
                return false;
            }
        });
    }



}
