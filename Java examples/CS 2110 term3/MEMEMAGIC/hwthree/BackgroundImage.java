public class BackgroundImage {

	private String imageFileName;
	private String title;
	private String description;
	
/*--------------------------------------------------------------------------------------------------------------------------------------*/
//Constructors
	
	// Default
	public BackgroundImage() {
		this.imageFileName = "file name";
		this.title = "title";
		this.description = "description";

	}

	// Overloaded Constructor
	public BackgroundImage(String imageFileName, String title, String description) {

		this.imageFileName = imageFileName;
		this.title = title;
		this.description = description;
	}

/*--------------------------------------------------------------------------------------------------------------------------------------*/	
// Getters and Setters

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
/*--------------------------------------------------------------------------------------------------------------------------------------*/
// Override
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BackgroundImage other = (BackgroundImage) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (imageFileName == null) {
			if (other.imageFileName != null)
				return false;
		} else if (!imageFileName.equals(other.imageFileName))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return title + " <" + description + ">";
	}

	
/*--------------------------------------------------------------------------------------------------------------------------------------*/	
// TESTING
	public static void main(String[] args) {
		// Constructor
		BackgroundImage bg1 = new BackgroundImage();
		BackgroundImage bg2 = new BackgroundImage("Joker", "How bots laugh", "Image of Joker");
		//To String 
		System.out.println(bg1);
		System.out.println(bg2);
		// Equals
		System.out.println(bg1.equals(bg1));
		System.out.println(bg1.equals(bg2));
		
	}

}
