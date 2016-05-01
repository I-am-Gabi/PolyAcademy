package polytech.unice.fr.polynews.adapter;

/**
 *
 * Created by hp1 on 21-01-2015.
 * @version adapted by Raquel 21/04/16.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import polytech.unice.fr.polynews.fragment.info.ContactFragment;
import polytech.unice.fr.polynews.fragment.info.PlanningFragment;
import polytech.unice.fr.polynews.fragment.info.PolytechFragment;

public class InfoAdapter extends FragmentStatePagerAdapter {

    private CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    private int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public InfoAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {
        if (position == 0) { // if the position is 0 we are returning the First tab
            PolytechFragment about_polytech = new PolytechFragment();
            return about_polytech;
        } else if (position == 1) {
            PlanningFragment planningFragment = new PlanningFragment();
            return planningFragment;
        } else {
            ContactFragment contactFragment = new ContactFragment();
            return contactFragment;
        }
    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}