package predictive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class contains the tests for the PredictivePrototype class, WordSig class, MapDictionary class, TreeDictionary class and the ListDictionary class.
 * The test class contains 7 test methods.
 * @author: Fuwei Feng
 * @version: 2020/2/9
 */
public class PredictiveTest {

    private final static String PATH = "/usr/share/dict/words";

    ListDictionary listDictionary;
    MapDictionary mapDictionary;
    TreeDictionary treeDictionary;

    @BeforeEach
    void setUp(){
        try {
            listDictionary = new ListDictionary(PATH);
            mapDictionary = new MapDictionary(PATH);
            treeDictionary = new TreeDictionary(PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    // Test for the wordToSignature method in PredictivePrototype class
    @Test
    public void test1(){
        String word1 = "hello";
        String word2 = "1234";
        String word3 = "&*%$";
        String word4 = "HELLO";
        String word5 = "he112";
        String word6 = "h^&%e";

        String expected1 = "43556";
        String expected2 = "    ";
        String expected3 = "    ";
        String expected4 = "43556";
        String expected5 = "43   ";
        String expected6 = "4   3";

        String actual1 = PredictivePrototype.wordToSignature(word1);
        String actual2 = PredictivePrototype.wordToSignature(word2);
        String actual3 = PredictivePrototype.wordToSignature(word3);
        String actual4 = PredictivePrototype.wordToSignature(word4);
        String actual5 = PredictivePrototype.wordToSignature(word5);
        String actual6 = PredictivePrototype.wordToSignature(word6);

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
        assertEquals(expected6, actual6);
    }

    // Test the signatureToWords method in PredictivePrototype class.
    @Test
    public void test2() throws FileNotFoundException {
        String signature1 = "43556";
        String signature2 = "43we*";

        Set<String> expectedSet1 = new HashSet<>();
        expectedSet1.add("gekko");
        expectedSet1.add("hello");
        Set<String> expectedSet2 = new HashSet<>();

        Set<String> actualSet1 = PredictivePrototype.signatureToWords(signature1);
        Set<String> actualSet2 = PredictivePrototype.signatureToWords(signature2);

        assertEquals(expectedSet1, actualSet1);
        assertEquals(expectedSet2, actualSet2);
    }

    // Test the isValidWord method in the PredictivePrototype class
    @Test
    public void test3(){
        String word1 = "abc";
        String word2 = "123";
        String word3 = "^&*";
        String word4 = "a12";
        String word5 = "a&^";
        String word6 = "a&1";
        String word7 = "ABC";

        assertTrue(PredictivePrototype.isValidWord(word1));
        assertFalse(PredictivePrototype.isValidWord(word2));
        assertFalse(PredictivePrototype.isValidWord(word3));
        assertFalse(PredictivePrototype.isValidWord(word4));
        assertFalse(PredictivePrototype.isValidWord(word5));
        assertFalse(PredictivePrototype.isValidWord(word6));
        assertTrue(PredictivePrototype.isValidWord(word7));
    }

    // Test the compareTo method in the WordSig class
    @Test
    public void test4(){
        WordSig wordSig = new WordSig("", "2234");
        WordSig compareWord1 = new WordSig("", "2244");
        WordSig compareWord2 = new WordSig("", "2234");
        WordSig compareWord3 = new WordSig("", "2222");

        int expected1 = -1;
        int expected2 = 0;
        int expected3 = 1;

        int actual1 = wordSig.compareTo(compareWord1);
        int actual2 = wordSig.compareTo(compareWord2);
        int actual3 = wordSig.compareTo(compareWord3);

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    // Test the signatureToWords method in the ListDictionary class.
    @Test
    public void test5() throws FileNotFoundException {
        Set<String> expected1 = new HashSet<>();
        expected1.add("hello");
        expected1.add("gekko");

        Set<String> unexpected1 = new HashSet<>();
        expected1.add("gekko");
        expected1.add("hello");

        Set<String> expected2 = new HashSet<>();
        expected2.add("ce");
        expected2.add("ad");
        expected2.add("be");
        expected2.add("ae");

        Set<String> actual1 = listDictionary.signatureToWords("43556");
        Set<String> actual2 = listDictionary.signatureToWords("23");

        assertEquals(expected1, actual1);
        assertNotEquals(unexpected1, actual1);
        assertEquals(expected2, actual2);

    }

    // Test the signatureToWords method in the MapDictionary class.
    @Test
    public void test6(){
        Set<String> expected1 = new HashSet<>();
        expected1.add("gekko");
        expected1.add("hello");

        Set<String> expected2 = new HashSet<>();
        expected2.add("ce");
        expected2.add("ad");
        expected2.add("be");
        expected2.add("ae");

        Set<String> actual1 = mapDictionary.signatureToWords("43556");
        Set<String> actual2 = mapDictionary.signatureToWords("23");

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    // Test the signatureToWords method in the TreeDictionary class.
    @Test
    public void test7(){
        Set<String> expected1 = new HashSet<>();
        expected1.add("gekkonidae");
        expected1.add("gekkonid");
        expected1.add("hellness");
        expected1.add("gekkones");
        expected1.add("gekko");
        expected1.add("hello");
        expected1.add("gekkonoid");
        expected1.add("gekkota");

        Set<String> actual1 = treeDictionary.signatureToWords("43556");

        assertEquals(expected1, actual1);
    }
}