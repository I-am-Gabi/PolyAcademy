package polytech.unice.fr.polynews.model;

/**
 * @version 06/04/16.
 */
public class Tweet {
    String tweetBy;
    String tweet;

    public Tweet(String tweetBy, String tweet) {
        this.tweetBy = tweetBy;
        this.tweet = tweet;
    }

    public String getTweetBy() {
        return tweetBy;
    }

    public String getTweet() {
        return tweet;
    }
}