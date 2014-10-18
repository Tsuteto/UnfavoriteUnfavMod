package unfavmodunfav;

import twitter4j.FilterQuery;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.AccessToken;

public class Main {
	
	public static Twitter twitter;
	
	public static final String consumerToken = "YourConsumerTokenHere";
	public static final String consumerTokenSecret = "YourConsumerTokenSecretHere";
	
	public static final String accessToken = "YourAccessTokenHere";
	public static final String accessTokenSecret = "YourAccessTokenSecretHere";
	
	public static void main(String args[]) throws TwitterException {
		AccessToken at = new AccessToken(accessToken, accessTokenSecret);
		
		twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer(consumerToken, consumerTokenSecret);
		twitter.setOAuthAccessToken(at);
		
		TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
		twitterStream.setOAuthConsumer(consumerToken, consumerTokenSecret);
		twitterStream.setOAuthAccessToken(at);
		
        MyUserStreamListener listener = new MyUserStreamListener();
        listener.twitter = twitter;
        twitterStream.addListener(listener);
        
        FilterQuery filterQuery = new FilterQuery();
        filterQuery.track(new String[] {"mod"});
        
        twitterStream.filter(filterQuery);
	}
}
