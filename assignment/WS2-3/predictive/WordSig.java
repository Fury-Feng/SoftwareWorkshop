package predictive;

/**
 * The WordSig class implements the interface Comparable,
 * the WordSig class is used to pair words and signatures.
 * The WordSig class has two private variables with String
 * type, a constructor, two getters and two setters and a compareTo method.
 *
 * @author: Fuwei Feng
 * @version: 2020/2/8
 */
public class WordSig implements Comparable<WordSig> {

    private String words;
    private String signature;

    /**
     * The constructor is used to create a wordSig object.
     *
     * @param words  The word in the dictionary.
     * @param signature     The signature of the word.
     */
    public WordSig(String words, String signature){

        this.words = words;
        this.signature = signature;

    }

    /**
     * Getter for the words.
     * @return words     The words of the WordSig is return.
     */
    public String getWords() {
        return words;
    }

    /**
     * Setter for the words. The words of the WordSig is updated.
     * @param words     The new word of the WordSig.
     */
    public void setWords(String words) {
        this.words = words;
    }

    /**
     * Getter for the signature.
     * @return signature     The signature of the WordSig is return.
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Setter for the signature. The signature of the WordSig is updated.
     * @param signature     The new signature of the WordSig.
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * The compareTo method returns -1, 0 or 1 according to whether the current object
     * is less than, equal to, or greater than the argument object, in the intended ordering.
     *
     * @param ws   The wordSig object
     * @return -1 or 0 or 1.
     */
    @Override
    public int compareTo(WordSig ws){
        if(this.getSignature().compareTo(ws.getSignature()) < 0){
            return -1;
        } else if(this.getSignature().compareTo(ws.getSignature()) == 0){
            return 0;
        } else {
            return 1;
        }
    }
}
