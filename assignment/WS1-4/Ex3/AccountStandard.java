import java.util.ArrayList;

/**
 * The program is a class named AccountStandard extends superclass Account
 * then implements AccountStandardInterface.
 * The class has add three variables: balance and failedLoginAttempts with int type, titlesBought with ArrayList type.
 * The class has a constructor, getters, setters, a login method, a deposit method, a buy method and a toString method.
 * 
 * @author: Fuwei Feng
 * @version: 2019/11/16
 */
public class AccountStandard extends Account implements AccountStandardInterface {

    private int balance;
    private ArrayList<MusicTitle> titlesBought;
    private int failedLoginAttempts;
    public static final int MAXIMAL_LOGIN_ATTEMPTS = 3;

    /**
     * The constructor is used to create user account object.
     * @param name              The name of the account.
     * @param salutation        The salutation of the account.
     * @param email             The email of the account.
     * @param password          The password of the account.
     */
    public AccountStandard(String name, String salutation, String email, String password) {
        // Call the constructor of the superclass.
        super(name, salutation, email, password);
        titlesBought = new ArrayList<>();
    }

    /**
     * Override getter for the balance.
     * @return balance      The balance of the account.
     */
    @Override
    public int getBalance() {
        return balance;
    }

    /**
     *  Method for a user to log in to their account by providing a
     *  password. It is first checked whether the account is still
     *  active (that is, not too many failed login attempts were made
     *  in the past) and secondly whether the password provided is
     *  correct. In case of a correct login the number of login
     *  attempts is reset to 0, else increased by 1.
     *  @param password The password provided for the login; this is
     *  to be compared to the password stored on the system.
     */
    @Override
    public void login(String password) {
        if (failedLoginAttempts < MAXIMAL_LOGIN_ATTEMPTS) {

            if(super.checkPassword(password)) {
                this.failedLoginAttempts = 0;
                super.setLoggedIn(true);
            } else {
                this.failedLoginAttempts++;
            }

        } else {
            System.out.println("You have input wrong password three times, your account has been locked!!");
        }
    }

    /**
     * Override getter for the titlesBought.
     * @return titlesBought     The titlesBought of the account.
     */
    @Override
    public ArrayList<MusicTitle> getTitlesBought() {
        return titlesBought;
    }

    /**
     * Adds the amount - if positive - to the current balance. For
     * non-positive amounts the action does nothing.
     * @param amount The amount being deposited.
     */
    @Override
    public void deposit(int amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
        }
    }

    /**
     * Override setter for the balance. The balance of the account is updated.
     * @param balance       The new balance of the account.
     */
    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Override getter for the failedLoginAttempts.
     * @return failedLoginAttempts
     */
    @Override
    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    /**
     *  Setter for the failed login attempts.
     *  @param failedLoginAttempts The new number of failed login attempts.
     */
    @Override
    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    /**
     *  If the user is logged in and has sufficient funds, a music
     *  title is bought by adding the title to the ArrayList of
     *  titlesBought of the customer. Furthermore the price of the
     *  title is subtracted from the funds of the customer. If the
     *  user is not logged in, a corresponding warning is to be
     *  printed. Likewise if the user has insufficient funds, they
     *  should be asked to pay money into their account.
     *  @param musicTitle The music title that the customer wants to
     *  buy.
     */
    @Override
    public void buy(MusicTitle musicTitle) {
        if (getLoggedIn() == true) {
            if(getBalance() >= musicTitle.getPrice()) {
                titlesBought.add(musicTitle);
                setBalance(getBalance() - musicTitle.getPrice());
            } else {
                System.out.println("You do not have enough money to buy the musicTitle, please pay money into your account.");
            }
        } else {
            System.out.println("You have not login.");
        }
    }

    /**
     * Standard toString method to represent the object in a human
     * readable form. If the user is not logged in, only a warning
     * should be printed, but no substantial information be given.
     * @return The object in a human readable form.
     */
    @Override
    public String toString() {
        if (getLoggedIn() == true) {
            return getSalutation() + " " + super.getName() + "'s account still have " + balance + ". \n You have bought the musictitles "
                    + titlesBought;
        } else {
            return "You need to login your account to see the information.";
        }

    }
}