/**
 * The program is a class named Expenditure, it has two field variables, description with String type, value with int type.
 * The class has a constructor, getters.
 *
 * @author: Fuwei Feng
 * @version: 2019/11/30
 */
public class Expenditure {

    private String description;
    private int value;

    /**
     * The constructor is used to create a expenditure object.
     *
     * @param description   The description of the expenditure.
     * @param value         The value of the expenditure.
     */
    public Expenditure(String description, int value) {
        this.description = description;
        this.value = value;
    }

    /**
     * Getter for the description.
     * @return  description     The description of the expenditure.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for the value.
     * @return  value           The value of the expenditure.
     */
    public int getValue() {
        return value;
    }

}
