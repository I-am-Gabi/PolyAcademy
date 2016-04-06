package polytech.unice.fr.polynews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.model.Tweet;

/**
 * @version 06/04/16.
 */
public class TweetListAdaptor extends ArrayAdapter<Tweet> {
    private List<Tweet> tweets;

    public TweetListAdaptor(Context context, int textViewResourceId, List<Tweet> objects) {
        super(context, textViewResourceId, objects);
        this.tweets = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            //LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_tweet, parent, false);
            //v = vi.inflate(R.layout.list_item_tweet, null);
        }
        Tweet o = tweets.get(position);
        TextView tt = (TextView) v.findViewById(R.id.toptext);
        TextView bt = (TextView) v.findViewById(R.id.bottomtext);
        tt.setText(o.getContent());
        bt.setText(o.getAuthor());

        return v;
    }
}
