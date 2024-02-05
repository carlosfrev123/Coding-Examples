import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UserTest {
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
	public void overloadedConstructorTest() {
		User u = new User("myUserName");
		assertEquals("The userName returned did not match the one provided to the constructor", "myUserName", u.getUserName());
		assertNotNull("memesViewed was not instantiated", u.getMemesViewed());
		assertNotNull("memesCreated was not instantiated", u.getMemesCreated());
	}
	@Test
	public void notOverloadedConstructorTest() {
		User u = new User();
		assertEquals("The userName returned did not match the one provided to the constructor", "", u.getUserName());
		assertNotNull("memesViewed was not instantiated", u.getMemesViewed());
		assertNotNull("memesCreated was not instantiated", u.getMemesCreated());
	}
	@Test
	public void createMemeTest() {
		
		BackgroundImage bimage1 = new BackgroundImage("one","two","three");
		String caption1 = "caption";
		User user1 = new User("John");
		Meme m1 = user1.createMeme(bimage1, caption1);
		
	    assertTrue(user1.getMemesCreated().contains(m1));
	    assertNotNull(m1);
		
	}
	@Test
	public void compareToTest() {
		
		User user1 = new User("John");
		User user2 = new User("Carlos");
		User user3 = new User("Carlos");
		int val = user2.compareTo(user1);
		int val1 = user3.compareTo(user2);
		assertEquals(-7,val);
		assertEquals(0,val1);
		
		
	}
	@Test
	public void rateMemeTest() {
		BackgroundImage b = new BackgroundImage("imagefilename", "title", "description");
		User user1 = new User("John");
		User user2 = new User("Tom");
		Meme m = new Meme(b, "caption", user2 );
		user1.rateMeme(m, 0);
		assertEquals(1,user1.getMemesViewed().size());
		assertEquals(0.0,m.calculateOverallRating(), .01);
	
	}
	@Test
	public void shareMemeTest() {
		Feed feed1 = new Feed();
		BackgroundImage b = new BackgroundImage("imagefilename", "title", "description");
	
		User user2 = new User("Tom");
		Meme m = new Meme(b, "caption", user2 );
		user2.shareMeme(m, feed1);
		assertTrue(m.getShared());
		assertEquals(1,feed1.getMemes().size());
	}
	@Test
	public void rateNextMemeFromFeedTest() {
		Feed feed1 = new Feed();
		Feed feed2 = new Feed();
		BackgroundImage b = new BackgroundImage("imagefilename", "title", "description");
		User user1 = new User("John");
		User user2 = new User("Tom");
		Meme m1 = new Meme(b, "caption", user2 );
		Meme m2 = new Meme(b, "caption", user2 );
		user2.shareMeme(m1, feed1);
		user2.shareMeme(m2, feed1);
		assertFalse(user1.rateNextMemeFromFeed(feed2, 1));
		assertTrue(user1.rateNextMemeFromFeed(feed1, 1));
	
	}
	@Test
	public void calculateReputationTest() {
		Feed feed1 = new Feed();
		Feed feed2 = new Feed();
		BackgroundImage b = new BackgroundImage("imagefilename", "title", "description");
		User user1 = new User("John");
		User user2 = new User("Tom");
		
		
		user2.shareMeme(user2.createMeme(b, "cap"), feed1);
		user2.shareMeme(user2.createMeme(b, "caption"), feed1);
		user1.rateNextMemeFromFeed(feed1, 1);
		user1.rateNextMemeFromFeed(feed1, 1);
		user1.rateNextMemeFromFeed(feed2, 1);
		assertEquals(1.0, user2.calculateReputation(), .09);
		assertEquals(0.0, user1.calculateReputation(), .09);
	
	}
	@Test
	public void toStringTest() {
		Feed feed1 = new Feed();
		Feed feed2 = new Feed();
		BackgroundImage b = new BackgroundImage("imagefilename", "title", "description");
		User user1 = new User("John");
		User user2 = new User("Tom");
		
		
		user2.shareMeme(user2.createMeme(b, "cap"), feed1);
		user2.shareMeme(user2.createMeme(b, "caption"), feed1);
		user1.rateNextMemeFromFeed(feed1, 1);
		user1.rateNextMemeFromFeed(feed1, 1);
		user1.rateNextMemeFromFeed(feed2, 1);
		
		assertEquals("John has rated (2) memes, (0.0)", user1.toString());
	
	}
	@Test
	public void equalsTest() {
	
		
		User user1 = new User("John");
		User user2 = new User("Tom");
		User user3 = new User("John");
		BackgroundImage b = new BackgroundImage("imagefilename", "title", "description");
	
		assertTrue(user1.equals(user3));
		assertFalse(user1.equals(user2));
		assertFalse(user1.equals(b));
	
	}
	@Test
	public void setUserNameTest() {
		User Carlos = new User();
		Carlos.setUserName("Carlos");
		assertEquals("Carlos", Carlos.getUserName() );

	}
	@Test
	public void setandgetMemesCreatedTest() {
		ArrayList<Meme> memes = new ArrayList<>();
		memes.add(meme2);
		memes.add(meme3);
		
		User Carlos = new User("Carlos");
		Carlos.setMemesCreated(memes);
		assertNotNull(Carlos.getMemesCreated());
	}
	@Test
	public void setMemesViewedTest() {
		ArrayList<Meme> memes = new ArrayList<>();
		memes.add(meme2);
		memes.add(meme3);
		
		User Carlos = new User("Carlos");
		Carlos.setMemesViewed(memes);
		assertNotNull(Carlos.getMemesViewed());
	}


	
	@Test
	public void deleteMemeTest() {
		//Meme ( BackgroundImage backgroundImage, String caption, User creator )
		//BackgroundImage( String imageFileName, String title, String description)
		BackgroundImage b = new BackgroundImage("imagefilename", "title", "description");
		User u = new User("myUserName");
		Meme m = new Meme(b, "caption", u );
		Meme m1 = u.createMeme(b, "null");
		assertFalse(u.deleteMeme(m));
		assertTrue(u.deleteMeme(m1));
		
	}
}
  