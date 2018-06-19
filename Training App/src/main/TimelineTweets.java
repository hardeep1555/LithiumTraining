package main;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

public class TimelineTweets {

    public void getTweets(Twitter twitter){
        List<Status> statusList =null;
        try {
            statusList = twitter.getHomeTimeline();
        } catch (TwitterException e) {
            System.out.println("Exception occured while reading timelines");
            e.printStackTrace();
        }
        for(Status status:statusList){
            System.out.println(status.getUser().getName() + "----" +status.getText());
        }
    }
}
