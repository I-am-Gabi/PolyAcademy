package polytech.unice.fr.polynews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import polytech.unice.fr.polynews.MainActivity;
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
    private static final CharSequence Titles[]={"Polytech","Planning", "Contact", "Gallery"};
    //private CharSequence Titles[]={"@+id/title_polytech","@+id/title_planning", "@+id/title_contact", "@+id/title_gallery"};
    private static final int nb_tabs = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
       // getSupportActionBar().hide();

        //Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        //setSupportActionBar(toolbar);
        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
