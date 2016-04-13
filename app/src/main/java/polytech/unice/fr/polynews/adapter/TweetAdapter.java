package polytech.unice.fr.polynews.adapter;

/**
 * @versao 06/04/16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.activity.DownloadPictures;
import polytech.unice.fr.polynews.model.Tweet;

public class TweetAdapter extends ArrayAdapter<Tweet> {
    private List<Tweet> tweetList;
    private Context context;

    public static class ViewHolder {
        public TextView txtTweet;
        public TextView txtTweetBy;
        public ImageView imageTweetBy;
    }

    public TweetAdapter(Context context, List<Tweet> tweetList) {
        super(context, -1, tweetList);
        this.tweetList = tweetList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item_tweet, null);
            holder = new ViewHolder();
            holder.txtTweet = (TextView) convertView.findViewById(R.id.txtTweet);
            holder.txtTweetBy = (TextView) convertView.findViewById(R.id.txtTweetBy);
            holder.imageTweetBy = (ImageView) convertView.findViewById(R.id.imageTweetBy);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Tweet tweet = tweetList.get(position);

        holder.txtTweet.setText(tweet.getTweet());
        holder.txtTweetBy.setText(tweet.getTweetBy());

        // imageView.setImageResource(R.drawable.icon);
        DownloadPictures task = new DownloadPictures(holder.imageTweetBy, getContext());
        task.execute(tweet.getPicture_profile());

        return convertView;
    }
}