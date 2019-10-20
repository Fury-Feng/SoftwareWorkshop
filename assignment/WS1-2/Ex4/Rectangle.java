/**
public class Rectangle {

    private double width;
    private double height;
    private double perimeter;

    public Rectangle(double width, double height, double perimeter) {

        this.width = width;
        this.height = height;
        this.perimeter = perimeter;

    }

    public double getWidth() {

        return width;

    }

    public double getHeight() {

        return height;

    }

    public double getPerimeter() {

        return perimeter;

    }

    public void setWidth(double width) {

        this.width = width;

    }

    public  void setHeight(double height) {

        this.height = height;

    }

    public void  setPerimeter(double perimeter) {

        this.perimeter = perimeter;

    }

    @Override
    public String toString() {

        return "The rectangle has a width of " + width +
                ", a height of " + height +
                ", and a perimeter of " + perimeter + ".";

    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 4, 12);
        System.out.println(r);
        r.setHeight(5);
        System.out.println(r);
    }
}
 */



/**
 * I have changed the buggy code, by adding "this.perimeter = (this.height + this.width) * 2" to setWidth and setHeight
 * I also add a judgement statement, to recognize that whether the perimeter is equal to the width plus height as 2 times.
 *
 * We define a rectangle by the three field variables width, height and perimeter, each of type double.
 * Furthermore, we write getters and setters for the three fields as well as a toString method.
 * We test it in a main method.
 *
 * @author: Fuwei Feng
 * @version: 2019/10/19
 */
public class Rectangle {

    private double width;
    private double height;
    private double perimeter;

    /**
     * <pre>
     *                  width
     *     +--------------------------------+
     *     |                                |
     *     |                                |   height
     *     |                                |
     *     |                                |
     *     +--------------------------------+
     * </pre>
     * @param width         The width of the rectangle
     * @param height        The height of the rectangle
     * @param perimeter     The perimeter of the rectangle
     */
    public Rectangle(double width, double height, double perimeter) {

        this.width = width;
        this.height = height;
        if (perimeter == (this.width + this.height) * 2) {
            this.perimeter = perimeter;
        }
        else {
            System.out.println("The input perimeter is wrong with the width and height.");
            System.out.println("The right perimeter should be " + (width + height) * 2 + ".");
            this.perimeter = (this.width + this.height) * 2;
        }

    }

    /**
     * Getter for the width.
     * @return  The width of rectangle is returned.
     */
    public double getWidth() {

        return width;

    }

    /**
     * Getter for the height.
     * @return  The height of rectangle is returned.
     */
    public double getHeight() {

        return height;

    }

    /**
     * Getter for the perimeter.
     * @return  The perimeter of rectangle is returned.
     */
    public double getPerimeter() {

        return perimeter;

    }

    /**
     * Setter for the width. The width of rectangle is updated.
     * With the width updated, the perimeter also need to be updated.
     * @param width     The new width of updated rectangle.
     */
    public void setWidth(double width) {

        this.width = width;
        this.perimeter = (this.height + this.width) * 2;


    }

    /**
     * Setter for the height. The height of rectangle is updated.
     * With the height updated, the perimeter also need to be updated.
     * @param height    The new height of updated rectangle.
     */
    public void setHeight(double height) {

        this.height = height;
        this.perimeter = (this.height + this.width) * 2;

    }

    /**
     * Setter for the perimeter. The perimeter of rectangle is updated.
     * @param perimeter     The new perimeter of the rectangle.
     */
    public void setPerimeter(double perimeter) {

        this.perimeter = perimeter;

    }

    /**
     * @return A human readable description of the rectangle in form of the three field variables specifying it.
     */
    @Override
    public String toString() {
        return "The rectangle has a width of " + this.width +
                ", a height of " + this.height +
                ", and a perimeter of " + this.perimeter + ".";

    }

    /**
     * Main method with a test of the setHeight setter and the toString method.
     */
    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 4, 12);
        System.out.println(r);
        r.setHeight(5);
        System.out.println(r);
    }
}


