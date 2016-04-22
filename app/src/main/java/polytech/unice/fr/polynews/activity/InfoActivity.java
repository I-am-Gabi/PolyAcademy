package polytech.unice.fr.polynews.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.adapter.InfoAdapter;
import polytech.unice.fr.polynews.fragment.info.tab.SlidingTabLayout;


/**
 *
 */
public class InfoActivity extends AppCompatActivity{
    private ViewPager pager;
    private InfoAdapter adapter;
    private SlidingTabLayout tabs;
    private CharSequence Titles[]={"Polytech","Planning"};
    private int nb_tabs =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
       // getSupportActionBar().hide();

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new InfoAdapter(getSupportFragmentManager(),Titles,nb_tabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        //Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true.

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);



    }
}
