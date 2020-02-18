package predictive;
/**
 * The Words2SigProto class is used to call the wordToSignature method
 * in the PredictivePrototype class. The class contains a main method.
 *
 * @author: Fuwei Feng
 * @version: 2020/2/8
 */
public class Words2SigProto {
    /**
     * The main method call the wordToSignature method, and it execute the command in the args array.
     * The main method is used to change the given words(args) to the signatures.
     *
     * @param args The input words need to be transferred.
     */
    public static void main(String[] args) {

        for(String arg : args){

            if(PredictivePrototype.isValidWord(arg)){

                System.out.println(arg + " : " + PredictivePrototype.wordToSignature(arg));

            }
        }
    }
}
