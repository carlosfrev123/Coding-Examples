
public class Rectangle {

    // fields
    private double length;
    private double width;
    private Point topLeftCorner;

    // default constructor (takes no parameters)
    public Rectangle() {
        // length and width assigned default values (4 for length and 2 for width)
        this.length = 4;
        this.width = 2;
        this.topLeftCorner = new Point();
    }

    // constructor
    public Rectangle(double length, double width, Point corner) {
        this.length = length;
        this.width = width;
        this.topLeftCorner = corner;
    }

    // WRITE an appropriate
    // (1) toString method
    // (2) getter and setter methods for the length field
    // (3) getter and setter methods for the width field
    // (4) getter and setter methods for the topLeftCorner field

    public static void main(String[] args) {
        // Reminder: don't write methods within other methods.
        // Test out toString() method and getters and setters here! (Main method testing)

    }

}
