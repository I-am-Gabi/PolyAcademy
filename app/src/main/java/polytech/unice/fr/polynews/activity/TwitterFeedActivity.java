package polytech.unice.fr.polynews.activity;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.adapter.TweetListAdaptor;
import polytech.unice.fr.polynews.model.Tweet;

/**
 * @version 06/04/16.
 */
public class TwitterFeedActivity extends ListActivity {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new TwitterFeedTask().execute();
    }

    private class TwitterFeedTask extends AsyncTask<Void, Void, Void> {
        private ProgressDialog progressDialog;

        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(TwitterFeedActivity.this,
                    "", "Loading. Please wait...", true);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                HttpClient hc = new DefaultHttpClient();
                HttpGet get = new
                        HttpGet("http://search.twitter.com/search.json?q=android");
                HttpResponse rp = hc.execute(get);

                if(rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
                {
                    String result = EntityUtils.toString(rp.getEntity());
                    JSONObject root = new JSONObject(result);
                    JSONArray sessions = root.getJSONArray("results");
                    for (int i = 0; i < sessions.length(); i++) {
                        JSONObject session = sessions.getJSONObject(i);

                        Tweet tweet = new Tweet();
                        tweet.setContent(session.getString("text"));
                        tweet.setAuthor(session.getString("from_user"));
                        tweets.add(tweet);
                    }
                }

            } catch (Exception e) {
                Log.e("TwitterFeedActivity", "Error loading JSON", e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            progressDialog.dismiss();
            TweetListAdaptor adaptor = new TweetListAdaptor(TwitterFeedActivity.this, R.layout.list_item_tweet, tweets);
            setListAdapter(adaptor);
        }
    }
}