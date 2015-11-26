import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;


public class Main {
	
	public static void main (String [ ] args) throws TwitterException {
		 
        System.out.println("Hello WOrd");
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("");
        cb.setOAuthConsumerSecret("");
        cb.setOAuthAccessToken("");
        cb.setOAuthAccessTokenSecret("");

        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        StatusListener listener = new StatusListener() {

            public void onStatus(Status status) {
                //System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            	//System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            	System.out.println("Esto deberia ser la fecha :p " + status.getCreatedAt());
            }

            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            public void onException(Exception ex) {
                ex.printStackTrace();
            }

			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}
        };

        FilterQuery fq = new FilterQuery();
        String keywords[] = {"France", "Germany"};

        fq.track(keywords);

        twitterStream.addListener(listener);
        twitterStream.filter(fq); 
        
	}

}
