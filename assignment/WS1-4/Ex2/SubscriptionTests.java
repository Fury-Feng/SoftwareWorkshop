/**
 * The class has 8 tests to test the getters and
 * toString method of the class Subscription and class SubscriptionPrime.
 *
 * @author: Fuwei Feng
 * @version: 2019/11/16
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class SubscriptionTests {

    private SubscriptionInterface subInter;
    private SubscriptionPrimeInterface subPrimeInter;
    private Subscription sub;
    private SubscriptionPrime subPrime;

    @BeforeEach
    public void init() {
        subInter = new Subscription("Times", "furyfeng@sina.com", 5);
        subPrimeInter = new SubscriptionPrime("Vista", "610418875@qq.com", 10, "Pavilion Birmingham");
        sub = new SubscriptionPrime("Reader", "fxf977@student.bham.ac.uk", 3, "Handan China");
        subPrime = new SubscriptionPrime("Daily China", "furyfeng@163.com", 1, "Chengdu China");
    }

    // Testing getters for subInter.
    @Test
    public void test1() {
        String expectedTitle = "Times";
        String expectedEmail = "furyfeng@sina.com";
        int expectedCost = 5;

        String actualTitle = subInter.getTitle();
        String actualEmail = subInter.getEmail();
        int  actualCost = subInter.getCost();

        assertEquals(expectedTitle, actualTitle, "The title should be " + expectedTitle);
        assertEquals(expectedEmail, actualEmail, "The email should be " + expectedEmail);
        assertEquals(expectedCost, actualCost, "The cost should be " + expectedCost);
    }

    // Testing toString method for subInter.
    @Test
    public void test2() {
        String expectedToString = "Subscription: \nTitle : Times\nEmail : furyfeng@sina.com\nCost : 5";

        String actualToString = subInter.toString();

        assertEquals(expectedToString, actualToString);
    }

    // Testing getter for subPrimeInter.
    @Test
    public void test3() {
        String expectedAddress = "Pavilion Birmingham";

        String actualAddress = subPrimeInter.getAddress();

        assertEquals(expectedAddress, actualAddress);
    }

    // Testing toString method for subPrimeInter.
    @Test
    public void test4() {
        String expectedToString = "Subscription: \nTitle : Vista\nEmail : 610418875@qq.com\nCost : 10\nAddress : Pavilion Birmingham";

        String actualToString = subPrimeInter.toString();

        assertEquals(expectedToString, actualToString);
    }

    // Testing getter for sub.
    @Test
    public void test5() {
        String expectedTitle = "Reader";
        String expectedEmail = "fxf977@student.bham.ac.uk";
        int expectedCost = 3;

        String actualTitle = sub.getTitle();
        String actualEmail = sub.getEmail();
        int  actualCost = sub.getCost();

        assertEquals(expectedTitle, actualTitle, "The title should be " + expectedTitle);
        assertEquals(expectedEmail, actualEmail, "The email should be " + expectedEmail);
        assertEquals(expectedCost, actualCost, "The cost should be " + expectedCost);
    }

    // Testing toString for sub.
    @Test
    public void test6() {
        String expectedToString = "Subscription: \nTitle : Reader\nEmail : fxf977@student.bham.ac.uk\nCost : 3\nAddress : Handan China";

        String actualToString = sub.toString();

        assertEquals(expectedToString, actualToString);
    }

    // Testing getter for subPrime.
    @Test
    public void test7() {
        String expectedTitle = "Daily China";
        String expectedEmail = "furyfeng@163.com";
        int expectedCost = 1;
        String expectedAddress = "Chengdu China";

        String actualTitle = subPrime.getTitle();
        String actualEmail = subPrime.getEmail();
        int  actualCost = subPrime.getCost();
        String actualAddress = subPrime.getAddress();

        assertEquals(expectedTitle, actualTitle, "The title should be " + expectedTitle);
        assertEquals(expectedEmail, actualEmail, "The email should be " + expectedEmail);
        assertEquals(expectedCost, actualCost, "The cost should be " + expectedCost);
        assertEquals(expectedAddress, actualAddress, "The address should be " + expectedAddress);
    }

    // Testing toString method for subPrime
    @Test
    public void test8() {
        String expectedToString = "Subscription: \nTitle : Daily China\nEmail : furyfeng@163.com\nCost : 1\nAddress : Chengdu China";

        String actualToString = subPrime.toString();

        assertEquals(expectedToString, actualToString);
    }
}


