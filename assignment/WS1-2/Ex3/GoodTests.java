import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Public tests for the Good class
 * The class contain 6 tests.
 * @author: Fuwei Feng
 * @version: 2019/10/19
 */
class GoodTests {

    private Good milk;
    public final static double TOLERANCE = 0.000001;

    @BeforeEach
    public void setGood() {
        milk = new Good("Milk", 0.50);
    }

    // testing public access of VAT_RATE
    @Test
    public void test1() {
        double expectedVATRATE = 20;
        double actualVATRATE = Good.VAT_RATE;

        assertEquals(expectedVATRATE, actualVATRATE, TOLERANCE,
                "There is an error in test1: expected VATRATE not equal to actual VATRATE");
    }

    // testing getter of milk
    @Test
    public void test2() {
        String expectedName = "Milk";
        double expectedNetPrice = 0.50;
        String actualName = milk.getName();
        double actualNetPrice = milk.getNetPrice();

        assertEquals(expectedName, actualName,
                "There is an error in test2: expected Name not equal to actual Name");
        assertEquals(expectedNetPrice, actualNetPrice, TOLERANCE,
                "There is an error in test2: expected NetPrice not equal to actual NetPrice");
    }

    // testing setter of milk
    @Test
    public void test3() {
        milk.setName("Sweet Milk");
        milk.setNetPrice(1.99);

        String expectedName = "Sweet Milk";
        double expectedNetPrice = 1.99;
        String actualName = milk.getName();
        double actualNetPrice = milk.getNetPrice();

        assertEquals(expectedName, actualName,
                "There is an error in test4: expected Name not equal to actual Name");
        assertEquals(expectedNetPrice, actualNetPrice, TOLERANCE,
                "There is an error in test4: expected NetPrice not equal to actual NetPrice");
    }

    // testing toString method
    @Test
    public void test4() {
        milk.setName("Sweet Milk");
        milk.setNetPrice(1);

        String expectedString = "The Sweet Milk has a gross price of \u00A31.20.";
        String actualString = milk.toString();
        assertEquals(expectedString, actualString, "There is an error in test4: expected toString not equal to actual toString");
    }

    // testing grossPrice method
    @Test
    public void test5() {
        double expectedGrossPrice = 0.6;
        double actualGrossPrice = milk.grossPrice();

        assertEquals(expectedGrossPrice, actualGrossPrice, TOLERANCE,
                "There is an error in test5: expected grossPrice not equal to actual grossPrice");
    }

    // testing discount method (via calling toString)
    @Test
    public void test6() {
        milk.discount(20);
        String expectedString = "The Milk has a gross price of \u00A30.48.";
        String actualString = milk.toString();
        assertEquals(expectedString, actualString,
                "There is an error in test6: expected toString output not equal to actual toString output");
    }

}

