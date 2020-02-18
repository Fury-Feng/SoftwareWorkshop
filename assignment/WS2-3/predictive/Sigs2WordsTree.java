package predictive;

import java.io.FileNotFoundException;

/**
 * @author: Fuwei Feng
 * @version: 2020/2/13
 */
public class Sigs2WordsTree {
    /**
     * The main method call the signatureToWords method of the TreeDictionary class,
     * and it execute the command in the args array.
     * The main method is used to get the words that match the given signature.
     *
     * Compare the time: I execute the Sigs2WordsMap and Sigs2WordsTree java files with the
     *                   same large inputs, there is noticeable difference.
     *                   Input : 2748474 2479297 7243 48 47 63337464 35394253 732665464 6784667 367 255
     *                   Time1(Sigs2WordsTree): 3.27s user 0.30s system 280% cpu 1.273 total
     *                   Time2(Sigs2WordsMap):  2.01s user 0.16s system 288% cpu 0.754 total
     * Explain: The Sigs2WordsMap is faster than Sigs2WordsTree.
     *
     * @param args The input signatures need to be transferred.
     */
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/usr/share/dict/words";
        Dictionary dictionary = new TreeDictionary(path);
        String regex = "^[2-9]+$";

        for(String arg : args){

            if(arg.matches(regex)){

                System.out.println(arg + " : " + dictionary.signatureToWords(arg));

            }
        }
    }
}
