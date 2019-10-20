import java.text.DecimalFormat;

/**
 * The program is a class named Good, the class has two private variables, param name with type String, param netPrice with type double
 * one final static VAT_RATE
 * The class contain one constructor, getters and setters for name and netPrice, toString method, discount method and main method
 *
 * @author: Fuwei Feng
 * @version: 2019/10/19
 */
public class Good {

    private String name;
    private double netPrice;
    final static double VAT_RATE = 20;

    /**
     * The constructor is used to create a Good project.
     * @param name          The name of the good
     * @param netPrice      The price of the good
     */
    public Good(String name, double netPrice) {
        this.name = name;
        this.netPrice = netPrice;
    }

    /**
     * Getter for the name.
     * @return name     The name of the good is returned.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name. The name of the good is updated.
     * @param name      The new name of the good.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the netPrice.
     * @return netPrice     The netPrice of the good is returned.
     */
    public double getNetPrice() {
        return netPrice;
    }

    /**
     * Setter for the netPrice. The netPrice of the good is updated.
     * @param netPrice      The new netPrice of the good.
     */
    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    /**
     * @return A human readable description of the good in form of two variables.
     */
    @Override
    public String toString() {

        // Keep the price two decimal places after the decimal points
        String newPrice = String.format("%.2f", grossPrice());

        return "The " + name + " has a gross price of \u00A3" + newPrice + ".";
    }

    /**
     * The method is used to get the price with VAT.
     * @return grossPrice
     */
    public double grossPrice() {
        double grossPrice = netPrice + netPrice * (VAT_RATE/100.0);
        return grossPrice;
    }

    /**
     * The method is used to change the price to discount price.
     * @param rate  the discount rate of the good.
     */
    public void discount (double rate) {
            setNetPrice(this.netPrice * (1 - rate/100.0));
    }

    /**
     * The main method is used to print the milk object with not discount and with discount.
     */
    public static void main(String[] args) {
        Good milk = new Good("Milk", 0.50);
        System.out.println(milk);
        milk.discount(20);
        System.out.println(milk);
    }
}
