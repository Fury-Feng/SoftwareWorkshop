/**
 * The program is a subclass of Aircraft named Aeroplane.
 * The subclass extends from the class Aircraft, the subclass add a variable named fuelConsumption with int type.
 * The class has a constructor, getter, setter and the override toString method.
 *
 * @author: Fuwei Feng
 * @version: 2019/11/16
 */
public class Aeroplane extends Aircraft {

    private double fuelConsumption;

    /**
     * The constructor is used to create an aeroplane object.
     * @param passengerNumber   The passengerNumber of the aeroplane.
     * @param maxSpeed          The maxSpeed of the aeroplane.
     * @param fuelConsumption   The fuelConsumption of the aeroplane.
     */
    public Aeroplane(int passengerNumber, int maxSpeed, double fuelConsumption) {
        // Call the constructor of the superclass.
        super(passengerNumber, maxSpeed);
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * Getter for the fuelConsumption.
     * @return fuelConsumption      The fuelConsumption of the aeroplane.
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Setter for the fuelConsumption.  The fuelConsumption of the aeroplane is updated.
     * @param fuelConsumption       The new fuelConsumption of the aeroplane.
     */
    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * The toString method is extended from the superclass and has been overrode in the subclass.
     * @return A human readable description of the aeroplane in form of the three field variables specifying in.
     */
    @Override
    public String toString() {
        // Call the toString method of the superclass.
        return super.toString() + "  fuelConsumption : " + fuelConsumption;
    }
}
