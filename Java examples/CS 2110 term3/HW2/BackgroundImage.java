
public class BackgroundImage {
	private String imageFileName;
	private String title;
	private String description;
	
	@Override
	public String toString()
	{
		return "";
	}
	@Override
	public boolean equals(Object other) {
		
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
