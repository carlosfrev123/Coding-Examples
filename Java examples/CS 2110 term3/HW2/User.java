import java.util.ArrayList;

public class User {
	private String userName;
	private ArrayList<Meme> memesCreated;
	private ArrayList<Meme> memesViewed;
	public void rateMeme ( Meme meme,int rating)
	{
		
	}
	public Meme createMeme (BackgroundImage img,String caption)
	{ 
		return new Meme();
	}
	public boolean deleteMeme (Meme meme)
	{
		return false;
	}
	public void shareMeme (Meme meme, Feed feed)
	{
		
	}
	public void rateNextMemeFromFeed (Feed feed, int ratingScore)
	{
		
	}
	public double calculateReputation ()
	{
		return 0.0;
	}
	@Override
	public String toString()
	{
		return "";
	}
	@Override
	public boolean equals(Object other) {
		
		return false;
	}
	
	
	
	
	
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
} 