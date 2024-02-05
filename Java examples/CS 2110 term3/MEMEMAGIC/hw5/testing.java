
import java.util.Collections;


public class testing {

	public static void main(String[] args) {
		BackgroundImage bimage1 = new BackgroundImage("filename","Untitled","a background image"); 
		BackgroundImage bimage2 = new BackgroundImage("filename","Meme","another background image");
		BackgroundImage bimage3 = new BackgroundImage("filename","Meme","an image");
		
		
		
		User user1 = new User("Carlos");
		User user2 = new User("John");
		User user3 = new User("Kyle");
		
		
		Meme meme = new Meme(bimage1, "hahahahaha", user1);
		Meme meme2 = new Meme(bimage2, "when you sit", user1);
		Meme meme3 = new Meme(bimage1, "lmao", user1);
		Meme meme4 = new Meme(bimage2, "lol", user1);
		Meme meme5 = new Meme(bimage1, "when meme", user2);
		Meme meme6 = new Meme(bimage2, "lmao", user2);
			
		Rating rating1 = new Rating(new User("Carlos"), 1);
		Rating rating2 = new Rating(new User("Carlos"), -1);
		// TODO Auto-generated method stub

		
		System.out.println(bimage1.toString());
		System.out.println(bimage2.toString());
		System.out.println(meme.toString());
		System.out.println(meme2.toString());
		System.out.println(rating1.toString());
		System.out.println(rating2.toString());
		
		
		meme.addRating(rating1);
		meme2.addRating(rating2);
		System.out.println(meme.calculateOverallRating());
		System.out.println(meme2.calculateOverallRating());
		
		System.out.println(meme.setCaptionVerticalAlign("top"));
		System.out.println(meme2.setCaptionVerticalAlign("blah"));
		
		System.out.println(rating1.setScore(1));
		System.out.println(rating2.setScore(99));
		
		user1.createMeme(bimage1,"this is a meme" );
		user1.createMeme(bimage2, "lmaooooo");
		user1.createMeme(bimage1, "lol");
		user3.createMeme(bimage2,"meme haha" );

		Feed feed = new Feed();
		Feed feed1 = new Feed();
		user1.shareMeme(meme, feed);
		user1.shareMeme(meme2, feed);
		user2.shareMeme(meme3, feed);
		user1.shareMeme(meme4, feed1);
		user2.shareMeme(meme5, feed1);
		user2.shareMeme(meme6, feed1);
		System.out.println(feed.toString());
		System.out.println(feed1.toString());
		
		user1.rateMeme(meme, 1);
		user1.rateMeme(meme2, 1);
		
		System.out.println(user2.rateNextMemeFromFeed(feed, 1));
		System.out.println(user2.rateNextMemeFromFeed(feed, -1));
		System.out.println(user2.rateNextMemeFromFeed(feed1, 1));
		System.out.println(user2.rateNextMemeFromFeed(feed1, 0));
		//-------------------------------------------------------------
		System.out.println("---------------------------------------------");
		
		System.out.println(user1.toString());
		System.out.println(user2.toString());
		//-------------------------------------------------------------
		System.out.println("--------BackgroundImage Meme and Users compareTo methods---------------------------------------------");
		
		System.out.println(bimage1.compareTo(bimage2));
		System.out.println(bimage1.compareTo(bimage3));
		System.out.println(bimage3.compareTo(bimage2));
		System.out.println();
		System.out.println(meme.compareTo(meme2));
		System.out.println(meme4.compareTo(meme5));
		System.out.println(meme3.compareTo(meme6));
		
		System.out.println();
		System.out.println(Double.compare(1,2));
		System.out.println(Boolean.compare(true, false));
		System.out.println();
		System.out.println(user1.compareTo(user2));
		System.out.println(user1.compareTo(user3));
		
		//------------------------------------------------------------
		System.out.println("----CompareMemeByRating and CompareMemeByCreators compare methods------------------------------------------");
		
		System.out.println(feed.getMemes());
		Collections.sort(feed.getMemes());
		System.out.println(feed.getMemes());
		Collections.sort(feed.getMemes(), new CompareMemeByRating());
		System.out.println(feed.getMemes());
		Collections.sort(feed.getMemes(), new CompareMemeByCreator());
		System.out.println(feed.getMemes());
		System.out.println();
		System.out.println(feed1.getMemes());
		Collections.sort(feed1.getMemes());
		System.out.println(feed1.getMemes());
		Collections.sort(feed1.getMemes(), new CompareMemeByRating());
		System.out.println(feed1.getMemes());
		Collections.sort(feed1.getMemes(), new CompareMemeByCreator());
		System.out.println(feed1.getMemes());
		
		//-------------------------------------------------------------
		System.out.println("-----OrderableFeeds three sort methods test----------------------------------------");
		
		OrderableFeed test1 = new OrderableFeed();
		test1.setMemes(feed.getMemes());
		System.out.println(test1.getMemes());
		test1.sortByCaption();
		System.out.println(test1.getMemes());
		test1.sortByCreator();
		System.out.println(test1.getMemes());
		test1.sortByRating();
		System.out.println(test1.getMemes());
		System.out.println();
		OrderableFeed test2 = new OrderableFeed();
		test2.setMemes(feed1.getMemes());
		System.out.println(test2.getMemes());
		test2.sortByCaption();
		System.out.println(test2.getMemes());
		test2.sortByCreator();
		System.out.println(test2.getMemes());
		test2.sortByRating();
		System.out.println(test2.getMemes());
		
		
		//-------------------------------------------------------------
		System.out.println("--- getNewMeme test------------------------------------------");
		
		System.out.println(test1.getNewMeme(user1));
		System.out.println(test1.getNewMeme(user2));
		
		//---------------------------------------------------------------------
	
		
		
		

		
		
	}

}
