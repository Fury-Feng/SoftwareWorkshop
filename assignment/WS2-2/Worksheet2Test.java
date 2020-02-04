package school.secondweek;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


/** @author FUWEI FENG
 * This class contains the test cases for Worksheet2 solutions.
 * The class test all the methods in the Worksheet2 class.
 * The class has 17 test methods.
 */

public class Worksheet2Test {
    // Testing the negateAll method.
    @Test
    public void test1(){
        Tree<Integer> t1 = new Tree<>(1, new Tree<>(2), new Tree<>(3));
        Tree<Integer> t2 = new Tree<>(-1, new Tree<>(-2), new Tree<>(-3));
        Tree<Integer> t3 = new Tree<>(0, new Tree<>(0), new Tree<>(0));
        Tree<Integer> t4 = new Tree<>(1, new Tree<>(0), new Tree<>(-1));
        Tree<Integer> t5 = new Tree<>();

        Tree<Integer> expectedT1 = new Tree<>(-1, new Tree<>(-2), new Tree<>(-3));
        Tree<Integer> expectedT2 = new Tree<>(1, new Tree<>(2), new Tree<>(3));
        Tree<Integer> expectedT3 = new Tree<>(0, new Tree<>(0), new Tree<>(0));
        Tree<Integer> expectedT4 = new Tree<>(-1, new Tree<>(0), new Tree<>(1));
        Tree<Integer> expectedT5 = new Tree<>();

        Tree<Integer> actualT1 = Worksheet2.negateAll(t1);
        Tree<Integer> actualT2 = Worksheet2.negateAll(t2);
        Tree<Integer> actualT3 = Worksheet2.negateAll(t3);
        Tree<Integer> actualT4 = Worksheet2.negateAll(t4);
        Tree<Integer> actualT5 = Worksheet2.negateAll(t5);

        assertEquals(expectedT1, actualT1);
        assertEquals(expectedT2, actualT2);
        assertEquals(expectedT3, actualT3);
        assertEquals(expectedT4, actualT4);
        assertEquals(expectedT5, actualT5);
    }

    // Testing the allEven method.
    @Test
    public void test2(){
        Tree<Integer> t1 = new Tree<>(1, new Tree<>(3), new Tree<>(5));
        Tree<Integer> t2 = new Tree<>(2, new Tree<>(4), new Tree<>(6));
        Tree<Integer> t3 = new Tree<>(0, new Tree<>(0), new Tree<>(0));
        Tree<Integer> t4 = new Tree<>(1, new Tree<>(0), new Tree<>(2));
        Tree<Integer> t5 = new Tree<>();

        assertFalse(Worksheet2.allEven(t1));
        assertTrue(Worksheet2.allEven(t2));
        assertTrue(Worksheet2.allEven(t3));
        assertFalse(Worksheet2.allEven(t4));
        assertTrue(Worksheet2.allEven(t5));
    }

    // Testing the depth method.
    @Test
    public void test3() {
        Tree<Integer> tree = new Tree<>(2, new Tree<>(1), new Tree<>(3));

        int expectedDepth1 = 0;
        int expectedDepth2 = 1;
        int expectedDepth3 = 1;
        int expectedDepth4 = -1;

        int actualDepth1 = Worksheet2.depth(tree, 2);
        int actualDepth2 = Worksheet2.depth(tree, 1);
        int actualDepth3 = Worksheet2.depth(tree, 3);
        int actualDepth4 = Worksheet2.depth(tree, 5);

        assertEquals(expectedDepth1, actualDepth1);
        assertEquals(expectedDepth2, actualDepth2);
        assertEquals(expectedDepth3, actualDepth3);
        assertEquals(expectedDepth4, actualDepth4);
    }

