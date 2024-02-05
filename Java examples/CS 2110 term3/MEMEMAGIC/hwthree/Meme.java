import java.util.Arrays;

public class Meme {

	private User creator;
	private BackgroundImage backgroundImage;
	private Rating[] ratings;
	private String caption;
	private String captionVerticalAlign;
	private boolean shared;

/*--------------------------------------------------------------------------------------------------------------------------------------*/
//Constructor

	// Default
	public Meme() {
		this.backgroundImage = new BackgroundImage();
		this.caption = "caption";
		this.creator = new User();
		this.ratings = new Rating[10];
		this.captionVerticalAlign = "bottom";
	}
	
	// Overloaded Constructor
	public Meme(BackgroundImage backgroundImage, String caption, User creator) {
		this.backgroundImage = backgroundImage;
		this.caption = caption;
		this.creator = creator;
		this.captionVerticalAlign = "bottom";
		this.ratings = new Rating[10];
	}
		
/*-------------------------------------------------------------------------------------------------------------------------------------*/
//Methods
	public boolean addRating(Rating rating) {
		
		if(ratings == null) {
			return false;
		}
		if(rating == null) {
			return false;
		}
		if(ratings[0] == null) {
			ratings[0] = rating;
			return true;
		}
		boolean isFull = true;
		for(int i = 0; i< ratings.length; i++) {
			if(ratings[i] == null) {
				isFull = false;
			}
		}
		if (isFull) {
			for(int i = 0; i < ratings.length - 1; i++) {
				ratings[i] = ratings[i+1];
			}
			ratings[ratings.length -1] = rating;
			return true;
		}
		else {
			int d = 0;
			while (ratings[d] != null) {
				d++;
			}
			ratings[d] = rating;
			return true;
		}
		
//		if (ratings == null || ratings[0] == null) {
//			ratings[0] = rating;
//			return true;
//		}
////		if (ratings[0] == null) {
////			ratings[0] = rating;
////			return true;
////		}
//		for (int i = 0; i < ratings.length; i++) {
//			if (ratings[i] == null) {
//				isFull = false;
//			}
//		}
//		if (isFull == true) {
//			for (int i = 0; i < ratings.length - 1; i++) {
//				ratings[i] = ratings[i + 1];
//			}
//			ratings[9] = rating;
//			return true;
//		} else {
//			int count = 0;
//			while (ratings != null) {
//				count++;
//			}
//			ratings[count] = rating;
//			return true;
//		}
	}

	public double calculateOverallRating() {
		double sum = 0;
		int count = 0;
		if (ratings == null) {
			return sum;
		}

		if (ratings == null || ratings[0] == null) {
			return 0.0;
		}
		for (int i = 0; i < ratings.length; i++) {
			if (ratings[i] == null) {
				return sum;
			}

			sum += ratings[i].getScore();

		}
		return sum;
	}

	// for getting the overall rating
	private int plusCount() {
		if (ratings == null || ratings[0] == null) {
			return 0;
		}
		// local variables
		int count = 0;
		int i = 0;
		//// loop through to find all instances of +1
		while (ratings[i] != null) {
			if (ratings[i].getScore() == 1) {
				count++;
			}
			i++;
		}
		return count;
	}

	private int minusCount() {
		if (ratings == null || ratings[0] == null) {
			return 0;
		}
		// local variables
		int count = 0;
		int i = 0;
		// loop through to find all instances of -1
		while (ratings[i] != null) {
			if (ratings[i].getScore() == -1) {
				count++;
			}
			i++;
		}
		return count;
	}
	
/*---------------------------------------------------------------------------------------------------------------------------------------*/
// Getters and Setters 
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
		if (captionVerticalAlign == null) {
			return false;
		}
		if (captionVerticalAlign.equals("top") || captionVerticalAlign.equals("middle")
				|| captionVerticalAlign.equals("bottom")) {
			this.captionVerticalAlign = captionVerticalAlign;
			return true;
		}
		return false;
	}

	public boolean getShared() {
		return shared;
	}

	public void setShared(boolean shared) {
		this.shared = shared;
	}

	
/*--------------------------------------------------------------------------------------------------------------------------------------*/
// Override methods
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meme other = (Meme) obj;
		if (backgroundImage == null) {
			if (other.backgroundImage != null)
				return false;
		} else if (!backgroundImage.equals(other.backgroundImage))
			return false;
		if (caption == null) {
			if (other.caption != null)
				return false;
		} else if (!caption.equals(other.caption))
			return false;
		if (captionVerticalAlign == null) {
			if (other.captionVerticalAlign != null)
				return false;
		} else if (!captionVerticalAlign.equals(other.captionVerticalAlign))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (!Arrays.equals(ratings, other.ratings))
			return false;
		if (shared != other.shared)
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return backgroundImage + " \'" + caption + "\' " + calculateOverallRating() + " [+1: " + plusCount() + ", -1: "
				+ minusCount() + "]";

	}
	
/*--------------------------------------------------------------------------------------------------------------------------------------*/
// TESTING
	public static void main(String[] args) {
		//Using Constructors
		Meme m1 = new Meme();
		Meme m2 = new Meme(new BackgroundImage(), "caption", new User());
		System.out.println(m1);
		System.out.println(m2);
		//Equals method
		System.out.println(m1.equals(m1));
		System.out.println(m1.equals(m2));
		// Calculate Overall Rating
		System.out.println(m1.calculateOverallRating());
		System.out.println(m2.calculateOverallRating());
		// Adding ratings
		m1.addRating(new Rating(new User(), +1));
		m2.addRating(new Rating(new User(), -1));
		
		System.out.println(m1);
		System.out.println(m2);
		// Vertical Alignment
		m1.setCaptionVerticalAlign("top");
		m2.setCaptionVerticalAlign("below");
		System.out.println(m1.getCaptionVerticalAlign());
		System.out.println(m2.getCaptionVerticalAlign());
		
//		
//		Meme meme = new Meme(new BackgroundImage(), "testing...", new User());
//		System.out.println(meme); // should print title and description
//		Meme defaultMeme = new Meme();
//		System.out.println(meme.equals(meme)); // should be true
//		System.out.println(meme.equals(defaultMeme)); // should be false
//		System.out.println(meme.addRating(new Rating())); // should be
//		System.out.println(meme.calculateOverallRating());
//		// Adding score
//		System.out.println(meme.addRating(new Rating(new User(), -1)));
//		System.out.println(meme.addRating(new Rating(new User(), -1)));
//		System.out.println(meme.addRating(new Rating(new User(), 0)));
//
//		System.out.println(meme.calculateOverallRating());
//		System.out.println(meme.setCaptionVerticalAlign("top")); // should be true
//		System.out.println(meme.getCaptionVerticalAlign());
//		
//		System.out.println(meme.setCaptionVerticalAlign("side")); // should be false

	}

}