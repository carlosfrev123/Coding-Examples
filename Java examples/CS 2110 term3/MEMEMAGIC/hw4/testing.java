
public class testing {

	public static void main(String[] args) {
		BackgroundImage bimage1 = new BackgroundImage("filename","Untitled","a background image"); 
		BackgroundImage bimage2 = new BackgroundImage("anotherfile","Meme","another background image");
		
		User user1 = new User("Carlos");
		User user2 = new User("John");
		
		
		Meme meme1 = new Meme(bimage1, user2,"hahahahaha");
		Meme meme2 = new Meme(bimage2, user2,"when you sit");
		Meme meme3 = new Meme(bimage2, user2,"when");
			
		//Rating rating1 = new Rating(user1, 1);
		//Rating rating2 = new Rating(user1, 1);
		//Rating rating3 = new Rating(user1, 0);
		
		// TODO Auto-generated method stub

		//meme.addRating(rating1);
		//meme2.addRating(rating2);
		
		System.out.println(meme1.calculateOverallRating());
		System.out.println(meme2.calculateOverallRating());
		System.out.println(meme3.calculateOverallRating());
		

		Feed feed = new Feed();
		user2.shareMeme(meme3, feed);
		user2.shareMeme(meme2, feed);
		user2.shareMeme(meme1, feed);
		System.out.println(feed.toString());

		
		System.out.println(user1.rateNextMemeFromFeed(feed, 1));
		System.out.println(user1.rateNextMemeFromFeed(feed, 1));
		user1.rateMeme(meme3, 1);
		user1.rateMeme(meme3, 1);
		user1.rateMeme(meme3, 1);
		System.out.println(user1.rateNextMemeFromFeed(feed, 1));
		
		
		//Meme meme1 = feed.getNewMeme(user1);
	
		//System.out.println(meme1.toString());
		//System.out.println(feed.getNewMeme(user1).toString());
		//System.out.println(feed.getNewMeme(user2).toString());
		
		
		//user1.createMeme(bimage1,"this is a meme" );
		//user2.createMeme(bimage2, null);
		
	
		//user2.deleteMeme(meme2);
		
		System.out.println(user1.toString());
		System.out.println(user2.toString());
	
		
	
		
		
		
		
	}

}
