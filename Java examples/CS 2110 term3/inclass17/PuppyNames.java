package inclass17;

import java.util.HashSet;

public class PuppyNames {

		// use this method header:
		public static HashSet<String> names(HashSet<String> cards, HashSet<String> topNames) {
		// complete this!
			HashSet<String> namesToAdd = new HashSet<String>();
			
			namesToAdd.addAll(topNames);
				
			for(String i: cards) {
				if(topNames.contains(i));
				namesToAdd.remove(i);
			}
		
			return namesToAdd;
		}
		
		public static void main(String[] args) {
			HashSet<String> topNames = new HashSet<String>();
			HashSet<String> cards = new HashSet<String>();
			topNames.add("Alex");
			topNames.add("Carlos");
			topNames.add("Neil");
			topNames.add("Ganesh");
			topNames.add("Snowball");
			// ------------------cards -----------------
			cards.add("Snowball");
			cards.add("Max");
			cards.add("Liz");
			cards.add("Tom");
			cards.add("Carlos");
			System.out.println(names(cards, topNames));
			System.out.println("names should be: Alex, Neil, Ganesh (no particular order)");
			
			
			
			
		}
}

