import java.util.ArrayList;

public class User {

	private String userName = "user";
	private ArrayList<Meme> memesCreated;
	private ArrayList<Meme> memesViewed;
	
	
/*--------------------------------------------------------------------------------------------------------------------------------------*/
//Constructors
	
	
	
	
/*--------------------------------------------------------------------------------------------------------------------------------------*/
//Methods
	
	public void rateMeme(Meme meme, int rating) {
		
	}
	
	public Meme createMeme(BackgroundImage bg, String caption) {
		Meme m = new Meme();
		return m;
	}
	
	public boolean deleteMeme(Meme m) {
		return true;
	}
	
	public void shareMeme(Meme m, Feed f) {
	}
	
	public void rateNextMemeFromFeed(Feed f, int ratingScore) {
		
	}
	
	public double calculateReputation() {
		return 0.0;
	}
	
	
/*--------------------------------------------------------------------------------------------------------------------------------------*/
//Getters and Setters
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ArrayList<Meme> getMemesCreated() {
		return memesCreated;
	}

	public void setMemesCreated(ArrayList<Meme> memesCreated) {
		this.memesCreated = memesCreated;
	}

	public ArrayList<Meme> getMemesViewed() {
		return memesViewed;
	}

	public void setMemesViewed(ArrayList<Meme> memesViewed) {
		this.memesViewed = memesViewed;
	}

	
/*--------------------------------------------------------------------------------------------------------------------------------------*/
//Override
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", memesCreated=" + memesCreated + ", memesViewed=" + memesViewed + "]";
	}
	

/*--------------------------------------------------------------------------------------------------------------------------------------*/
//testing
	
	
		
	
	
	

	
}
