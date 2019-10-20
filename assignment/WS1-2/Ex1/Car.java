/**
 * The program is a class named Car, the class has four variables
 * two are make and colour with String type
 * another two variables are price and maxSpeed with int type.
 * The class has constructor, getter and setter.
 * @author: Fuwei Feng
 * @version: 2019/10/17
 */
public class Car {
    private String make;
    private int price;
    private int maxSpeed;
    private String colour;

    /**
     * The constructor is used to creat a car object.
     * @param make          The company which make the car
     * @param price         The price of the car
     * @param maxSpeed      The maxSpeed of the car
     * @param colour        The colour of the car
     */
    public Car(String make, int price, int maxSpeed, String colour) {
        this.make = make;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.colour = colour;
    }

    /**
     * Getter for the make.
     * @return make     The make of the car is return.
     */
    public String getMake() {
        return make;
    }

    /**
     * Setter for the make. The make of the car is updated.
     * @param make    The new make of the car.
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Getter for the price.
     * @return price    The price of the car is return.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter for the price. The price of the car is updated.
     * @param price     The new price of the car.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter for the maxSpeed.
     * @return maxSpeed     The maxSpeed of the car is return.
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Setter for the maxSpeed. The maxSpeed of the car is updated.
     * @param maxSpeed   The new maxSpeed of the car.
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * Getter for the colour.
     * @return colour       The colour of the car is return.
     */
    public String getColour() {
        return colour;
    }

    /**
     * Setter for the colour. The colour of the car is updated.
     * @param colour    The new colour of the car.
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * @return A human readable description of the car in form of the four field variables specifying in.
     */
    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                ", colour='" + colour + '\'' +
                '}';
    }
}
