package com.knoldus;


import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.io.*;
import java.util.List;

/**
 * This class with Fetch The Tweets from Akash Sethi's Home Timeline
 */
public class FetchDataFromTwitter {

    /**
     * This Method throws Twitter and IO Exception
     * @return List of Status / Tweets
     */
    public  List<Status> getTweetsFile() throws TwitterException, IOException {

        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                            .setOAuthConsumerKey("3j2yZo97wB044xzQEivnLPstt")
                            .setOAuthConsumerSecret("ewYyc9NBCU8MVqXqLUffyrSIO176rLHcUeOQTwtkcJMVeCo9PE")
                            .setOAuthAccessToken("4838039064-hkTRhpnsvwg1SGASRWVIQDIyhLGSkD3M38QUEox")
                            .setOAuthAccessTokenSecret("ojrwwHRL08p8CDVcpK46QD5pII3seMxWo1jyogzWtW6De");

        TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
        Twitter twitter = twitterFactory.getInstance();

        return twitter.getHomeTimeline();
    }



    /**
     * This Method prints the various attributes of Tweets
     * This Method takes Status as an Argument
     */
    public void prettyPrint(Status status) {

        System.out.println("[ Screen Name - " + status.getUser().getScreenName() + " ]");
        System.out.println("[ ReTweetsCount - " + status.getRetweetCount() + " ]");
        System.out.println("[ Date - " + status.getCreatedAt() + " ]");
        System.out.println("[ Likes - " + status.getFavoriteCount() + " ]");
        System.out.println("[ Text - " + status.getText() + " ]");
        System.out.println();
    }
}
