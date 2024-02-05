import java.util.ArrayList;

public class Feed {
	protected ArrayList<Meme> memes;

	public Feed() {
		memes = new ArrayList<Meme>();
	}
	
	
	public Meme getNewMeme(User user) {
		if(memes.size() == 0) {
			return null;
		}
		
		for(Meme i: memes) {
			if(i != null) { 
				if(!user.getMemesViewed().contains(i) && !user.getMemesCreated().contains(i)){
					return i;
				}
			}
		}	
		return null;
	}
	
	@Override
	public String toString(){
		String result = "";
		for(int i = 0; i < memes.size(); i++) {
			result += memes.get(i).toString()+"\n";    
			
			
		}
		return result;
	}
	
	
	public ArrayList<Meme> getMemes() {
		return memes;
	}

	public void setMemes(ArrayList<Meme> memes) {
		this.memes = memes;
	}
	
}
