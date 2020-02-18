package predictive;

import java.io.FileNotFoundException;

/**
 * The Sigs2WordsProto class is used to call the signatureToWords method
 * in the PredictivePrototype class. The class contains a main method.
 *
 * @author: Fuwei Feng
 * @version: 2020/2/8
 */
public class Sigs2WordsProto {
    /**
     * The main method call the signatureToWords method,
     * and it execute the command in the args array.
     * The main method is used to change the given signatures(args) to the words.
     *
     * @param args The input signature need to be transferred.
     */
    public static void main(String[] args) throws FileNotFoundException {

        String regex = "^[2-9]+$";

        for(String arg : args){

            if(arg.matches(regex)){

                System.out.println(arg + " : " + PredictivePrototype. signatureToWords(arg));

            }
        }
    }
}
