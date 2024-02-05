import static org.junit.Assert.*;

import org.junit.Test;

public class MemeTest {
	BackgroundImage bimage1 = new BackgroundImage("filename","Untitled","a background image"); 
	BackgroundImage bimage2 = new BackgroundImage("filename","Meme","another background image");
	BackgroundImage bimage3 = new BackgroundImage("filename","Meme","an image");
	
	
	
	User user1 = new User("Carlos");
	User user2 = new User("John");
	User user3 = new User("Kyle");
	
	
	Meme meme = new Meme(bimage1, "ha", user1);
	Meme meme1 = new Meme(bimage1, "ha", user1);
	Meme meme2 = new Meme(bimage2, "ha", user1);
	Meme meme3 = new Meme(bimage1, "lmao", user1);
	Meme meme4 = new Meme(bimage2, "lol", user2);
	Meme meme5 = new Meme(bimage1, "when meme", user2);
	Meme meme6 = new Meme(bimage2, "lol", user2);
		
	Rating rating1 = new Rating(new User("Carlos"), 1);
	Rating rating2 = new Rating(new User("Carlos"), -1);
	Rating rating3 = new Rating(user3, 1);
	
	
	
	@Test
	public void compareToTest() {
		
		user1.rateMeme(meme4, 1);
		
		assertEquals(8,meme.compareTo(meme2));
		assertEquals(-2,meme3.compareTo(meme6));
		assertEquals(0,meme1.compareTo(meme));
		assertEquals(-1,meme4.compareTo(meme6));
	}
	@Test
	public void addRatingTest() {
		
		meme.addRating(rating1);
		meme.addRating(rating2);
		meme.addRating(rating2);
		meme.addRating(rating2);
		meme.addRating(rating2);
		meme.addRating(rating2);
		meme.addRating(rating2);
		meme.addRating(rating2);
		meme.addRating(rating2);
		meme.addRating(rating2);
		
		assertTrue(meme.addRating(rating3));
	}
	@Test
	public void equalsTest() {
		
		User userJohn = new User("John");
		
		
		assertTrue(meme.equals(meme1));
		assertFalse(meme.equals(meme4));
		assertFalse(meme.equals(userJohn));
	
	}
	

	
	
	@Test
	public void toStringTest() {
		meme.addRating(rating1);
		meme.addRating(rating2);
		assertEquals("Untitled <a background image> 'ha' 0.0 [+1: 1, -1: 1] - created by Carlos",meme.toString());
	}

	@Test
	public void overLoadedConTest() {
		BackgroundImage b = new BackgroundImage("imagefilename","title","description");
		Meme m1 = new Meme(b,"caption",new User("Tim"));
		
		assertEquals(b, m1.getBackgroundImage());
		assertNotNull(meme.getRatings());
		assertNotNull(meme.getCaptionVerticalAlign());
	}
	
	@Test
	public void notOverLoadedConTest() {
		Meme m1 = new Meme();
		assertEquals("",m1.getCaption());
		assertEquals("",m1.getCaptionVerticalAlign());
	}
	@Test
	public void setCaptionVerticalAllignTest() {
		Meme m1 = new Meme();
		assertTrue(m1.setCaptionVerticalAlign("bottom"));
		assertFalse(m1.setCaptionVerticalAlign(":D"));
		
	}
	@Test
	public void setandgetCreatorTest() {
		Meme m1 = new Meme();
		m1.setCreator(user1);
		assertNotNull(m1.getCreator());
		
	}
	@Test
	public void setBackgroundImageTest() {
		Meme m1 = new Meme();
		m1.setBackgroundImage(bimage1);
		assertNotNull(m1.getBackgroundImage());
		
	}
	@Test
	public void setRatingsTest() {
		Meme m1 = new Meme();
		m1.setRatings(null);
		assertNull(m1.getRatings());
		
	}
	@Test
	public void setCaptionTest() {
		Meme m1 = new Meme();
		m1.setCaption("Caption");
		assertEquals("Caption", m1.getCaption());
		
	}
	@Test
	public void setSharedTest() {
		Meme m1 = new Meme();
		Meme m2 = new Meme();
		m1.setShared(true);
		m2.setShared(false);
		assertTrue(m1.getShared());
		assertFalse(m2.getShared());
		
	}


}
