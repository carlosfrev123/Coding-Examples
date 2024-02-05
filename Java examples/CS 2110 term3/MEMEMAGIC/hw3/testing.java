
public class testing {

	public static void main(String[] args) {
		BackgroundImage bimage1 = new BackgroundImage("filename","Untitled","a background image"); 
		BackgroundImage bimage2 = new BackgroundImage("anotherfile","Meme","another background image");
		
		
		
		User user1 = new User("Carlos");
		User user2 = new User("John");
		
		
		Meme meme = new Meme(bimage1, new User("Carlos"), "hahahahaha");
		Meme meme2 = new Meme(bimage2, new User("Carlos"), "when you sit");
			
		Rating rating1 = new Rating(new User("Carlos"), 1);
		Rating rating2 = new Rating(new User("Carlos"), 1);
		// TODO Auto-generated method stub

		
		System.out.println(bimage1.toString());
		System.out.println(bimage2.toString());
		System.out.println(meme.toString());
		System.out.println(meme2.toString());
		System.out.println(rating1.toString());
		System.out.println(rating2.toString());
		
		
		meme.addRating(rating1);
		meme2.addRating(rating2);
		System.out.println(meme.calculateOverallRating());
		System.out.println(meme2.calculateOverallRating());
		
		System.out.println(meme.setCaptionVerticalAlign("top"));
		System.out.println(meme2.setCaptionVerticalAlign("blah"));
		
		System.out.println(rating1.setScore(1));
		System.out.println(rating2.setScore(99));
		
		

		Feed feed = new Feed();
		
		
		
		user1.rateMeme(meme, 1);
		user1.rateMeme(meme2, 1);
		
		
		System.out.println(user1.toString());
		System.out.println(user2.toString());
		System.out.println(user1.equals(user2));
		
		System.out.println(feed.toString());
		
		Meme meem = feed.getNewMeme(user1);
		if(meem == null) {
			System.out.println("meme not found");
		}
		else
		System.out.println(meem.toString());
		//System.out.println(feed.getNewMeme(user1).toString());
		//System.out.println(feed.getNewMeme(user2).toString());
		
		
		
		System.out.println(user1.rateNextMemeFromFeed(feed, 1));
		System.out.println(user2.rateNextMemeFromFeed(feed, 0));
		
		user1.createMeme(bimage1,"this is a meme" );
		user2.createMeme(bimage2, null);
		
		user1.deleteMeme(meme);
		//user2.deleteMeme(meme2);
		
		user1.shareMeme(meme2, feed);
		
		System.out.println(user1.calculateReputation());
		
		
		
		
		
	}

}
