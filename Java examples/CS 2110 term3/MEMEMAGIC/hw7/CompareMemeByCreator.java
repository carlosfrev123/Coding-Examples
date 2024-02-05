import java.util.Comparator;

public class CompareMemeByCreator implements Comparator<Meme>{
	
	public int compare(Meme a, Meme b) {
		int compare1 = a.getCreator().compareTo(b.getCreator());
		if(compare1 != 0) {
			return compare1;
		}
		int compare2 = -Double.compare(a.calculateOverallRating(),b.calculateOverallRating());
		if(compare2 != 0) {
			return compare2;
		}
		int compare3 = a.getCaption().compareTo(b.getCaption());
		if(compare3 != 0) {
			return compare3;
		}
		int compare4 = a.getBackgroundImage().compareTo(b.getBackgroundImage());
		if(compare4 != 0){
			return compare4;
		}
		int compare5 = -Boolean.compare(a.getShared(), b.getShared());
		return compare5;
	}
	
	
}
