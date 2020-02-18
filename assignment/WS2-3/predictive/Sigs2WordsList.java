package predictive;

import java.io.FileNotFoundException;

/**
 * The Sigs2WordsList class is a command-line program for testing the ListDictionary class.
 * The class has a main method.
 * @author: Fuwei Feng
 * @version: 2020/2/8
 */
public class Sigs2WordsList {
    /**
     * The main method call the signatureToWords method of the ListDictionary class,
     * and it execute the command in the args array.
     * The main method is used to get the words that match the given signature.
     *
     * Compare the time: I execute the Sigs2WordsList and Sigs2WordsProto java files with the
     *                   same large inputs, there is noticeable difference.
     *                   Input : 2748474 2479297 7243 48 47 63337464 35394253 732665464 6784667 367 255
     *                   Time1(Sigs2WordsList): 2.44s user 0.22s system 196% cpu 1.352 total
     *                   Time2(Sigs2WordsProto): 5.91s user 0.27s system 121% cpu 5.080 total
     * Explain: The Sigs2WordsProto class only need to find the words of given signature in the dictionary,
     *          and store the matching words in the set. The Sigs2WordsList class need to read and store all the words
     *          from the dictionary in the ArrayList, then find the matching words in the ArrayList.
     *          Therefore, if we only need to find one signature, Sigs2WordsProto is faster,
     *          however, if we find a lot of signatures, Sigs2WordsList is faster.
     *
     * @param args The input signatures need to be transferred.
     */
    public static void main(String[] args) throws FileNotFoundException {

        ListDictionary listDictionary = new ListDictionary("/usr/share/dict/words");
        String regex = "^[2-9]+$";

        for(String arg : args){

            if(arg.matches(regex)){

                System.out.println(arg + " : " + listDictionary.signatureToWords(arg));

            }
        }
    }
}
