import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Public test for the class Film.
 * The class contain 7 tests.
 *
 * @author: Fuwei Feng
 * @version: 2019/10/17
 */
public class FilmTests {
    private Date date;
    private Film adAstra;

    @BeforeEach
    public void init() {
        date = new Date(18, "September", 2019);
        adAstra = new Film("Ad Astra", date, 123);
    }

    @Test
    public void testGetDay() {
        int expected = 18;
        int actual = adAstra.getReleaseDate().getDay();

        assertEquals(expected, actual, "error in getDay: expected day does not equal actual day");
    }

    @Test
    public void testGetMonth() {
        String expected = "September";
        String actual = adAstra.getReleaseDate().getMonth();

        assertEquals(expected, actual, "error in getMonth: expected month does not equal actual month");
    }

    @Test
    public void testGetYear() {
        int expected = 2019;
        int actual = adAstra.getReleaseDate().getYear();

        assertEquals(expected, actual, "error in getYear: expected year does not equal actual year");
    }

    @Test
    public void testGetTitle() {
        String expected = "Ad Astra";
        String actual = adAstra.getTitle();

        assertEquals(expected, actual, "error in getTitle: expected title does not equal actual title");
    }

    @Test
    public void testGetLength() {
        int expected = 123;
        int actual = adAstra.getLength();

        assertEquals(expected, actual, "error in getLength: expected length does not equal actual length");
    }

    @Test
    public void testSetReleaseDate() {
        Date newReleaseDate = new Date(10, "June", 1996);
        adAstra.setReleaseDate(newReleaseDate);

        String expected = "10 June 1996";
        String actual = adAstra.getReleaseDate().toString();

        assertEquals(expected, actual, "error in setReleaseDate: expected date does not equal actual date");
    }

    @Test
    public void testMainMethod() {
        Date newReleaseDate = new Date(4, "August", 1996);
        Film myCountry = new Film("My Country", newReleaseDate, 134);
        myCountry.setReleaseDate(new Date(17, "October", 2019));

        boolean expected = true;
        boolean actual = adAstra.getReleaseDate() != myCountry.getReleaseDate();

        assertEquals(expected, actual, "error in main method: expected value does not equal actual value");

        assertTrue(!myCountry.getTitle().equals(adAstra.getTitle()),
                "error in main method: two different films should not have the same title.");

        assertTrue(myCountry.getReleaseDate().getDay() != adAstra.getReleaseDate().getDay(),
                "error in main method: the dates of two films should not be the same");

        assertTrue(myCountry.getReleaseDate().getMonth() != adAstra.getReleaseDate().getMonth(),
                "error in main method: the months of two films should not be the same");

        assertTrue(myCountry.getReleaseDate().getYear() == adAstra.getReleaseDate().getYear(),
                "error in main method: the years of two films should be the same");

    }
}



