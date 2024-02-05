public class Meme {
	private User creator;
	private BackgroundImage backgroundImage;
	private Rating[] ratings;
	private String caption;
	private String captionVerticalAlign;
	private boolean shared;
	
	
	
	public  boolean addRating(Rating rating) {
		
		return false;
	}
	
	public double calculateOverallRating() {
		
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
	
	
	
	
	
	
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public BackgroundImage getBackgroundImage() {
		return backgroundImage;
	}
	public void setBackgroundImage(BackgroundImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	public Rating[] getRatings() {
		return ratings;
	}
	public void setRatings(Rating[] ratings) {
		this.ratings = ratings;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getCaptionVerticalAlign() {
		return captionVerticalAlign;
	}
	public void setCaptionVerticalAlign(String captionVerticalAlign) {
		this.captionVerticalAlign = captionVerticalAlign;
	}
	public boolean getShared() {
		return shared;
	}
	public void setShared(boolean shared) {
		this.shared = shared;
	}
	
}