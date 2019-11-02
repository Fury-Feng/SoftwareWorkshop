/**
 * The class contains 13 tests to test constructor, add method, average method, averageSalaries method and not3TimesHigher method in the Salaries class.
 *
 * @author: Fuwei Feng
 * @version: 2019/10/31
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class SalariesTests {

    public static final double TOLERANCE = 0.0000000001;
    private Salaries salaries;

    @BeforeEach
    public void init() {
        salaries = new Salaries();
        double[] tonySalary = { 1000, 1000, 2000, 2000, 0, 0, 0, 0, 0, 0, 0, 0 };
        double[] stevenSalary = { 1000, 1000, 2000, 2000, 1320, 2110, 1350, 1400, 1600, 2200, 1100, 1450 };
        double[] jackSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1400 };
        double[] furySalary = { 0, 1000, 0, 2000, 0, 2110, 1350, 1400, 0, 0, 0, 0 };
        salaries.add(tonySalary);
        salaries.add(stevenSalary);
        salaries.add(jackSalary);
        salaries.add(furySalary);
    }

    @Test
    public void test1() {
        double[] tonySalary = { 1000, 1000, 2000, 2000, 0, 0, 0, 0, 0, 0, 0, 0 };
        double expectedAverage = 1500.;
        double actualAverage = Salaries.average(tonySalary);
        assertEquals(expectedAverage, actualAverage, TOLERANCE);
    }

    @Test
    public void test2() {
        double[] stevenSalary = { 1000, 1000, 2000, 2000, 1320, 2110, 1350, 1400, 1600, 2200, 1100, 1450 };
        double expectedAverage = 1544.1666666666;
        double actualAverage = Salaries.average(stevenSalary);
        assertEquals(expectedAverage, actualAverage, TOLERANCE);
    }

    @Test
    public void test3() {
        double[] jackSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1400 };
        double expectedAverage = 1400;
        double actualAverage = Salaries.average(jackSalary);
        assertEquals(expectedAverage, actualAverage, TOLERANCE);
    }

    @Test
    public void test4() {
        double[] furySalary = { 0, 1000, 0, 2000, 0, 2110, 1350, 1400, 0, 0, 0, 0 };
        double expectedAverage = 1572.;
        double actualAverage = Salaries.average(furySalary);
        assertEquals(expectedAverage, actualAverage, TOLERANCE);
    }

    @Test
    public void test5() {
        double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        assertThrows(IllegalArgumentException.class, () -> {
            Salaries.average(noSalary);
        });
    }

    @Test
    public void test6() {

        ArrayList<Double> expectedAverageSalaries = new ArrayList<>();
        expectedAverageSalaries.add(1500.0);
        expectedAverageSalaries.add(1544.1666666666);
        expectedAverageSalaries.add(1400.0);
        expectedAverageSalaries.add(1572.);
        ArrayList<Double> actualAverageSalaries = salaries.averageSalaries();

        for (int i = 0; i < actualAverageSalaries.size(); i++) {
            assertEquals(expectedAverageSalaries.get(i), actualAverageSalaries.get(i), TOLERANCE);
        }
    }

    @Test
    public void test7() {
        double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        ArrayList<Double> expectedAverageSalaries = new ArrayList<>();
        expectedAverageSalaries.add(1500.0);
        expectedAverageSalaries.add(1544.1666666666);
        expectedAverageSalaries.add(1400.0);
        expectedAverageSalaries.add(1572.);
        expectedAverageSalaries.add(0.);
        salaries.add(noSalary);
        ArrayList<Double> actualAverageSalaries = salaries.averageSalaries();

        for (int i = 0; i < actualAverageSalaries.size(); i++) {
            assertEquals(expectedAverageSalaries.get(i), actualAverageSalaries.get(i), TOLERANCE);

        }
    }

    @Test
    public void test8() {
        double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        double[] timSalary = { 2500, 1542, 1345, 2415, 1246, 1876, 0, 0, 0, 0, 0, 0 };
        ArrayList<Double> expectedAverageSalaries = new ArrayList<>();
        expectedAverageSalaries.add(1500.0);
        expectedAverageSalaries.add(1544.1666666666);
        expectedAverageSalaries.add(1400.0);
        expectedAverageSalaries.add(1572.);
        expectedAverageSalaries.add(1820.666666666666);

        salaries.add(noSalary);
        salaries.add(timSalary);
        ArrayList<Double> actualAverageSalaries = salaries.averageSalaries();

        for (int i = 0; i < actualAverageSalaries.size(); i++) {
            assertEquals(expectedAverageSalaries.get(i), actualAverageSalaries.get(i), TOLERANCE);

        }
    }

    @Test
    public void test9() {
        double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        double[] timSalary = { 2500, 1542, 1345, 2415, 1246, 1876, 0, 0, 0, 0, 0, 0 };
        salaries.add(noSalary);
        salaries.add(timSalary);
        assertTrue(salaries.not3TimesHigher());
    }

    @Test
    public void test10() {
        double[] nickySalary = { 100000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        salaries.add(nickySalary);
        assertFalse(salaries.not3TimesHigher());
    }

    @Test
    public void test11() {
        double[] nickySalary = { 1000, 2200, 3300, 4200, 0, 0, 0, 0, 0, 0, 0, 0 };
        salaries.add(nickySalary);
        assertTrue(salaries.not3TimesHigher());
    }

    @Test
    public void test12() {
        double[] noSalary = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        Salaries newsalaries = new Salaries();
        newsalaries.add(noSalary);
        assertTrue(newsalaries.not3TimesHigher());
    }

    @Test
    public void test13() {
        double[] tonySalary = { 1000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        Salaries newsalaries = new Salaries();
        newsalaries.add(tonySalary);
        assertTrue(newsalaries.not3TimesHigher());
    }
}
