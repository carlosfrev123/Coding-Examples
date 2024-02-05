import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FeedTest {
	
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
	
	

	
	
	
	ArrayList<Meme> m = new ArrayList<>();
	ArrayList<Meme> memes = new ArrayList<>();
	
	
	

	@Test
	public void getNewMemeTest() {
		User tommy = new User("Tommy");
		User bob = new User("bob");
		Meme tommymeme = tommy.createMeme(bimage1, "caption");
		tommy.shareMeme(tommymeme, feed);
		
		assertEquals(null, feed1.getNewMeme(bob));
		assertNotNull(feed.getNewMeme(bob));
		assertEquals(null, feed.getNewMeme(tommy));
	
	}
	@Test
	public void toStringTest() {
		User tommy = new User("Tommy");
		
		Meme tommymeme = tommy.createMeme(bimage1, "caption");
		tommy.shareMeme(tommymeme, feed);
		
		assertEquals("", feed1.toString());
		assertNotNull(feed.toString());
	
	}
	@Test
	public void setMemesTest() {
		memes.add(meme2);
		memes.add(meme3);
		feed2.setMemes(memes);
	
	}

}
