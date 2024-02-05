
public class Rectangle {

    // fields
    private double length;
    private double width;
    private Point topLeftCorner;

    // default constructor (takes no parameters)
    public Rectangle() {
        // length and width assigned default values (4 for length and 2 for width)
        this.setLength(4);
        this.setWidth(2);
        this.setTopLeftCorner(new Point());
    }

    // constructor
    public Rectangle(double length, double width, Point corner) {
        this.setLength(length);
        this.setWidth(width);
        this.setTopLeftCorner(corner);
    }

    // WRITE an appropriate
    // (1) toString method
    // (2) getter and setter methods for the length field
    // (3) getter and setter methods for the width field
    // (4) getter and setter methods for the topLeftCorner field
    public String toString() {
        return "(" + this.length + ", " + this.width + ", " + this.topLeftCorner + ")";
    }
    

    public static void main(String[] args) {
        // Reminder: don't write methods within other methods.
        // Test out toString() method and getters and setters here! (Main method testing)

    }

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public Point getTopLeftCorner() {
		return topLeftCorner;
	}

	public void setTopLeftCorner(Point topLeftCorner) {
		this.topLeftCorner = topLeftCorner;
	}

}