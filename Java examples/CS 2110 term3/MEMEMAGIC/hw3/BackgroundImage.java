
public class BackgroundImage {
	private String imageFileName;
	private String title;
	private String description;
	
	public BackgroundImage( String imageFileName, String title, String description) {
		this.imageFileName = imageFileName;
		this.description = description;
		this.title = title;
		
		
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
