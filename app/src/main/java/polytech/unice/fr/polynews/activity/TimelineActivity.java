package polytech.unice.fr.polynews.activity;

import android.app.ListActivity;
import android.os.Bundle;

import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import polytech.unice.fr.polynews.R;

/**
 * @version 05/04/16.
 */
public class TimelineActivity extends ListActivity {

    private static final String TWITTER_KEY = "KXD76JSTl2g5SoRjWBO0zTcCW";
    private static final String TWITTER_SECRET = "yhqjfad0Jj9KZtpaXglsLLRiD4A4Va6VTkNgTFcHYbnovQ8csT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tweet);

        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("_gabiCavalcante")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter(this, userTimeline);
        setListAdapter(adapter);
    }
}
