package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author: Fuwei Feng
 * @version: 2020/2/7
 *
 * The PredictivePrototype class is used to building a “prototype” for the predictive text problem.
 * The PredictivePrototype class contains a wordToSignature method, a signatureToWord method, an isValidWord method.
 * These methods are all static methods.
 */
public class PredictivePrototype {

    /**
     * The wordToSignature method is used to take a word and returns a numeric signature.
     * For example, "home" should return "4663". If the word has any non-alphabetic characters,
     * replace them with a " "(space) in the resulting signature.
     *
     * Explain: The String class uses "+"(plus) method, every time the plus method is used the class need to
     *          create a new object, this solution will take up a lot of memory.
     *          However, the StringBuffer class create a StringBuffer object,the
     *          StringBuffer object is a variable-length object.
     *          When you add or delete a StringBuffer, you don't need to create an object,
     *          and you can dynamically modify the heap memory.
     *
     * @param word      The word needs to be transferred to a signature.
     * @return the signature of the word.
     */
    public static String wordToSignature(String word){

        StringBuffer text = new StringBuffer(word.toLowerCase());
        StringBuffer reText = new StringBuffer();
        // The wordList is used to store the character in the word.
        ArrayList<Character> wordList = new ArrayList<>();

        for(int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);
            wordList.add(c);

        }

        for(char c : wordList){

            if(c == 'a' || c == 'b' || c == 'c' ){
                reText.append(2);
            } else if(c == 'd' || c == 'e' || c == 'f' ){
                reText.append(3);
            } else if(c == 'g' || c == 'h' || c == 'i' ){
                reText.append(4);
            } else if(c == 'j' || c == 'k' || c == 'l' ){
                reText.append(5);
            } else if(c == 'm' || c == 'n' || c == 'o' ){
                reText.append(6);
            } else if(c == 'p' || c == 'q' || c == 'r' || c == 's'){
                reText.append(7);
            } else if(c == 't' || c == 'u' || c == 'v' ){
                reText.append(8);
            } else if(c == 'w' || c == 'x' || c == 'y' || c == 'z'){
                reText.append(9);
            } else {
                reText.append(" ");
            }

        }

        return reText.toString();

    }

    /**
     * The signatureToWords method is used to take the given numeric signature and returns
     * a set of possible matching words from the dictionary. The returned list must not have duplicates
     * and each word should be in lower-case.
     *
     * @param signature the signature need to be transferred.
     * @return wordSet  The set that contains the matching words.
     * @throws FileNotFoundException if the file is not found throw the exception.
     */
    public static Set<String> signatureToWords(String signature) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("/usr/share/dict/words"));
        Set<String> wordSet = new HashSet<>();

        while(scanner.hasNext()){

            String nextWord = scanner.nextLine().toLowerCase();

            if(isValidWord(nextWord)){

                if(signature.equals(wordToSignature(nextWord))){

                    if(!wordSet.contains(nextWord)){

                        wordSet.add(nextWord);

                    }
                }
            }
        }

        return wordSet;

    }

    /**
     * The isValidWord method is used to check if a given word is valid.
     * When reading the dictionary, ignore lines with non-alphabetic characters.
     *
     * @param word the word need to be checked.
     * @return true(if the word is valid) or false(if the word is not valid)
     */
    static boolean isValidWord(String word){

        String regex = "^[a-zA-Z]+$";
        return word.matches(regex);

    }
}
