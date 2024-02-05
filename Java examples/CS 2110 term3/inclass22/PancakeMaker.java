import java.util.ArrayList;

public class PancakeMaker {
	final private String[] requiredIngredients = { "flour","salt","soda","powder","buttermilk","egg" };
	
	public ArrayList<String> determineWholeFoodsOrder(String[] ingredientsIHave) {
		ArrayList<String> ingredientsINeed = new ArrayList<>();
		
		for (int i = 0; i< this.requiredIngredients.length; i++) {
			for (int p = 0; p<ingredientsIHave.length;p++) {
				if (!(ingredientsIHave[p].equals(requiredIngredients[i]))) {
					ingredientsINeed.add(requiredIngredients[i]);
				}
			}
		}
		
		return ingredientsINeed;
	}
}
