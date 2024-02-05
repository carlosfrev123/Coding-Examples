import java.util.Collections;

public class OrderableFeed extends Feed {

	public void sortByCaption() {
		Collections.sort(memes);
	
	}
	
	public void sortByRating() {
		Collections.sort(memes, new CompareMemeByRating());
	}
	
	
	public void sortByCreator() {
		Collections.sort(memes, new CompareMemeByCreator());
	}
}

