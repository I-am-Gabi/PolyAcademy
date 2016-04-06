package polytech.unice.fr.polynews.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetUi;
import com.twitter.sdk.android.tweetui.UserTimeline;

import io.fabric.sdk.android.Fabric;
import polytech.unice.fr.polynews.R;

/**
 * @version 02/04/16.
 */
public class SearchTimelineFragment extends ListFragment {


    private static final String TWITTER_KEY = "d4c5QBgKTlZQQtDo17RCv4owQ";
    private static final String TWITTER_SECRET = "VC5kBZRmY1E9USKFv4PHngUL3ka2QjoWxQ66gHMzNtAXMd0ZB8";


    /**
     * Returns a new instance of this polytech.unice.fr.polynews.fragment for the given section
     * number.
     */
    public static SearchTimelineFragment newInstance() {
        SearchTimelineFragment fragment = new SearchTimelineFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig =  new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(getActivity(), new TwitterCore(authConfig), new TweetUi());

        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("fabric")
                .build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getActivity())
                .setTimeline(userTimeline)
                .build();
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tweet, container, false);
    }
}
