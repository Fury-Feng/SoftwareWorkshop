package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * The class ListDictionary implements the interface Dictionary.
 * The class has an ArrayList named list with the type of WordSig,
 * a constructor, a signatureToWords method, a wordToSignature method.
 *
 * @author: Fuwei Feng
 * @version: 2020/2/8
 */
public class ListDictionary implements Dictionary {

    ArrayList<WordSig> list;

    /**
     * The ListDictionary constructor takes a String path to the dictionary, reads stores it in an ArrayList.
     * The ArrayList need to be sorted.
     *
     * @param path  The path of the dictionary need to be stored.
     * @throws FileNotFoundException if the dictionary file is not found.
     */
    public ListDictionary(String path) throws FileNotFoundException {

        list = new ArrayList<>();
        Scanner scanner = new Scanner(new File(path));
        String regex = "^[a-zA-Z]+$";

        while (scanner.hasNext()){

            String word = scanner.nextLine().toLowerCase();

            if(word.matches(regex)){

                WordSig wordSig = new WordSig(word, wordToSignature(word));
                list.add(wordSig);

            }
        }
        // sort the list
        Collections.sort(list);
    }

    /**
     * The signatureToWords method is an instance method. The method is used to return the set
     * that contains the words of the signature.
     *
     * @param signature the signature need to be used to get the words.
     * @return the set of the words.
     */
    @Override
    public Set<String> signatureToWords(String signature) {

        Set<String> wordSet = new HashSet<>();
        int originIndex = Collections.binarySearch(list, new WordSig("", signature));
        int firstIndex = originIndex;
        int lastIndex = originIndex;

        if(originIndex >= 0){

            while(firstIndex >= 0){

                if(list.get(firstIndex).getSignature().equals(signature)){
                    wordSet.add(list.get(firstIndex).getWords());
                }
                firstIndex--;

            }

            while(lastIndex < list.size() - 1){

                if(list.get(lastIndex + 1).getSignature().equals(signature)){
                    wordSet.add(list.get(lastIndex + 1).getWords());
                }
                lastIndex++;

            }
        }
        return wordSet;
    }

    /**
     * The wordToSignature method re-use the wordToSignature method in the PredictivePrototype class.
     * The method is used to change the word to the signature.
     *
     * @param word the word need to be changed.
     * @return signature   The signature of the world.
     */
    public static String wordToSignature(String word){

        return PredictivePrototype.wordToSignature(word);

    }
}
