package ru.ateams.exam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class NavigationAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    private Fragment currentFragment;

    public NavigationAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new CardsFragment());
        fragments.add(new ContactsFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        currentFragment = ((Fragment) object);
        super.setPrimaryItem(container, position, object);
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }
}