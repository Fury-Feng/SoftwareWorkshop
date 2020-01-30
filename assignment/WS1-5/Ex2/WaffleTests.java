import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * The class has 3 tests to test the getters, the countValue method and the squareWidth method.
 *
 * @author: Fuwei Feng
 * @version: 2019/12/1
 */
public class WaffleTests {

    public static final double TOLERANCE = 0.0000000001;
    Expenditure[] expenditures1;
    Expenditure[] expenditures2;
    public int gap = 3;
    Expenditure expenditure;

    @BeforeEach
    public void init() {
        expenditures1 = new Expenditure[] {
                new Expenditure("Salaries", 11000),
                new Expenditure("Paper", 2000),
                new Expenditure("Rent", 5000),
                new Expenditure("Most popular books on Java etc.", 10000),
                new Expenditure("Heating", 3000),
                new Expenditure("Coffee/Tea", 7000),
                new Expenditure("Biscuits", 8000),
        };

        expenditures2 = new Expenditure[] {
                new Expenditure("Salaries", 11000),
                new Expenditure("Paper", 2000),
                new Expenditure("Rent", 5000),
                new Expenditure("Most popular books on Java etc.", 10000),
                new Expenditure("Heating", 3000),
                new Expenditure("Coffee/Tea", 7000),
                new Expenditure("Biscuits", 8000),
                new Expenditure("Travel", 18000),
                new Expenditure("Electricity", 1000),
                new Expenditure("Pencils", 30000)
        };

        expenditure = new Expenditure("Play", 50000);


    }

    // Testing the countValue method
    @Test
    public void test1() {
        double expectedTotalValue1 = 46000;
        double expectedTotalValue2 = 95000;

        double actualTotalValue1 = Waffle.countValue(expenditures1);
        double actualTotalValue2 = Waffle.countValue(expenditures2);

        assertEquals(expectedTotalValue1, actualTotalValue1, TOLERANCE);
        assertEquals(expectedTotalValue2, actualTotalValue2, TOLERANCE);
    }

    // Testing the squareWidth method
    @Test
    public void test2() {
        int expectedSquareWidth = 30;
        int actualSquareWidth = Waffle.squareWidth(gap);

        assertEquals(expectedSquareWidth, actualSquareWidth);
    }

    // Testing the getters for the class Expenditure.
    @Test
    public void test3() {
        String expectedDescription = "Play";
        int expectedValue = 50000;

        String actualDescription = expenditure.getDescription();
        int actualValue = expenditure.getValue();

        assertEquals(expectedDescription, actualDescription);
        assertEquals(expectedValue, actualValue);
    }

}