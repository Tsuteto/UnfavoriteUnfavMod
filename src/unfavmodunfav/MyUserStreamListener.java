package unfavmodunfav;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import twitter4j.DirectMessage;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.UserStreamListener;

public class MyUserStreamListener implements UserStreamListener {
	
	Twitter twitter;
	
	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		
	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		
	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		
	}

	@Override
	public void onStatus(Status stat) {
		if (stat.getSource().contains("あんふぁぼられったーMOD"))
		{
			try {
				twitter.createFavorite(stat.getId());
				Timer timer = new Timer();
				timer.schedule(new UnfavTimer(stat.getId()) {
					
					@Override
					public void run() {
						try {
							twitter.destroyFavorite(id);
						} catch (TwitterException e) {
							e.printStackTrace();
						}
					}
				}, TimeUnit.SECONDS.toMillis(3));
			} catch (TwitterException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void onTrackLimitationNotice(int arg0) {
		
	}

	@Override
	public void onException(Exception arg0) {
		
	}

	
	private abstract class UnfavTimer extends TimerTask
	{
		final long id;
		
		public UnfavTimer(long l)
		{
			this.id = l;
		}
	}


	@Override
	public void onBlock(User arg0, User arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDeletionNotice(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDirectMessage(DirectMessage arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFavorite(User arg0, User arg1, Status arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFollow(User arg0, User arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFriendList(long[] arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUnblock(User arg0, User arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUnfavorite(User arg0, User arg1, Status arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserListCreation(User arg0, UserList arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserListDeletion(User arg0, UserList arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserListMemberAddition(User arg0, User arg1, UserList arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserListMemberDeletion(User arg0, User arg1, UserList arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserListSubscription(User arg0, User arg1, UserList arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserListUnsubscription(User arg0, User arg1, UserList arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserListUpdate(User arg0, UserList arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserProfileUpdate(User arg0) {
		// TODO Auto-generated method stub
		
	}
}
