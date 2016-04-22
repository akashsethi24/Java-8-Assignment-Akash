package com.knoldus;

import twitter4j.Status;
import java.util.Comparator;
import java.util.List;

/**
 * This class performs various Operation on Tweet
 * Method Reference is Used for Printing Tweet Attributes
 * Lambda Expressions is Used  For Comparing
 */
public class Runner {

    public static void main(String[] args) {
        try {

            FetchDataFromTwitter object = new FetchDataFromTwitter();
            List<Status> list = object.getTweetsFile();

            Comparator<Status> compareByDate = (Status one,Status two) -> one.getCreatedAt().compareTo(two.getCreatedAt());
            Comparator<Status> compareByReTweet = (Status one,Status two) -> ((Integer)one.getRetweetCount()).compareTo((Integer)two.getRetweetCount());
            Comparator<Status> compareByLike = (Status one,Status two) -> ((Integer)one.getFavoriteCount()).compareTo((Integer)two.getFavoriteCount());

            list.sort(compareByDate);
            System.out.println("Compared By Date -");
            list.stream().forEach(object::prettyPrint);

            list.sort(compareByReTweet);
            System.out.println("Compared By ReTweets -");
            list.stream().forEach(object::prettyPrint);

            list.sort(compareByLike);
            System.out.println("Compared By Like -");
            list.stream().forEach(object::prettyPrint);
        }
        catch (Exception ex){

            System.out.println("Oops ! Something went wrong it looks like you are not Connected to Internet");
        }
    }
}
