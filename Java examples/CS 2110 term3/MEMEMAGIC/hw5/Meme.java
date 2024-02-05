

public class Meme implements Comparable<Meme> {
	private User creator;
	private BackgroundImage backgroundImage;
	private Rating[] ratings; //[]
	private String caption;
	private String captionVerticalAlign;
	private boolean shared;
	
	public Meme() {
		this.backgroundImage = new BackgroundImage();
		this.ratings = new Rating[10];
		this.caption = "caption";
		this.captionVerticalAlign = "bottom";
		shared = false;
		this.creator = new User();
				
	}


	
	public Meme ( BackgroundImage backgroundImage, String caption, User creator ){
		this.creator = creator;
		this.backgroundImage = backgroundImage;
		this.caption = caption;
		this.ratings = new Rating[10];
		this.captionVerticalAlign = "bottom";
		this.shared = false;
	}
	
	
	public int compareTo(Meme a){
		int compare1 = this.caption.compareTo(a.getCaption());
		if(compare1 != 0) {
			return compare1;
			
		}
		int compare2 = this.backgroundImage.compareTo(a.getBackgroundImage());
		if(compare2 != 0) {
			return compare2;
		}
		
		int compare3 = -Double.compare(this.calculateOverallRating(),a.calculateOverallRating());
		if(compare3 != 0) {
			return compare3;
		}
		
		int compare4 = -Boolean.compare(this.getShared(),a.getShared());
			return compare4;
		}
					
	
	
	
	
	
	
	public  boolean addRating(Rating rating) {
		for(int i = 0; i < ratings.length; i++ ) {      // this for loop is trying to  add to ratings array
			if( ratings[i] == null) {					// if this fails it will go to if statement below at line 30
				this.ratings[i] = rating;
				return true;
				}
			}
			for(int i =1; i < ratings.length; i++) {
				this.ratings[i- 1] = ratings[i];
			}
			this.ratings[this.ratings.length - 1] = rating;
			return true; 
}
	
	public double calculateOverallRating() {
		 double ratingSum = 0.0;
		
        for(int i = 0; i < ratings.length; i++) {
        	if (this.ratings[i] != null) {
        		ratingSum += this.ratings[i].getScore();
        		
        	}
        }
		
         return ratingSum;
		
	}
	
	//toString() - returns "backgroundImage ‘caption' overallRating [+1: the number of +1
	//ratings, -1: the number of -1 ratings]"
	
	@Override
	public String toString(){
		int numberofplus1ratings = 0;
		int numberofminus1ratings = 0;
		
		for(int i = 0; i < ratings.length; i++) {
        	if (this.ratings[i] != null) {
        		if(ratings[i].getScore()== 1 ) {
        			numberofplus1ratings++;
        			
        		}
        		else if(ratings[i].getScore()== -1 ) {
        			numberofminus1ratings++;
        		}
        	}
		}
		return backgroundImage+(" '"+caption+"' ")+calculateOverallRating()+" [+1: "+numberofplus1ratings+", -1: "+numberofminus1ratings+"] - created by "+ this.getCreator().getUserName();
	}
	
	/*equals(Object) - return true if the parameter is a Meme object and both instances
		match on creator, caption and backgroundImage
		○ Note: since we have not specified the equality of User objects, you may need to
					update your User classes equals() method to use its parents method with the super keyword:
						public boolean equals(Object o) {
							return super.equals(o); */
	@Override
	public boolean equals(Object other) {
		if (other instanceof Meme) {
			Meme otherMeme = (Meme) other;
			if ((this.creator.equals(otherMeme.creator))&&(this.caption.equals(otherMeme.caption))&&(this.backgroundImage.equals(otherMeme.backgroundImage)))
				return true;
		return false;
		
		
		}
		
		
		
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
	public boolean setCaptionVerticalAlign(String captionVerticalAlign) {
		String[] allowedValues = {"top","bottom","middle"};
		this.captionVerticalAlign = captionVerticalAlign;
			for(String i: allowedValues) {
				if(i.equals(captionVerticalAlign)) {
					return true;
				}
			}
		
		return false;
	}
	public boolean getShared() {
		return shared;
	}
	public void setShared(boolean shared) {
		this.shared = shared;
	}


	
	
}