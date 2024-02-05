import static org.junit.Assert.*;

import org.junit.Test;

public class BackgroundImageTest {
	BackgroundImage bimage1 = new BackgroundImage("file","Untitled","a background image");
	BackgroundImage bimage2 = new BackgroundImage("filename","Meme","another background image");
	BackgroundImage bimage3 = new BackgroundImage("anotherfilename","Meme","an image");
	BackgroundImage bimage4 = new BackgroundImage("file","Untitled","a background image");
	BackgroundImage bimage5 = new BackgroundImage("anotherfilename","BetterMeme","an image");
	@Test
	public void equalsTest() {
		User u = new User("tom");
		assertTrue(bimage1.equals(bimage4));
		assertFalse(bimage2.equals(bimage3));
		assertFalse(bimage2.equals(bimage1));
		assertFalse(bimage3.equals(bimage1));
		assertFalse(bimage2.equals(u));
		
		
	}
	@Test
	public void compareToTest() {
		
		assertEquals(0,bimage1.compareTo(bimage4));
		assertEquals(-4, bimage1.compareTo(bimage2));
		assertEquals(11, bimage3.compareTo(bimage5));

	}
	@Test
	public void toStringTest() {
		
		assertEquals("Untitled <a background image>",bimage1.toString());

	}
	@Test
	public void constructorTest() {
		BackgroundImage b = new BackgroundImage();
		assertEquals("",b.getImageFileName());
		assertEquals("",b.getTitle());
		assertEquals("",b.getDescription());

	}
	@Test
	public void setImageFileNameTest() {
		BackgroundImage b = new BackgroundImage();
		b.setImageFileName("filename");
		assertEquals("filename",b.getImageFileName());

	}
	@Test
	public void setDescriptionTest() {
		BackgroundImage b = new BackgroundImage();
		b.setDescription("filename");
		assertEquals("filename",b.getDescription());

	}
	@Test
	public void setTitleTest() {
		BackgroundImage b = new BackgroundImage();
		b.setTitle("title");
		assertEquals("title",b.getTitle());

	}



}