    // Testing the recordDepth method.
    @Test
    public void test4(){
        Tree<Integer> tree = new Tree<>(2, new Tree<>(1), new Tree<>(3));

        int expectedDepth1 = 0;
        int expectedDepth2 = 1;
        int expectedDepth3 = 1;
        int expectedDepth4 = -1;

        int actualDepth1 = Worksheet2.recordDepth(tree, 2, 0);
        int actualDepth2 = Worksheet2.recordDepth(tree, 1, 0);
        int actualDepth3 = Worksheet2.recordDepth(tree, 3, 0);
        int actualDepth4 = Worksheet2.recordDepth(tree, 5, 0);

        assertEquals(expectedDepth1, actualDepth1);
        assertEquals(expectedDepth2, actualDepth2);
        assertEquals(expectedDepth3, actualDepth3);
        assertEquals(expectedDepth4, actualDepth4);
    }

    // Testing the preorder method.
    @Test
    public <E> void test5(){
        Tree<Integer> t1 = new Tree<>(1, new Tree<>(2), new Tree<>(5));
        Tree<String> t2 = new Tree<>("Bob", new Tree<>("Fury"), new Tree<>("Tom"));

        List<Integer> expectedList1 = new List<>(1, new List<>(2, new List<>(5, new List<>())));
        List<String> expectedList2 = new List<>("Bob", new List<>("Fury", new List<>("Tom", new List<>())));

        List<Integer> actualList1 = Worksheet2.preorder(t1);
        List<String> actualList2 = Worksheet2.preorder(t2);

        assertEquals(expectedList1, actualList1);
        assertEquals(expectedList2, actualList2);
    }

    // Testing the append method.
    @Test
    public <E> void test6(){
        List<Integer> list1 = new List<>(1, new List<>(2, new List<>(3, new List<>())));
        List<Integer> list2 = new List<>(4, new List<>(5, new List<>(6, new List<>())));
        List<Integer> list3 = new List<>();

        List<Integer> expectedList1 = new List<>(1, new List<>(2, new List<>(3, new List<>(4, new List<>(5, new List<>(6, new List<>()))))));
        List<Integer> expectedList2 = new List<>(1, new List<>(2, new List<>(3, new List<>())));

        List<Integer> actualList1 = Worksheet2.append(list1, list2);
        List<Integer> actualList2 = Worksheet2.append(list1, list3);

        assertEquals(expectedList1, actualList1);
        assertEquals(expectedList2, actualList2);
    }

    // Testing the isSearchTree method.
    @Test
    public void test7(){
        Tree<Integer> t1 = new Tree<>(10, new Tree<>(5, new Tree<>(2), new Tree<>(7)), new Tree<>(15, new Tree<>(13), new Tree<>(17)));
        Tree<Integer> t2 = new Tree<>(10, new Tree<>(5, new Tree<>(7), new Tree<>(2)), new Tree<>(15, new Tree<>(13), new Tree<>(17)));
        Tree<Integer> t3 = new Tree<>();

        assertTrue(Worksheet2.isSearchTree(t1));
        assertFalse(Worksheet2.isSearchTree(t2));
        assertTrue(Worksheet2.isSearchTree(t3));
    }

