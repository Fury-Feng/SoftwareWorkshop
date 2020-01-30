/**
 * The program is a class named Account implements interface AccountInterface.
 * The class has five field variables: name, salutation, email, password with String type and loggedIn with boolean type.
 * The class has a constructor, a login method, a logout method, 
 * getters, setters, a checkPassword method, a toString method and a changePassword method. 
 *
 * @author: Fuwei Feng
 * @version: 2019/11/16
 */
public abstract class Account implements AccountInterface {

    private String name;
    private String salutation;
    private String email;
    private String password;
    private boolean loggedIn;

    /**
     * The constructor is used to create account object.
     * @param name              The name of the account.
     * @param salutation        The salutation of the account.
     * @param email             The email of the account.
     * @param password          The password of the account.
     */
    public Account(String name, String salutation, String email, String password) {
        this.name = name;
        this.salutation = salutation;
        this.email = email;
        this.password = password;
    }

    /**
     * @param password The password provided that will be compared to
     *  the password stored on the system.
     *  If the password provided is correct, the field
     *  variable loggedIn is changes to true, else print a warning information.
     */
    @Override
    public void login(String password) {
        if (checkPassword(password)) {
            setLoggedIn(true);
        } else {
            System.out.println("You input the wrong password !!!");
        }
    }

    /**
     * Getter for the loggedIn.
     * @return loggedIn     The login status of the account.
     */
    @Override
    public boolean getLoggedIn() {
        return loggedIn;
    }

    /**
     * Setter for the loggedIn.     The login status of account is updated.
     * @param loggedIn      The new status of the account.
     */
    @Override
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     * If the user logout, the loggedIn change to false.
     */
    @Override
    public void logout() {
        this.loggedIn = false;
    }

    /**
     * Override getter for the name.
     * @return name.    The name of the account.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Override getter for the salutation.
     * @return salutation   The salutation of the account.
     */
    @Override
    public String getSalutation() {
        return salutation;
    }

    /**
     * Override getter for the email.
     * @return email    The email of the account.
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * Override getter for the password.
     * @return password     The password of the account.
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Override setter for the password. The password of the account is updated.
     * @param password      The new password of the account.
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method to compare a provided password with the stored password.
     * @param password The provided password to which the password of
     * the this object is compared.
     * @return true if the password of the account agrees with the
     * argument, false else.
     */
    @Override
    public boolean checkPassword(String password) {
        if (getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Override the toString method.
     * @return a human readable description of the account in form of the three field variables specifying in.
     */
    @Override
    public String toString() {
        return "Account[ Name: " + name + ", Salutation: " + salutation + ", Email: " + email + "]";
    }

    /**
     * Changes the password from old to new if the old password is
     * correct, else an error message is printed.
     * @param oldPassword The current password.
     * @param newPassword The future password.
     */
    @Override
    public void changePassword(String oldPassword, String newPassword) {
        if (checkPassword(oldPassword)) {
            setPassword(newPassword);
        } else {
            System.out.println("You input the wrong password! Fail to change the password!");
        }
    }
}
