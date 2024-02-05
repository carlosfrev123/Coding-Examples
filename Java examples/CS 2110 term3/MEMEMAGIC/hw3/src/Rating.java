
public class Rating {
	private int score;
	private User user;
	
	public Rating(User user, int score) {
		this.user = user;
		if(score == -1 || score == 0 || score == 1) {
			this.score = score;		
		}
		else
			this.score  = 0;
		
	}
	
	
	public Rating() {
		user = new User();
		score = 0;
		
	}
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
	public boolean equals(Object other) {
		if(other instanceof Rating) {
			Rating r = (Rating)other;
			if(score == r.getScore() && user.equals(r.getUser())) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getScore() {
		return score;
	}
	public boolean setScore(int score) {
		if(score == -1 || score == 0 || score == 1) {
			this.score = score;		
			return true;
		}
		return false;
		
		
	}
}
