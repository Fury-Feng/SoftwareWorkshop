import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;



/** @author 
 *  FUWEI FENG
 * This class contains the test cases for Worksheet1 solutions.
 * The class test all the methods in the Worksheet1 class.
 * The class has 9 test methods.
 */

public class Worksheet1Test {

    // Testing the power method
    @Test
	public void test1() {
        int expectedResult1 = 1;
        int expectedResult2 = 0;
        int expectedResult3 = 8;

        int actualResult1 = Worksheet1.power(2,0);
        int actualResult2 = Worksheet1.power(0,123);
        int actualResult3 = Worksheet1.power(2,3);

        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
        assertEquals(expectedResult3, actualResult3);
    }

    // Testing the fastPower method
    @Test
    public void test2(){
        int expectedResult1 = 1;
        int expectedResult2 = 0;
        int expectedResult3 = 27;
        int expectedResult4 = 9;

        int actualResult1 = Worksheet1.fastPower(3, 0);
        int actualResult2 = Worksheet1.fastPower(0, 3);
        int actualResult3 = Worksheet1.fastPower(3, 3);
        int actualResult4 = Worksheet1.fastPower(3, 2);

        assertEquals(expectedResult1, actualResult1);
        assertEquals(expectedResult2, actualResult2);
        assertEquals(expectedResult3, actualResult3);
        assertEquals(expectedResult4, actualResult4);
    }

    // Testing the negateAll method
    @Test
    public void test3() {
        // list1 is [1, 2, 3, 4]
        List<Integer> list1 = new List<>(1, new List<>(2, new List<>(3, new List<>(4, new List<>()))));
        // list2 is [-1, -2, -3, -4]
        List<Integer> list2 = new List<>(-1, new List<>(-2, new List<>(-3, new List<>(-4, new List<>()))));
        // list3 is [0, 0, 0 ,0]
        List<Integer> list3 = new List<>(0, new List<>(0, new List<>(0, new List<>(0, new List<>()))));
        // list4 is [0, 1, 2, -3]
        List<Integer> list4 = new List<>(0, new List<>(1, new List<>(2, new List<>(-3, new List<>()))));
        // list5 is []
        List<Integer> list5 = new List<>();

        List<Integer> expectedList1 = new List<>(-1, new List<>(-2, new List<>(-3, new List<>(-4, new List<>()))));
        List<Integer> expectedList2 = new List<>(1, new List<>(2, new List<>(3, new List<>(4, new List<>()))));
        List<Integer> expectedList3 = new List<>(0, new List<>(0, new List<>(0, new List<>(0, new List<>()))));
        List<Integer> expectedList4 = new List<>(0, new List<>(-1, new List<>(-2, new List<>(3, new List<>()))));
        List<Integer> expectedList5 = new List<>();

        List<Integer> actualList1 = Worksheet1.negateAll(list1);
        List<Integer> actualList2 = Worksheet1.negateAll(list2);
        List<Integer> actualList3 = Worksheet1.negateAll(list3);
        List<Integer> actualList4 = Worksheet1.negateAll(list4);
        List<Integer> actualList5 = Worksheet1.negateAll(list5);

        assertEquals(expectedList1, actualList1);
        assertEquals(expectedList2, actualList2);
        assertEquals(expectedList3, actualList3);
        assertEquals(expectedList4, actualList4);
        assertEquals(expectedList5, actualList5);
    }

    // Testing the find method
    @Test
    public void test4() {
        List<Integer> list = new List<>(8, new List<Integer>(9, new List<>(0, new List<>(-3, new List<>()))));

        int expectedIndex1 = 0;
        int expectedIndex2 = 2;
        int expectedIndex3 = 3;

        int actualIndex1 = Worksheet1.find(8, list);
        int actualIndex2 = Worksheet1.find(0, list);
        int actualIndex3 = Worksheet1.find(-3, list);

        assertEquals(expectedIndex1, actualIndex1);
        assertEquals(expectedIndex2, actualIndex2);
        assertEquals(expectedIndex3, actualIndex3);

        assertThrows(IllegalArgumentException.class, () -> {
            Worksheet1.find(1, list);
        });
    }

    // Testing the allEven method
    @Test
    public void test5() {
        List<Integer> list1 = new List<>(2, new List<>(4, new List<>(6, new List<>(0, new List<>()))));
        List<Integer> list2 = new List<>(1, new List<>(3, new List<>(5, new List<>(7, new List<>()))));
        List<Integer> list3 = new List<>(2, new List<>(4, new List<>(6, new List<>(5, new List<>()))));
        List<Integer> list4 = new List<>();

        boolean expectedBool1 = true;
        boolean expectedBool2 = false;
        boolean expectedBool3 = false;
        boolean expectedBool4 = true;

        boolean actualBool1 = Worksheet1.allEven(list1);
        boolean actualBool2 = Worksheet1.allEven(list2);
        boolean actualBool3 = Worksheet1.allEven(list3);
        boolean actualBool4 = Worksheet1.allEven(list4);

        assertEquals(expectedBool1, actualBool1);
        assertEquals(expectedBool2, actualBool2);
        assertEquals(expectedBool3, actualBool3);
        assertEquals(expectedBool4, actualBool4);
    }

