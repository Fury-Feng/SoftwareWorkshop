package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * The class MapDictionary implements the interface Dictionary.
 * The class has a HashMap named mapDictionary with the Key type of String and the Value type of Set<String>,
 * a constructor, a signatureToWords method.
 *
 * @author: Fuwei Feng
 * @version: 2020/2/12
 */
public class MapDictionary implements Dictionary{

    HashMap<String, Set<String>> mapDictionary;

    /**
     * The MapDictionary constructor takes a String path to the dictionary, stores the dictionary in a multi-valued Map.
     * The ArrayList need to be sorted.
     *
     * Explain: We use the hashMap, the map has the key and value, the key is the signature, signature should not be the same,
     *          every signature has the matching value the Set of the words.
     *
     * @param path  The path of the dictionary need to be stored.
     * @throws FileNotFoundException if the dictionary file is not found.
     */
    public MapDictionary(String path) throws FileNotFoundException {

        mapDictionary = new HashMap<>();
        Scanner scanner = new Scanner(new File(path));
        String regex = "^[a-z]+$";

        while(scanner.hasNext()){

            String word = scanner.nextLine().toLowerCase();
            String key = PredictivePrototype.wordToSignature(word);

            if(word.matches(regex)){

                if(mapDictionary.containsKey(key)){

                    Set<String> wordSet = mapDictionary.get(key);
                    wordSet.add(word);
                    mapDictionary.put(key, wordSet);

                } else {

                    Set<String> wordSet = new HashSet<>();
                    wordSet.add(word);
                    mapDictionary.put(key, wordSet);

                }
            }
        }
    }

    /**
     * The signatureToWords method is used to take the given numeric signature and returns
     * a set of possible matching words from the dictionary.
     *
     * @param signature the signature need to be used to get the matches value of the key signature.
     * @return wordSet  The set of the words that matches the signature.
     */
    @Override
    public Set<String> signatureToWords(String signature) {

        Set<String> wordSet = new HashSet<>();
        String regex = "^[2-9]+$";

        if(signature.matches(regex)){

            wordSet = mapDictionary.get(signature);

        }

        return wordSet;

    }
}
