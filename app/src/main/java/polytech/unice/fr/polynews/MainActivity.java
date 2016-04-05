package polytech.unice.fr.polynews;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import polytech.unice.fr.polynews.fragment.EventsFragment;
import polytech.unice.fr.polynews.fragment.HomeFragment;

/**
 * @see <a href="https://github.com/smuldr/design-support-demo">Android Design Support Library Demo</a>
 * @see <a href="https://github.com/codepath/android_guides/wiki/Fragment-Navigation-Drawer">Fragment Navigation Drawer</a>
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String NAV_ITEM_ID = "navItemId";
    private static final long DRAWER_CLOSE_DELAY_MS = 350;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private int nav_item_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up the menu icon to open and close the drawer
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // initializing the toolbar and setting it as actionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // load saved navigation state if exists
        if (null == savedInstanceState)
            nav_item_id = R.id.nav_home;
        else
            nav_item_id = savedInstanceState.getInt(NAV_ITEM_ID);

        // initializing Navigation view in activity class
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        // listen for navigation events
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);

        // select the correct nav menu item
        navigationView.getMenu().findItem(nav_item_id).setChecked(true);

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationHandler(nav_item_id);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                drawer.openDrawer(GravityCompat.START);
                return true;
            case R.id.nav_events:
                drawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        item.setChecked(true);
        nav_item_id = item.getItemId();

        drawer.closeDrawer(GravityCompat.START);
        drawer.postDelayed(new Runnable() {
            @Override
            public void run() {
                navigationHandler(item.getItemId());
            }
        }, DRAWER_CLOSE_DELAY_MS);
        return true;
    }

    /**
     * Called by the system when the device configuration changes while your activity is running.
     * @param newConfiguration The new device configuration.
     */
    @Override
    public void onConfigurationChanged(final Configuration newConfiguration) {
        super.onConfigurationChanged(newConfiguration);
        toggle.onConfigurationChanged(newConfiguration);
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NAV_ITEM_ID, nav_item_id);
    }

    /**
     * Update the content fragment
     * @param menuItemId
     */
    public void navigationHandler(int menuItemId) {
        switch (menuItemId) {
            case R.id.nav_events:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, EventsFragment.newInstance())
                        .commit();
                        //Intent intent = new Intent(this, CardViewActivity.class);
                        //this.startActivity(intent);

                break;
            case R.id.nav_home:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, HomeFragment.newInstance())
                        .commit();
                break;
            default:
                break;
        }
    }
}
