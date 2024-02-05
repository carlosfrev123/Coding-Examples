
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;



public class PancakeMakerTest {

	@Test
	public void determineOrderTest1() {
		PancakeMaker Carlos = new PancakeMaker();
		String[] ingredientsIHave = {"flour", "salt" , "milk"};
		ArrayList<String> testlist1 = new ArrayList<String>();
		testlist1.add("egg");
		testlist1.add("soda");
		testlist1.add("flour");
		testlist1.add("buttermilk");
		
		assertEquals(testlist1, Carlos.determineWholeFoodsOrder(ingredientsIHave));
		
	}

	@Test
	public void determineOrderTest2() {
		PancakeMaker Carlos = new PancakeMaker();
		String[] ingredientsIHave = {};
		ArrayList<String> testlist1 = new ArrayList<String>();
		testlist1.add("egg");
		testlist1.add("soda");
		testlist1.add("flour");
		
		
		assertEquals(testlist1, Carlos.determineWholeFoodsOrder(ingredientsIHave));
		
	
	
}
	@Test
	public void determineOrderTest3() {
		PancakeMaker Carlos = new PancakeMaker();
		String[] ingredientsIHave = {"flour", "salt" , "milk"};
		ArrayList<String> testlist1 = new ArrayList<String>();
	
		assertEquals(testlist1, Carlos.determineWholeFoodsOrder(ingredientsIHave));
	}
}
