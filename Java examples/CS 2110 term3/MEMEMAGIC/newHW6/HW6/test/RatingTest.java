import static org.junit.Assert.*;

import org.junit.Test;

public class RatingTest {

	@Test
	public void toStringTest() {
		Rating rating1 = new Rating(new User("Huebert"), 1);
		assertEquals("Huebert rated as an upvote", rating1.toString());
		Rating rating2 = new Rating(new User("Huebert"), -1);
		assertEquals("Huebert rated as a downvote", rating2.toString());
		Rating rating3 = new Rating(new User("Huebert"), 0);
		assertEquals("Huebert rated as a pass", rating3.toString());
	}
	@Test
	public void equalsTest() {
		Rating rating1 = new Rating(new User("Huebert"), 1);
		Rating rating2 = new Rating(new User("Huebert"), -1);
		Rating rating3 = new Rating(new User("Huebert"), 1);
		Rating rating4 = new Rating(new User("Hue"), 1);
		int b = 3;
		assertTrue(rating1.equals(rating3));
		assertFalse(rating1.equals(b));
		assertFalse(rating1.equals(rating2));
		assertFalse(rating1.equals(rating4));
	}
	@Test
	public void dconTest() {
		Rating r = new Rating();
		
		assertEquals(new User(),r.getUser());
		assertEquals(0,r.getScore());
	}
	@Test
	public void conTest() {
		Rating r = new Rating(new User("Carlos"), 56);
		Rating r1 = new Rating(new User("Carlos"), 1);
		Rating r2 = new Rating(new User("Carlos"), 0);
		Rating r3 = new Rating(new User("Carlos"), -1);
		assertEquals(0,r.getScore());
		assertEquals(1,r1.getScore());
		assertEquals(0,r2.getScore());
		assertEquals(-1,r3.getScore());
	}
	@Test
	public void setScoreTest() {
		Rating r = new Rating();
		assertTrue(r.setScore(1));
		assertTrue(r.setScore(-1));
		assertTrue(r.setScore(0));
		assertFalse(r.setScore(5));
	}
	@Test
	public void setUserTest() {
		Rating r = new Rating();
		r.setUser(new User("tom"));
		assertEquals("tom", r.getUser().getUserName());
		
	}
	

}
