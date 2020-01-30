/**
 * The program is a class named Subscription implements interface SubscriptionInterface.
 * The class has three field variables: title with String type, email with String type, cost with int type.
 * The class has a constructor, and the class override the getters and the toString method.
 *
 * @author: Fuwei Feng
 * @version: 2019/11/16
 */
public class Subscription implements SubscriptionInterface {

    private String title;
    private String email;
    private int cost;

    /**
     * The constructor is used to create Subscription object.
     * @param title     The title of the subscription.
     * @param email     The email of the subscription.
     * @param cost      The cost of the subscription.
     */
    public Subscription(String title, String email, int cost) {
        this.title = title;
        this.email = email;
        this.cost = cost;
    }

    /**
     * Override the getter for the title.
     * @return title   The title of the subscription.
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Override the getter for the email.
     * @return email    The email of the subscription.
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * Override the getter for the cost.
     * @return cost     The cost of the subscription.
     */
    @Override
    public int getCost() {
        return cost;
    }

    /**
     * Override the toString method.
     * @return A human readable description of the subscription in form of the three field variables specifying in.
     */
    @Override
    public String toString() {
        return "Subscription: \nTitle : " + title + "\nEmail : "
                + email + "\nCost : " + cost;
    }
}
