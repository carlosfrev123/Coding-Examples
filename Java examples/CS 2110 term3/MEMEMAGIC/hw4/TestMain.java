import java.util.ArrayList;

public class TestMain {

        public static void main(String[] args) {
                
                User user = new User();
                user.setUserName("TestUserName");
                
                BackgroundImage x = new BackgroundImage("TestImage1", "TestTitle1", "TestDescription1");
                BackgroundImage backgroundImage1 = new BackgroundImage("TestImage2", "TestTitle2", "TestDescription2");
                BackgroundImage backgroundImage2 = new BackgroundImage("TestImage3", "TestTitle3", "TestDescription3");
                
                Meme meme = new Meme(x,user, "TestCaption1");
                Meme meme1 = new Meme(backgroundImage1,new User("todd"), "TestCaption2");
                Meme meme2 = new Meme(backgroundImage2,new User("todd"), "TestCaption3");
                
                
                Rating rating1 = new Rating(user, 1);
                boolean isScoredAdded = rating1.setScore(-1);
                System.out.println("isScoredAdded: "+isScoredAdded);            
                boolean isRatingAdded = meme.addRating(rating1);
                System.out.println("isRatingAdded: "+isRatingAdded);
                double overAllRating = meme.calculateOverallRating();
                System.out.println("overAllRating: "+overAllRating);
                boolean isCaptionAligned = meme.setCaptionVerticalAlign("top");
                System.out.println("isCaptionAligned: "+isCaptionAligned);
                
                
                Rating rating2 = new Rating(user, 0);
                isScoredAdded = rating2.setScore(1);
                isRatingAdded = meme1.addRating(rating2);
                overAllRating = meme1.calculateOverallRating();
                
                
                Rating rating3 = new Rating(user, 0);
                isScoredAdded = rating3.setScore(0);    
                isRatingAdded = meme2.addRating(rating3);
                overAllRating = meme2.calculateOverallRating();
                
                Rating rating4 = new Rating(user, 0);
                isScoredAdded = rating4.setScore(1);    
                isRatingAdded = meme.addRating(rating4);
                overAllRating = meme.calculateOverallRating();
                
                Rating rating5 = new Rating(user, 0);
                isScoredAdded = rating5.setScore(1);    
                isRatingAdded = meme.addRating(rating5);
                overAllRating = meme.calculateOverallRating();
                
                Rating rating6 = new Rating(user, 0);
                isScoredAdded = rating6.setScore(-1);   
                isRatingAdded = meme.addRating(rating6);
                overAllRating = meme.calculateOverallRating();
                
                Rating rating7 = new Rating(user, 0);
                isScoredAdded = rating7.setScore(1);    
                isRatingAdded = meme.addRating(rating7);
                overAllRating = meme.calculateOverallRating();
                
                Rating rating8 = new Rating(user, 0);
                isScoredAdded = rating8.setScore(0);    
                isRatingAdded = meme.addRating(rating8);
                overAllRating = meme.calculateOverallRating();
                
                Rating rating9 = new Rating(user, 0);
                isScoredAdded = rating9.setScore(1);    
                isRatingAdded = meme.addRating(rating9);
                overAllRating = meme.calculateOverallRating();
                
                Rating rating10 = new Rating(user, 0);
                isScoredAdded = rating10.setScore(-1);  
                isRatingAdded = meme.addRating(rating10);
                overAllRating = meme.calculateOverallRating();
                
                System.out.println("******************************");
                int index = 1;
                System.out.println("Before 10 elements: ");
                for (Rating rating: meme.getRatings()) {
                        System.out.println((index++)+"."+rating);
                }
                
                Rating rating11 = new Rating(user, 0);
                isScoredAdded = rating11.setScore(-1);  
                isRatingAdded = meme.addRating(rating11);
                overAllRating = meme.calculateOverallRating();
                
                System.out.println("******************************");
                index = 1;
                System.out.println("After 11 elements: ");
                for (Rating rating: meme.getRatings()) {
                        System.out.println((index++)+"."+rating);
                }
                //First downvoted rating got discarded as we added 11th element.
                
                Rating rating12 = new Rating(user, 0);
                isScoredAdded = rating12.setScore(5);
                System.out.println("isScoredAdded (expected FALSE): "+isScoredAdded);                   //Supposed to be false as we tried setting score 5 (which is not in -1, 0, +1)
                isRatingAdded = meme.addRating(rating12);
                overAllRating = meme.calculateOverallRating();
                
                ArrayList<Meme> memesList = new ArrayList<Meme>();
                memesList.add(meme);
                memesList.add(meme1);
                memesList.add(meme2);
                user.setMemesCreated(memesList);
                user.setMemesViewed(memesList);
                
                System.out.println(user);
                System.out.println(x);
                System.out.println(meme1);
        }
        }