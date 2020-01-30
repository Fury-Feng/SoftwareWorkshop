/**
 * The class has 9 tests to test the getters, setters and toString methods
 * in the Aircraft class and Aeroplane class.
 *
 * @author: Fuwei Feng
 * @version: 2019/11/16
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class AircraftTests {

    public static final double TOLERANCE = 0.0000000001;
    private Aircraft firstAircraft;
    private Aircraft secondAircraft;
    private Aeroplane aeroplane;

    @BeforeEach
    public void init() {
        firstAircraft = new Aircraft(500, 1001);
        secondAircraft = new Aeroplane(700, 700, 777.99);
        aeroplane = new Aeroplane(300, 1500, 365.75);
    }

    // Testing getters for firstAircraft
    @Test
    public void test1() {
        int expectedPassengerNumber = 500;
        int expectedMaxSpeed = 1001;

        int actualPassengerNumber = firstAircraft.getPassengerNumber();
        int actualMaxSpeed = firstAircraft.getMaxSpeed();

        assertEquals(expectedPassengerNumber, actualPassengerNumber);
        assertEquals(expectedMaxSpeed, actualMaxSpeed);
    }

    // Testing setters for firstAircraft.
    @Test
    public void test2() {
        firstAircraft.setPassengerNumber(600);
        firstAircraft.setMaxSpeed(899);

        int expectedPassengerNumber = 600;
        int expectedMaxSpeed = 899;

        int actualPassengerNumber = firstAircraft.getPassengerNumber();
        int actualMaxSpeed = firstAircraft.getMaxSpeed();

        assertEquals(expectedPassengerNumber, actualPassengerNumber);
        assertEquals(expectedMaxSpeed, actualMaxSpeed);
    }

    // Testing getters for aeroplane.
    @Test
    public void test3() {
        int expectedPassengerNumber = 300;
        int expectedMaxSpeed = 1500;
        double expectedFuelConsumption = 365.75;

        int actualPassengerNumber = aeroplane.getPassengerNumber();
        int actualMaxSpeed = aeroplane.getMaxSpeed();
        double actualFuelConsumption = aeroplane.getFuelConsumption();

        assertEquals(expectedPassengerNumber, actualPassengerNumber);
        assertEquals(expectedMaxSpeed, actualMaxSpeed);
        assertEquals(expectedFuelConsumption, actualFuelConsumption, TOLERANCE);
    }

    // Testing setters for aeroplane.
    @Test
    public void test4() {
        aeroplane.setPassengerNumber(557);
        aeroplane.setMaxSpeed(999);
        aeroplane.setFuelConsumption(789.12);

        int expectedPassengerNumber = 557;
        int expectedMaxSpeed = 999;
        double expectedFuelConsumption = 789.12;

        int actualPassengerNumber = aeroplane.getPassengerNumber();
        int actualMaxSpeed = aeroplane.getMaxSpeed();
        double actualFuelConsumption = aeroplane.getFuelConsumption();

        assertEquals(expectedPassengerNumber, actualPassengerNumber);
        assertEquals(expectedMaxSpeed, actualMaxSpeed);
        assertEquals(expectedFuelConsumption, actualFuelConsumption, TOLERANCE);
    }

    // Testing toString method for aircraft.
    @Test
    public void test5() {
        String expectedToString = "Aircraft: passengerNumber : 500  maxSpeed : 1001";

        String actualToString = firstAircraft.toString();

        assertEquals(expectedToString, actualToString);
    }

    // Testing toString method for aeroplane.
    @Test
    public void test6() {
        String expectedToString = "Aircraft: passengerNumber : 300  maxSpeed : 1500  fuelConsumption : 365.75";

        String actualToString = aeroplane.toString();

        assertEquals(expectedToString, actualToString);
    }

    // Testing getters for secondAircraft.
    @Test
    public void test7() {
        int expectedPassengerNumber = 700;
        int expectedMaxSpeed = 700;

        int actualPassengerNumber = secondAircraft.getPassengerNumber();
        int actualMaxSpeed = secondAircraft.getMaxSpeed();

        assertEquals(expectedPassengerNumber, actualPassengerNumber);
        assertEquals(expectedMaxSpeed, actualMaxSpeed);
    }

    // Testing setters for secondAircraft.
    @Test
    public void test8() {
        secondAircraft.setPassengerNumber(678);
        secondAircraft.setMaxSpeed(876);

        int expectedPassengerNumber = 678;
        int expectedMaxSpeed = 876;

        int actualPassengerNumber = secondAircraft.getPassengerNumber();
        int actualMaxSpeed = secondAircraft.getMaxSpeed();

        assertEquals(expectedPassengerNumber, actualPassengerNumber);
        assertEquals(expectedMaxSpeed, actualMaxSpeed);
    }

    // Testing toString method for secondAircraft.
    @Test
    public void test9() {
        String expectedToString = "Aircraft: passengerNumber : 700  maxSpeed : 700  fuelConsumption : 777.99";

        String actualToString = secondAircraft.toString();

        assertEquals(expectedToString, actualToString);
    }
}