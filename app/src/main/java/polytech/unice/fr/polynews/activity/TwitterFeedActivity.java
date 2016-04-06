package polytech.unice.fr.polynews.activity;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.adapter.TweetAdapter;
import polytech.unice.fr.polynews.model.Tweet;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @version 06/04/16.
 */
public class TwitterFeedActivity extends ListActivity {
    private static final String TWIT_CONS_KEY = "KXD76JSTl2g5SoRjWBO0zTcCW";
    private static final String TWIT_CONS_SEC_KEY = "yhqjfad0Jj9KZtpaXglsLLRiD4A4Va6VTkNgTFcHYbnovQ8csT";
    protected ListView list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);
        list = (ListView) findViewById(android.R.id.list);

        new TwitterFeedTask().execute("_gabiCavalcante");
    }

    private class TwitterFeedTask extends AsyncTask<String, Void, Integer> {
        private ProgressDialog progressDialog;
        private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
        final int SUCCESS = 0;
        final int FAILURE = SUCCESS + 1;

        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(TwitterFeedActivity.this,
                    "", "Loading. Please wait...", true);
        }

        @Override
        protected Integer doInBackground(String... params) {
            try {
                ConfigurationBuilder builder = new ConfigurationBuilder();
                // builder.setUseSSL(true);
                builder.setApplicationOnlyAuthEnabled(true);
                builder.setOAuthConsumerKey(TWIT_CONS_KEY);
                builder.setOAuthConsumerSecret(TWIT_CONS_SEC_KEY);

                OAuth2Token token = new TwitterFactory(builder.build()).getInstance().getOAuth2Token();

                builder = new ConfigurationBuilder();
                builder.setApplicationOnlyAuthEnabled(true);
                builder.setOAuthConsumerKey(TWIT_CONS_KEY);
                builder.setOAuthConsumerSecret(TWIT_CONS_SEC_KEY);
                builder.setOAuth2TokenType(token.getTokenType());
                builder.setOAuth2AccessToken(token.getAccessToken());

                Twitter twitter = new TwitterFactory(builder.build()).getInstance();

                Query query = new Query(params[0]);
                // You can set the count of maximum records here
                query.setCount(5);
                QueryResult result;
                result = twitter.search(query);
                List<twitter4j.Status> tweets = result.getTweets();
                StringBuilder str = new StringBuilder();
                if (tweets != null) {
                    this.tweets = new ArrayList<>();
                    for (twitter4j.Status tweet : tweets) {
                        str.append("@" + tweet.getUser().getScreenName() + " - " + tweet.getText() + "\n");
                        this.tweets.add(new Tweet("@" + tweet.getUser().getScreenName(), tweet.getText()));
                    }
                    return SUCCESS;
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return FAILURE;
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            if (result == SUCCESS) {
                list.setAdapter(new TweetAdapter(TwitterFeedActivity.this, tweets));
            } else {
                Toast.makeText(TwitterFeedActivity.this, "Error twitter", Toast.LENGTH_LONG).show();
            }
        }
    }
}