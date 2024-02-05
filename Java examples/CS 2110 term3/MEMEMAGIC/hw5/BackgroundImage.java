
public class BackgroundImage implements Comparable<BackgroundImage>{
	private String imageFileName;
	private String title;
	private String description;
	
	public BackgroundImage() {
		this.imageFileName = "file name";
		this.description = "description";
		this.title = "title" ;
	}
	
	public BackgroundImage( String imageFileName, String title, String description) {
		this.imageFileName = imageFileName;
		this.description = description;
		this.title = title;
		
		
	}
	public int compareTo(BackgroundImage a){
		int valueOfSmallerfn = imageFileName.compareTo(a.getImageFileName());
		if( valueOfSmallerfn != 0 ) {
			return valueOfSmallerfn;
		}
		int valueOfSmallert = title.compareTo(a.getTitle());
		if( valueOfSmallert != 0 ) {
			return valueOfSmallert;
		}
		int valueOfSmallerd = description.compareTo(a.getDescription());
			return valueOfSmallerd;
	}
	
	@Override
	public String toString(){
		
		
		return title + " <" + description + ">";
	}
	@Override
	public boolean equals(Object other) {
		  if (other instanceof BackgroundImage) {
		    BackgroundImage otherImage = (BackgroundImage) other;
		    if (this.title.equals(otherImage.title) && (this.description.equals(otherImage.description) && (this.imageFileName.equals(otherImage.imageFileName)))){
		      return true;
		    }
		  }
		  return false;
	}
	
	
	
	
	
	public String getImageFileName() {
		return imageFileName;
	}
	
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
