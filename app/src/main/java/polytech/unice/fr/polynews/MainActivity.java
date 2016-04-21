package polytech.unice.fr.polynews;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;
import polytech.unice.fr.polynews.activity.TwitterFeedActivity;
import polytech.unice.fr.polynews.fragment.CampusHomeFragment;
import polytech.unice.fr.polynews.fragment.EventsFragment;
import polytech.unice.fr.polynews.fragment.HomeFragment;

import static polytech.unice.fr.polynews.R.string.navigation_drawer_close;

/**
 * @see <a href="https://github.com/smuldr/design-support-demo">Android Design Support Library Demo</a>
 * @see <a href="https://github.com/codepath/android_guides/wiki/Fragment-Navigation-Drawer">Fragment Navigation Drawer</a>
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "d4c5QBgKTlZQQtDo17RCv4owQ";
    private static final String TWITTER_SECRET = "VC5kBZRmY1E9USKFv4PHngUL3ka2QjoWxQ66gHMzNtAXMd0ZB8";


    private static final String NAV_ITEM_ID = "navItemId";
    private static final long DRAWER_CLOSE_DELAY_MS = 350;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private int nav_item_id;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
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

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationHandler(nav_item_id);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
            case R.id.nav_campus:
                drawer.openDrawer(GravityCompat.START);
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
     *
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
     *
     * @param menuItemId
     */
    public void navigationHandler(int menuItemId) {
        switch (menuItemId) {
            case R.id.nav_events:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, EventsFragment.newInstance())
                        .commit();

                break;
            case R.id.nav_home:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, HomeFragment.newInstance())
                        .commit();
                break;
            case R.id.nav_campus:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, CampusHomeFragment.newInstance())
                        .commit();
                break;
            case R.id.nav_twitter:
                Intent intent = new Intent(this, TwitterFeedActivity.class);
                this.startActivity(intent);
            default:
                break;
        }
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://polytech.unice.fr.polynews/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://polytech.unice.fr.polynews/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
