import java.util.ArrayList;

public class Feed {
	
	private ArrayList<Meme> memes;
	
/*--------------------------------------------------------------------------------------------------------------------------------------*/
//Constructors

	
	
	
/*--------------------------------------------------------------------------------------------------------------------------------------*/
//Getters and Setters 
	public ArrayList<Meme> getMemes() {
		return memes;
	}
	
	public Meme getNewMeme (User s) {
		Meme m = new Meme();
		return m;
	}
	
	
/*--------------------------------------------------------------------------------------------------------------------------------------*/
//Override
	@Override
	public String toString() {
		return "Feed [memes=" + memes + "]";
	}

	public void setMemes(ArrayList<Meme> memes) {
		this.memes = memes;
	}
	
	
/*--------------------------------------------------------------------------------------------------------------------------------------*/
//Testing
	
	
}
