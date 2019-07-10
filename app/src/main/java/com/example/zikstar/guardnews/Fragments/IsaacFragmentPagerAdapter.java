package com.example.zikstar.guardnews.Fragments;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class IsaacFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] tabTitles = new String[]{"World","Football","Business","Culture","Food","Music","Politics","Technology","Travel"};

    public IsaacFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new WorldFragment();
            case 1:
                return new FootballFragment();
            case 2:
                return new BusinessFragment();
            case 3:
                return new CultureFragment();
            case 4:
                return new FoodFragment();
            case 5:
                return new MusicFragment();
            case 6:
                return new PoliticsFragment();
            case 7:
                return new TechnologyFragment();
            case 8:
                return new TravelFragment();

            default:
                return null;

        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