    // Testing the helpSearchTree method.
    @Test
    public void test8(){
        Tree<Integer> t1 = new Tree<>(10, new Tree<>(5, new Tree<>(2), new Tree<>(7)), new Tree<>(15, new Tree<>(13), new Tree<>(17)));
        Tree<Integer> t2 = new Tree<>(10, new Tree<>(5, new Tree<>(7), new Tree<>(2)), new Tree<>(15, new Tree<>(13), new Tree<>(17)));
        Tree<Integer> t3 = new Tree<>();

        assertTrue(Worksheet2.helpSearchTree(t1, Integer.MIN_VALUE, Integer.MAX_VALUE));
        assertFalse(Worksheet2.helpSearchTree(t2, Integer.MIN_VALUE, Integer.MAX_VALUE));
        assertTrue(Worksheet2.helpSearchTree(t3, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    // Testing the max method.
    @Test
    public void test9(){
        Tree<Integer> t1 = new Tree<>(10, new Tree<>(5, new Tree<>(2), new Tree<>(7)), new Tree<>(15, new Tree<>(13), new Tree<>(17)));
        Tree<Integer> t2 = new Tree<>();
        Tree<Integer> t3 = new Tree<>(3, new Tree<>(2), new Tree<>());

        int expectedMax1 = 17;
        int expectedMax2 = -1;
        int expectedMax3 = 3;

        int actualMax1 = Worksheet2.max(t1);
        int actualMax2 = Worksheet2.max(t2);
        int actualMax3 = Worksheet2.max(t3);

        assertEquals(expectedMax1, actualMax1);
        assertEquals(expectedMax2, actualMax2);
        assertEquals(expectedMax3, actualMax3);
    }

    // Testing the delete method.
    @Test
    public void test10(){
        Tree<Integer> t1 = new Tree<>(5, new Tree<>(3, new Tree<>(2), new Tree<>(4)), new Tree<>(6));
        Tree<Integer> t2 = new Tree<>(5, new Tree<>(3, new Tree<>(2), new Tree<>()), new Tree<>(6));
        Tree<Integer> t3 = new Tree<>(5, new Tree<>(3, new Tree<>(), new Tree<>(4)), new Tree<>(6));

        Tree<Integer> expectedT1 = new Tree<>(5, new Tree<>(2, new Tree<>(), new Tree<>(4)), new Tree<>(6));
        Tree<Integer> expectedT2 = new Tree<>(5, new Tree<>(2, new Tree<>(), new Tree<>()), new Tree<>(6));
        Tree<Integer> expectedT3 = new Tree<>(5, new Tree<>(4, new Tree<>(), new Tree<>()), new Tree<>(6));
        Tree<Integer> expectedT4 = new Tree<>(5, new Tree<>(3, new Tree<>(), new Tree<>(4)), new Tree<>(6));
        Tree<Integer> expectedT5 = new Tree<>(5, new Tree<>(3, new Tree<>(2), new Tree<>()), new Tree<>(6));
        Tree<Integer> expectedT6 = new Tree<>(5, new Tree<>(3, new Tree<>(2), new Tree<>(4)), new Tree<>());
        Tree<Integer> expectedT7 = new Tree<>(4, new Tree<>(3, new Tree<>(2), new Tree<>()), new Tree<>(6));

        Tree<Integer> actualT1 = Worksheet2.delete(t1, 3);
        Tree<Integer> actualT2 = Worksheet2.delete(t2, 3);
        Tree<Integer> actualT3 = Worksheet2.delete(t3, 3);
        Tree<Integer> actualT4 = Worksheet2.delete(t1, 2);
        Tree<Integer> actualT5 = Worksheet2.delete(t1, 4);
        Tree<Integer> actualT6 = Worksheet2.delete(t1, 6);
        Tree<Integer> actualT7 = Worksheet2.delete(t1, 5);

        assertEquals(expectedT1, actualT1);
        assertEquals(expectedT2, actualT2);
        assertEquals(expectedT3, actualT3);
        assertEquals(expectedT4, actualT4);
        assertEquals(expectedT5, actualT5);
        assertEquals(expectedT6, actualT6);
        assertEquals(expectedT7, actualT7);
    }

    // Testing the isHeightBalanced method.
    @Test
    public void test11(){
        Tree<Integer> t1 = new Tree<>(5, new Tree<>(3), new Tree<>(6));
        Tree<Integer> t2 = new Tree<>(5, new Tree<>(3, new Tree<>(2), new Tree<>()), new Tree<>(6));
        Tree<Integer> t3 = new Tree<>(5, new Tree<>(3), new Tree<>(6, new Tree<>(7), new Tree<>()));
        Tree<Integer> t4 = new Tree<>(5, new Tree<>(3), new Tree<>(6, new Tree<>(7, new Tree<>(), new Tree<>(9)), new Tree<>()));
        Tree<Integer> t5 = new Tree<>(5, new Tree<>(3, new Tree<>(2, new Tree<>(1), new Tree<>()), new Tree<>()), new Tree<>(6));
        Tree<Integer> t6 = new Tree<>();

        assertTrue(Worksheet2.isHeightBalanced(t1));
        assertTrue(Worksheet2.isHeightBalanced(t2));
        assertTrue(Worksheet2.isHeightBalanced(t3));
        assertFalse(Worksheet2.isHeightBalanced(t4));
        assertFalse(Worksheet2.isHeightBalanced(t5));
        assertTrue(Worksheet2.isHeightBalanced(t6));
    }

    // Testing the rotateRight method.
    @Test
    public void test12(){
        Tree<Integer> t1 = new Tree<>(3, new Tree<>(2, new Tree<>(1), new Tree<>()), new Tree<>());
        Tree<Integer> t2 = new Tree<>(10, new Tree<>(5, new Tree<>(2, new Tree<>(1), new Tree<>(3)), new Tree<>(6)), new Tree<>(15));

        Tree<Integer> expectedT1 = new Tree<>(2, new Tree<>(1), new Tree<>(3));
        Tree<Integer> expectedT2 = new Tree<>(5, new Tree<>(2, new Tree<>(1), new Tree<>(3)), new Tree<>(10, new Tree<>(6), new Tree<>(15)));

        Tree<Integer> actualT1 = Worksheet2.rotateRight(t1);
        Tree<Integer> actualT2 = Worksheet2.rotateRight(t2);

        assertEquals(expectedT1, actualT1);
        assertEquals(expectedT2, actualT2);
    }

    // Testing the rotateLeft method.
    @Test
    public void test13(){
        Tree<Integer> t1 = new Tree<>(3, new Tree<>(), new Tree<>(4, new Tree<>(), new Tree<>(5)));
        Tree<Integer> t2 = new Tree<>(10, new Tree<>(9), new Tree<>(15, new Tree<>(13), new Tree<>(17, new Tree<>(16), new Tree<>(18))));

        Tree<Integer> expectedT1 = new Tree<>(4, new Tree<>(3), new Tree<>(5));
        Tree<Integer> expectedT2 = new Tree<>(15, new Tree<>(10, new Tree<>(9), new Tree<>(13)), new Tree<>(17, new Tree<>(16), new Tree<>(18)));

        Tree<Integer> actualT1 = Worksheet2.rotateLeft(t1);
        Tree<Integer> actualT2 = Worksheet2.rotateLeft(t2);

        assertEquals(expectedT1, actualT1);
        assertEquals(expectedT2, actualT2);
    }

    // Testing the rotateLR method.
    @Test
    public void test14(){
        Tree<Integer> t1 = new Tree<>(3, new Tree<>(1, new Tree<>(), new Tree<>(2)), new Tree<>());
        Tree<Integer> t2 = new Tree<>(10, new Tree<>(5, new Tree<>(4), new Tree<>(7, new Tree<>(6), new Tree<>(8))), new Tree<>(11));

        Tree<Integer> expectedT1 = new Tree<>(2, new Tree<>(1), new Tree<>(3));
        Tree<Integer> expectedT2 = new Tree<>(7, new Tree<>(5, new Tree<>(4), new Tree<>(6)), new Tree<>(10, new Tree<>(8), new Tree<>(11)));

        Tree<Integer> actualT1 = Worksheet2.rotateLR(t1);
        Tree<Integer> actualT2 = Worksheet2.rotateLR(t2);

        assertEquals(expectedT1, actualT1);
        assertEquals(expectedT2, actualT2);
    }

    // Testing the rotateRL method.
    @Test
    public void test15(){
        Tree<Integer> t1 = new Tree<>(3, new Tree<>(), new Tree<>(5, new Tree<>(4), new Tree<>()));
        Tree<Integer> t2 = new Tree<>(10, new Tree<>(9), new Tree<>(15, new Tree<>(13, new Tree<>(11), new Tree<>(14)), new Tree<>(16)));

        Tree<Integer> expectedT1 = new Tree<>(4, new Tree<>(3), new Tree<>(5));
        Tree<Integer> expectedT2 = new Tree<>(13, new Tree<>(10, new Tree<>(9), new Tree<>(11)), new Tree<>(15, new Tree<>(14), new Tree<>(16)));

        Tree<Integer> actualT1 = Worksheet2.rotateRL(t1);
        Tree<Integer> actualT2 = Worksheet2.rotateRL(t2);

        assertEquals(expectedT1, actualT1);
        assertEquals(expectedT2, actualT2);
    }

    // Testing the insertHB method.
    @Test
    public void test16(){
        Tree<Integer> t1 = new Tree<>(10, new Tree<>(5, new Tree<>(3), new Tree<>()), new Tree<>(15));
        Tree<Integer> t2 = new Tree<>(10, new Tree<>(5), new Tree<>(15, new Tree<>(), new Tree<>(20)));

        Tree<Integer> expectedT1 = new Tree<>(10, new Tree<>(3, new Tree<>(2), new Tree<>(5)), new Tree<>(15));
        Tree<Integer> expectedT2 = new Tree<>(10, new Tree<>(4, new Tree<>(3), new Tree<>(5)), new Tree<>(15));
        Tree<Integer> expectedT3 = new Tree<>(10, new Tree<>(5), new Tree<>(20, new Tree<>(15), new Tree<>(21)));
        Tree<Integer> expectedT4 = new Tree<>(10, new Tree<>(5), new Tree<>(19, new Tree<>(15), new Tree<>(20)));

        Tree<Integer> actualT1 = Worksheet2.insertHB(t1, 2);
        Tree<Integer> actualT2 = Worksheet2.insertHB(t1, 4);
        Tree<Integer> actualT3 = Worksheet2.insertHB(t2, 21);
        Tree<Integer> actualT4 = Worksheet2.insertHB(t2, 19);

        assertEquals(expectedT1, actualT1);
        assertEquals(expectedT2, actualT2);
        assertEquals(expectedT3, actualT3);
        assertEquals(expectedT4, actualT4);
    }

    // Testing the deleteHB method.
    @Test
    public void test17(){
        Tree<Integer> t1 = new Tree<>(10, new Tree<>(3, new Tree<>(2), new Tree<>()), new Tree<>(15));
        Tree<Integer> t2 = new Tree<>(10, new Tree<>(3, new Tree<>(), new Tree<>(5)), new Tree<>(15));
        Tree<Integer> t3 = new Tree<>(10, new Tree<>(3, new Tree<>(2), new Tree<>(5)), new Tree<>(15));
        Tree<Integer> t4 = new Tree<>(10, new Tree<>(3), new Tree<>(15, new Tree<>(), new Tree<>(20)));
        Tree<Integer> t5 = new Tree<>(10, new Tree<>(3), new Tree<>(15, new Tree<>(14), new Tree<>()));
        Tree<Integer> t6 = new Tree<>(10, new Tree<>(3), new Tree<>(15, new Tree<>(14), new Tree<>(20)));

        Tree<Integer> expectedT1 = new Tree<Integer>(3, new Tree<>(2), new Tree<>(10));
        Tree<Integer> expectedT2 = new Tree<Integer>(5, new Tree<>(3), new Tree<>(10));
        Tree<Integer> expectedT3 = new Tree<Integer>(3, new Tree<>(2), new Tree<>(10, new Tree<>(5), new Tree<>()));
        Tree<Integer> expectedT4 = new Tree<Integer>(15, new Tree<>(10), new Tree<>(20));
        Tree<Integer> expectedT5 = new Tree<Integer>(14, new Tree<>(10), new Tree<>(15));
        Tree<Integer> expectedT6 = new Tree<Integer>(15, new Tree<>(10, new Tree<>(), new Tree<>(14)), new Tree<>(20));

        Tree<Integer> actualT1 = Worksheet2.deleteHB(t1, 15);
        Tree<Integer> actualT2 = Worksheet2.deleteHB(t2, 15);
        Tree<Integer> actualT3 = Worksheet2.deleteHB(t3, 15);
        Tree<Integer> actualT4 = Worksheet2.deleteHB(t4, 3);
        Tree<Integer> actualT5 = Worksheet2.deleteHB(t5, 3);
        Tree<Integer> actualT6 = Worksheet2.deleteHB(t6, 3);

        assertEquals(expectedT1, actualT1);
        assertEquals(expectedT2, actualT2);
        assertEquals(expectedT3, actualT3);
        assertEquals(expectedT4, actualT4);
        assertEquals(expectedT5, actualT5);
        assertEquals(expectedT6, actualT6);
    }
}
