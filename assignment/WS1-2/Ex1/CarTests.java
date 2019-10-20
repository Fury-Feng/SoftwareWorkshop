import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The class contains 8 tests to test the constructor
 * test the getters and setters in the Car class
 * @author: Fuwei Feng
 * @version: 2019/10/17
 */
public class CarTests {
    private Car car;

    @BeforeEach
    public void beforeEach() {
        car = new Car("Buick", 22500, 220, "Black");
    }

    //testing getter for make
    @Test
    public void testGetMake() {
        String expected = "Buick";
        String actual = car.getMake();
        assertEquals(expected, actual, "error in getMake");
    }

    //testing getter for price
    @Test
    public void testGetPrice() {
        int expected = 22500;
        int actual = car.getPrice();
        assertEquals(expected, actual, "error in getPrice");
    }

    //testing getter for maxSpeed
    @Test
    public void testGetMaxSpeed() {
        int expected = 220;
        int actual = car.getMaxSpeed();
        assertEquals(expected, actual, "error in getMaxSpeed");
    }

    //testing getter for colour
    @Test
    public void testGetColour() {
        String expected = "Black";
        String actual = car.getColour();
        assertEquals(expected, actual, "error in getColour");
    }

    //testing setter for make
    @Test
    public void testSetMake() {
        car.setMake("Audi");
        String expected = "Audi";
        String actual = car.getMake();
        assertEquals(expected, actual, "error in setMake");
    }

    //testing setter for price
    @Test
    public void testSetPrice() {
        car.setPrice(200000);
        int expected = 200000;
        int actual = car.getPrice();
        assertEquals(expected, actual, "error in setPrice");
    }

    //testing setter for maxSpeed
    @Test
    public void testSetMaxSpeed() {
        car.setMaxSpeed(0);
        int expected = 0;
        int actual = car.getMaxSpeed();
        assertEquals(expected, actual, "error in setMaxSpeed");
    }

    //testing setter for colour
    @Test
    public void testSetColour() {
        car.setColour("White");
        String expected = "White";
        String actual = car.getColour();
        assertEquals(expected, actual, "error in setColour");
    }
}



