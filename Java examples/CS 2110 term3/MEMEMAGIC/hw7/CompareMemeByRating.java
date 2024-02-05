import java.util.Comparator;

public class CompareMemeByRating implements Comparator<Meme>{
	
	public int compare(Meme a, Meme b) {
		int compare1 = -Double.compare(a.calculateOverallRating(), b.calculateOverallRating()); //decending
		if( compare1 != 0 ) {
			return compare1;
		}
		int compare2 = a.getCaption().compareTo(b.getCaption());
		if(compare2 !=0) {
			return compare2;
		}
		int compare3 = 	a.getBackgroundImage().compareTo(b.getBackgroundImage());
		if(compare3 != 0){
			return compare3;
		}
		int compare4 = a.getCreator().compareTo(b.getCreator());
			return compare4;
		}
		
			
	}

