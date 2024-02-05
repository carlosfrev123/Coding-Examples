public class Rating {

	private int score = 0;
	private User user;
/*--------------------------------------------------------------------------------------------------------------------------------------*/
//Constructors
	

	// default
		public Rating() {
			this.score = 0;
			this.user = new User();
			
		}
	// Overload Constructor
		public Rating(User user, int score) {
			if(score != 1 && score != +1 && score != 0) {
				this.score = score;
			} else {
				this.score = score;
			}
			this.user = user;
			
		}
	
/*--------------------------------------------------------------------------------------------------------------------------------------*/
// Getters and Setters
	public int getScore() {
		return score;
	}
		
	public boolean setScore(int score) {
		if (score != -1 && score != +1 && score!=0) {
			return false;
		} else {
			this.score = score;
			return true;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
/*--------------------------------------------------------------------------------------------------------------------------------------*/
//Override
	@Override
	public String toString() {
		if (score == 1) {
			return "Rating was an upvote";
		} else if (score == -1) {
			return "Rating was a downvote";
		} else {
			return "Rating was a pass";
		}

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rating other = (Rating) obj;
		if (score != other.score)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

/*--------------------------------------------------------------------------------------------------------------------------------------*/
// TESTING
	public static void main(String[] args) {
		//Constructor
		Rating r1 = new Rating();
		Rating r2 = new Rating(new User(), +1);
		//ToString
		System.out.println(r1);
		System.out.println(r2);
		//Equals
		System.out.println(r1.equals(r1));
		System.out.println(r1.equals(r2));
		// Set Score
		System.out.println(r1.setScore(-1));
		System.out.println(r2.setScore(0));
		// Get Score
		System.out.println(r1.getScore());
		System.out.println(r2.getScore());
		
//		
//		Rating defaultRating = new Rating();
//		Rating rating = new Rating(new User(), -1);
//		Rating rating2 = new Rating(new User(), +1);
//		Rating rating3 = new Rating(new User(), 0);
//		System.out.println(rating);
//		System.out.println(rating2);
//		System.out.println(rating3);
//		System.out.println(rating.equals(defaultRating));
//		System.out.println(rating.equals(rating));
//		System.out.println(rating.setScore(-1));
//		System.out.println(rating.setScore(9));
//		System.out.println(rating);

	}

}
