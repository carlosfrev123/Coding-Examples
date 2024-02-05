/* Point class - a point in 2D space */
public class Point {

    // fields - instance variables
    private double x;  // x coordinate
    private double y;  // y coordinate

    public Point(double x, double y) { // constructor; takes in two parameters, x and y
        this.x = x;  // NOT: x = this.x;
        this.y = y;  // IS CONFUSING!: y = y;
    }

    // constructor overloading: when you have *more than one constructor*, each
    // with *different* input parameters
    public Point() { // constructor (this one has no parameters)
        this.x = 0.0;
        this.y = 0.0;
    }

    // copy constructor - takes in an object of type Point
    public Point(Point p2) {
        this.x = p2.x; // p2's x value is copied to instance variable x
        this.y = p2.y; // p2's y value is copied to instance variable y
    }

    // toString() method to print out objects of type Point
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public static void main(String[] args) {
        Point p;  // a Point reference defined; doesn't create an actual Point
        Point p1 = new Point(3.0, 0.0);
        Point p2 = new Point(); // call to default constructor with no parameters
        Point p3 = new Point(p2); // call to copy constructor - copy of p2
        System.out.println(p1);
        System.out.println(p2);
        p1.distanceBetween(p2); // p1 is the calling object, p2 is the "passing" (as a parameter) object
        System.out.println(p1.distanceBetween(p2));
        // System.out.println calls toString() method of Point class
        // if the Point class does NOT have a toString() method, then toString of Object class is called
    }

    // distanceBetween() method that calculates the distance between the calling and passing Points
    public double distanceBetween(Point p) {
        double xdiff = this.x - p.x;
        double ydiff = this.y - p.y; // "this" refers to the CALLING object's fields
        return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
    }

    // GETTERS AND SETTERS
    /**
     * @return the x
     */
    public double getX() {
        return this.x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return this.y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

}
