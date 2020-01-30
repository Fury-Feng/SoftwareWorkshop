/**
 * The program is a class named SubscriptionPrime extends class Subscription and implement interface SubscriptionPrimeInterface.
 * The class SubscriptionPrime is subclass of the class Subscription, the subclass add a variable named address with String type.
 * The class has a constructor and override the getAddress method and the toString method.
 *
 * @author: Fuwei Feng
 * @version: 2019/11/16
 */
public class SubscriptionPrime extends Subscription implements SubscriptionPrimeInterface {

    private String address;

    /**
     * The constructor is used to create subscriptionPrime object.
     * @param title         The title of the subscriptionPrime.
     * @param email         The email of the subscriptionPrime.
     * @param cost          The cost of the subscriptionPrime.
     * @param address       The address of the subscriptionPrime.
     */
    public SubscriptionPrime(String title, String email, int cost, String address) {
        // Call the constructor of the superclass.
        super(title, email, cost);
        this.address = address;
    }

    /**
     * Override the getter for the address.
     * @return address      The address of the subscriptionPrime.
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * Override the toString method.
     * @return A human readable description of the subscription in form of the four field variables specifying in.
     */
    @Override
    public String toString() {
        // Call the toString method of the superclass.
        return super.toString() + "\nAddress : " + address;
    }
}
