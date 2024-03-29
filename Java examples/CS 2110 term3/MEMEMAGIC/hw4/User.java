import java.util.ArrayList;

public class User {
	private String userName;
	private ArrayList<Meme> memesCreated;
	private ArrayList<Meme> memesViewed;
	
	public User(String username) {
		this.userName = username;
		memesCreated = new ArrayList<Meme>();
		memesViewed = new ArrayList<Meme>();
	} 
	
	public User() {
		userName = "";
		memesCreated = new ArrayList<Meme>();
		memesViewed = new ArrayList<Meme>();
	}
	
	public void rateMeme ( Meme meme,int rating){
		
		meme.addRating(new Rating(this,rating));
		memesViewed.add(meme);
		
	
	}
	public Meme createMeme (BackgroundImage img,String caption){ 
		
		Meme newMemeCreated = new Meme(img,this,caption);
		memesCreated.add(newMemeCreated);
	
		return newMemeCreated;
	}
	
	
	
	
	
	
	public boolean deleteMeme (Meme meme){
		for(int i =0; i < memesCreated.size(); i++) {
			if(memesCreated.get(i).equals(meme)&&!memesCreated.get(i).getShared()) {
				memesCreated.remove(i);
				return true;
			}
		}
	
		
		return false;
	}
	
	public void shareMeme (Meme meme, Feed feed){
		meme.setShared(true);
		feed.getMemes().add(meme);
		
	}
	public boolean rateNextMemeFromFeed (Feed feed, int ratingScore){
		Meme meme = feed.getNewMeme(this);
		if(feed.getNewMeme(this) == null) {   	
			return false;
		}
		else
			//memesViewed.add(meme);
			rateMeme(meme,ratingScore);
			return true;
		
	}
	public double calculateReputation (){
		double sumofmemeratings = 0.0;
		double noofmemes = 0.0;
		
		
		for(Meme i: memesCreated) {
			if(i!= null) {
				if(i.getCreator().equals(this)) {
				noofmemes ++;
				sumofmemeratings += i.calculateOverallRating();
				
				}
			}
		}
		if(noofmemes ==0||sumofmemeratings ==0) {
			return 0.0;
		}
		return sumofmemeratings/noofmemes;
	}
	
	@Override
	public String toString(){
		
		return userName+" has rated ("+this.memesViewed.size()+") memes, "+"("+this.calculateReputation()+")";
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof User) {
			return userName.equals(((User) other).getUserName());
		}
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