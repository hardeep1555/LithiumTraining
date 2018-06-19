package main;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TrainingApplication {

    public static void main(String[] args){
        Properties prop = new Properties();
        InputStream input =null;
        try{
            ClassLoader cl =TrainingApplication.class.getClassLoader();
            input = cl.getResourceAsStream("resources/config.properties");

            // load a properties file
            prop.load(input);
            ConfigurationBuilder cb =new ConfigurationBuilder();
            cb.setDebugEnabled(true).setOAuthConsumerKey(prop.getProperty("consumerKey"))
                    .setOAuthConsumerSecret(prop.getProperty("consumerSecret"))
                    .setOAuthAccessToken(prop.getProperty("accessToken"))
                    .setOAuthAccessTokenSecret(prop.getProperty("accessTokenSecret"));
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            //post a tweet
            PostTweet pt = new PostTweet();
            pt.postStatus(twitter,"just testing");
            //get timeline
            TimelineTweets tt = new TimelineTweets();
            tt.getTweets(twitter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
