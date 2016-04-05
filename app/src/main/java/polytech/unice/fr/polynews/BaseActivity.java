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

import polytech.unice.fr.polynews.fragment.HomeFragment;


/**
 * @version 04/04/16.
 */
public abstract class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    protected static final String NAV_ITEM_ID = "navItemId";
    protected static final long DRAWER_CLOSE_DELAY_MS = 350;
    protected DrawerLayout drawer;
    protected ActionBarDrawerToggle toggle;
    protected int nav_item_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                Intent intent = new Intent(this, CardViewActivity.class);
                this.startActivity(intent);
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
