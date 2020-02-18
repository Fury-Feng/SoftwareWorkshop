package predictive;

import java.io.FileNotFoundException;

/**
 * The Sigs2WordsMap class is a command-line program for testing the MapDictionary class.
 * The class has a main method.
 *
 * @author: Fuwei Feng
 * @version: 2020/2/12
 */
public class Sigs2WordsMap {
    /**
     * The main method call the signatureToWords method of the class MapDictionary,
     * and it execute the command in the args array.
     * The main method is used to change the given signatures(args) to the words.
     *
     * @param args The input signature need to be transferred.
     */
    public static void main(String[] args) throws FileNotFoundException {

        String path = "/usr/share/dict/words";
        Dictionary dictionary = new MapDictionary(path);
        String regex = "^[2-9]+$";

        for(String arg : args){

            if(arg.matches(regex)){

                System.out.println(arg + " : " + dictionary.signatureToWords(arg));

            }
        }
    }
}
