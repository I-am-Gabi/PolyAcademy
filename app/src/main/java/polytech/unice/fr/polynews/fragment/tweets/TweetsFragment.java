package polytech.unice.fr.polynews.fragment.tweets;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.adapter.TweetAdapter;
import polytech.unice.fr.polynews.model.Tweet;

/**
 * @version 07/04/16.
 */
public class TweetsFragment extends Fragment {
    /**
     * Returns a new instance of this polytech.unice.fr.polynews.fragment for the given section
     * number.
     */
    public static TweetsFragment newInstance() {
        TweetsFragment fragment = new TweetsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_twitter, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TweetAdapter adapter = new TweetAdapter(getActivity(), new ArrayList<Tweet>());

        ListView list = (ListView) getView().findViewById(android.R.id.list);
        list.setAdapter(adapter);
    }
}
