
import org.junit.Test;

public class OrderableFeedTest {
	BackgroundImage bimage1 = new BackgroundImage("filename","Untitled","a background image"); 
	BackgroundImage bimage2 = new BackgroundImage("filename","Meme","another background image");
	BackgroundImage bimage3 = new BackgroundImage("filename","Meme","an image");
	
	
	
	User user1 = new User("Carlos");
	User user2 = new User("John");
	User user3 = new User("Kyle");
	User user4 = new User("Tom");
	
	Meme meme = new Meme(bimage1, "hahahahaha", user1);
	Meme meme2 = new Meme(bimage2, "when you sit", user1);
	Meme meme3 = new Meme(bimage1, "lmao", user1);
	Meme meme4 = new Meme(bimage2, "lol", user1);
	Meme meme5 = new Meme(bimage1, "when meme", user2);
	Meme meme6 = new Meme(bimage2, "lmao", user2);
	
	Rating rating1 = new Rating(new User("Carlos"), 1);
	Rating rating2 = new Rating(new User("Carlos"), -1);
	
	Feed feed = new Feed();
	Feed feed1 = new Feed();
	Feed feed2 = new Feed();
	
	

	@Test
	public void sortByCaptionTest() {
		
		OrderableFeed test1 = new OrderableFeed();
		test1.setMemes(feed.getMemes());
		
		test1.sortByCaption();
		
		OrderableFeed test2 = new OrderableFeed();
		
		System.out.println(test2.getMemes());
		test2.sortByCaption();
		
	}
	@Test
	public void sortByRatingTest() {
		OrderableFeed test1 = new OrderableFeed();
		
		
		
		test1.sortByCreator();
		System.out.println(test1.getMemes());
		
		OrderableFeed test2 = new OrderableFeed();
	
		
		test2.sortByCreator();
		System.out.println(test2.getMemes());
		
	}

	@Test
	public void sortByCreatorTest() {
		OrderableFeed test1 = new OrderableFeed();
		
		System.out.println(test1.getMemes());
		System.out.println();
		OrderableFeed test2 = new OrderableFeed();
		test2.setMemes(feed1.getMemes());
	
		test2.sortByRating();
		System.out.println(test2.getMemes());
	}


}