    // Testing the evenNumbers method
    @Test
    public void test6() {
        List<Integer> list1 = new List<>(2, new List<>(0, new List<>(-2, new List<>())));
        List<Integer> list2 = new List<>(4, new List<>(1, new List<>(-2, new List<>())));
        List<Integer> list3 = new List<>(1, new List<>(3, new List<>(5, new List<>())));
        List<Integer> list4 = new List<>();

        List<Integer> expectedList1 = new List<>(2, new List<>(0, new List<>(-2, new List<>())));
        List<Integer> expectedList2 = new List<>(4, new List<>(-2, new List<>()));
        List<Integer> expectedList3 = new List<>();
        List<Integer> expectedList4 = new List<>();

        List<Integer> actualList1 = Worksheet1.evenNumbers(list1);
        List<Integer> actualList2 = Worksheet1.evenNumbers(list2);
        List<Integer> actualList3 = Worksheet1.evenNumbers(list3);
        List<Integer> actualList4 = Worksheet1.evenNumbers(list4);


        assertEquals(expectedList1, actualList1);
        assertEquals(expectedList2, actualList2);
        assertEquals(expectedList3, actualList3);
        assertEquals(expectedList4, actualList4);
    }

    // Testing the sorted method
    @Test
    public void test7() {
        List<Integer> list1 = new List<>(9, new List<>(8, new List<>(7, new List<>(6, new List<>()))));
        List<Integer> list2 = new List<>(9, new List<>(8, new List<>(8, new List<>(5, new List<>()))));
        List<Integer> list3 = new List<>(6, new List<>(7, new List<>(8, new List<>(9, new List<>()))));
        List<Integer> list4 = new List<>(5, new List<>(3, new List<>(4, new List<>(0, new List<>()))));
        List<Integer> list5 = new List<>();

        boolean expectedBool1 = true;
        boolean expectedBool2 = true;
        boolean expectedBool3 = false;
        boolean expectedBool4 = false;
        boolean expectedBool5 = true;

        boolean actualBool1 = Worksheet1.sorted(list1);
        boolean actualBool2 = Worksheet1.sorted(list2);
        boolean actualBool3 = Worksheet1.sorted(list3);
        boolean actualBool4 = Worksheet1.sorted(list4);
        boolean actualBool5 = Worksheet1.sorted(list5);

        assertEquals(expectedBool1, actualBool1);
        assertEquals(expectedBool2, actualBool2);
        assertEquals(expectedBool3, actualBool3);
        assertEquals(expectedBool4, actualBool4);
        assertEquals(expectedBool5, actualBool5);
    }

    // Testing the merge method
    @Test
    public void test8() {
        List<Integer> list1 = new List<>(8, new List<>(5, new List<>(5, new List<>(2, new List<>()))));
        List<Integer> list2 = new List<>(9, new List<>(8, new List<>(7, new List<>(5, new List<>()))));
        List<Integer> list3 = new List<>();

        List<Integer> expectedList1 = new List<>(9, new List<>(8, new List<>(8, new List<>(7, new List<>(5, new List<>(5, new List<>(5, new List<>(2, new List<>()))))))));
        List<Integer> expectedList2 = list1;
        List<Integer> expectedList3 = list2;

        List<Integer> actualList1 = Worksheet1.merge(list1, list2);
        List<Integer> actualList2 = Worksheet1.merge(list1, list3);
        List<Integer> actualList3 = Worksheet1.merge(list2, list3);

        assertEquals(expectedList1, actualList1);
        assertEquals(expectedList2, actualList2);
        assertEquals(expectedList3, actualList3);
    }

    // Testing the removeDuplicates method
    @Test
    public void test9() {
        List<Integer> list1 = new List<>(9, new List<>(8, new List<>(8, new List<>(7, new List<>(5, new List<>(5, new List<>(5, new List<>(2, new List<>()))))))));
        List<Integer> list2 = new List<>();

        List<Integer> expectedList1 = new List<>(9, new List<>(8, new List<>(7, new List<>(5, new List<>(2, new List<>())))));
        List<Integer> expectedList2 = new List<>();

        List<Integer> actualList1 = Worksheet1.removeDuplicates(list1);
        List<Integer> actualList2 = Worksheet1.removeDuplicates(list2);

        assertEquals(expectedList1, actualList1);
        assertEquals(expectedList2, actualList2);
    }
}


