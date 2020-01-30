/**
 * The program is a class named Aircraft, the class has two variables
 * the variables are passengerNumber and maxSpeed with int type.
 * The class has a constructor, getters, setters and toString method.
 *
 * @author: Fuwei Feng
 * @version: 2019/11/16
 */
public class Aircraft {

    private int passengerNumber;
    private int maxSpeed;

    /**
     * The constructor is used to create an aircraft object.
     * @param passengerNumber   The passengerNumber of the aircraft.
     * @param maxSpeed          The maxSpeed of the aircraft.
     */
    public Aircraft(int passengerNumber, int maxSpeed) {
        this.passengerNumber = passengerNumber;
        this.maxSpeed = maxSpeed;
    }

    /**
     * Getter for the passengerNumber.
     * @return passengerNumber      The passengerNumber of the aircraft.
     */
    public int getPassengerNumber() {
        return passengerNumber;
    }

    /**
     * Setter for the passengerNumber.  The passengerNumber of the aircraft is updated.
     * @param passengerNumber       The new passengerNumber of the aircraft.
     */
    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    /**
     * Getter for the maxSpeed.
     * @return maxSpeed     The maxSpeed of the aircraft.
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Setter for the maxSpeed.     The maxSpeed of the aircraft is updated.
     * @param maxSpeed      The new maxSpeed of the aircraft.
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * @return A human readable description of the aircraft in form of the two field variables specifying in.
     */
    public String toString() {
        return "Aircraft: " + "passengerNumber : " + passengerNumber + "  maxSpeed : " + maxSpeed;
    }
}
