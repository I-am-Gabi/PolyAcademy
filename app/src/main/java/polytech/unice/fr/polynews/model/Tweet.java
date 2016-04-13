package polytech.unice.fr.polynews.model;

/**
 * @version 06/04/16.
 */
public class Tweet {
    String tweetBy;
    String tweet;
    String picture_profile;

    public Tweet(String tweetBy, String tweet, String picture_profile) {
        this.tweetBy = tweetBy;
        this.tweet = tweet;
        this.picture_profile = picture_profile;
    }

    public String getTweetBy() {
        return tweetBy;
    }

    public String getTweet() {
        return tweet;
    }

    public String getPicture_profile() {
        return picture_profile;
    }
}