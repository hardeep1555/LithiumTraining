package main;

import twitter4j.Twitter;
import twitter4j.TwitterException;

public class PostTweet {


    public void postStatus(Twitter twitter, String status){
        try {
            twitter.updateStatus(status);
            System.out.println("tweet successfully posted");
        } catch (TwitterException e) {
            System.out.println("Exception occured while posting tweet");
            e.printStackTrace();
        }
    }
}
