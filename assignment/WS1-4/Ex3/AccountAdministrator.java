import java.util.ArrayList;

/**
 * The program is a class named AccountAdministrator extend superclass Account 
 * then implement interface AccountAdministratorInterface.
 * The class add a variable named accounts with ArrayList type.
 * The class has a constructor, a getter, an addAccount method, a resetAccount method, a login method and a toString method.
 * 
 * @author: Fuwei Feng
 * @version: 2019/11/17
 */
public class AccountAdministrator extends Account implements  AccountAdministratorInterface {

    private ArrayList<Account> accounts;

    /**
     * The constructor is used to create AccountAdministrator object.
     * @param name              The name of the account.
     * @param salutation        The salutation of the account.
     * @param email             The email of the account.
     * @param password          The password of the account.
     */
    public AccountAdministrator(String name, String salutation, String email, String password) {
        // Call the constructor of the superclass.
        super(name, salutation, email, password);
        accounts = new ArrayList<>();
    }

    /**
     * Override the getter for the accounts.
     * @return accounts     The accounts controlled by the administrator.
     */
    @Override
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * The method is used to add account to the list of accounts.
     * @param account The new account to be added to the list of accounts
     */
    @Override
    public void addAccount(Account account) {
        getAccounts().add(account);
    }

    /**
     *  If an account can no longer be used, since either the user has
     *  forgotten their password or in case of a standard user has
     *  entered the password incorrectly too often the administrator
     *  can reset the account by setting a new password and resetting
     *  the number of failed login attempts to zero (the latter only
     *  if the account is a standard account).
     *  @param account The account that is to be reset.
     *  @param password The new password for the account that is to be
     *  reset.
     */
    @Override
    public void resetAccount(Account account, String password) {
        if (getLoggedIn() == true) {
            account.changePassword(account.getPassword(), password);
            if (account instanceof AccountStandard) {
                ((AccountStandard) account).setFailedLoginAttempts(0);
            }
        }

    }

    /**
     *  Method for an adminstrator to log in by providing a
     *  password. It is checked whether the password provided is
     *  correct.
     *  @param password The password provided for the login; this is
     *  to be compared to the password stored on the system.
     */
    public void login(String password) {
        super.login(password);
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
            return getSalutation() + " " + super.getName() + "'s account control the users  " + accounts + ".";
        } else {
            return "You need to login your account to see the information.";
        }
    }

}