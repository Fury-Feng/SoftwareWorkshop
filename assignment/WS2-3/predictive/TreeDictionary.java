package predictive;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * The class TreeDictionary implements the interface Dictionary.
 * The class has an TreeDictionary array named arrayList and a Set<String> named wordSet,
 * two constructors, a signatureToWords method, an addToDictionary method, a helpGetWords method.
 *
 * @author: Fuwei Feng
 * @version: 2020/2/12
 */
public class TreeDictionary implements Dictionary {

    TreeDictionary[] arrayList;
    Set<String> wordSet;

    /**
     * The TreeDictionary constructor takes a String path to the dictionary, read and store
     * the words in the TreeDictionary. This tree differs in that each node now has up to eight branches,
     * one for each number (2-9) that is allowed in a signature.
     *
     * @param path  The path of the dictionary need to be stored.
     * @throws FileNotFoundException if the dictionary file is not found.
     */
    public TreeDictionary(String path) throws FileNotFoundException {

        arrayList = new TreeDictionary[8];
        wordSet = new HashSet<>();
        String regex = "^[a-z]+$";
        Scanner scanner = new Scanner(new File(path));

        while(scanner.hasNext()){

            String word = scanner.nextLine().toLowerCase();

            if(word.matches(regex)){

                String signature = PredictivePrototype.wordToSignature(word);
                addToDictionary(this, word, signature);

            }
        }
    }

    /**
     * The TreeDictionary is used to create the TreeDictionary constructor.
     *
     * @param treeDictionary The array of the treeDictionary.
     * @param wordSet the Set that contains the words.
     */
    public TreeDictionary(TreeDictionary[] treeDictionary, Set<String> wordSet){

        this.wordSet = wordSet;
        this.arrayList = treeDictionary;

    }

    /**
     * The addToDictionary is used to add the matches words to every matching nodes.
     *
     * @param treeDictionary The TreeDictionary object.
     * @param word The word need to be added.
     * @param signature The signature need to be found.
     */
    public void addToDictionary(TreeDictionary treeDictionary, String word, String signature) {

        if(signature.length() != 0){

            int index = Integer.parseInt(signature.substring(0, 1)) - 2;

            if(treeDictionary.arrayList[index] == null){

                treeDictionary.arrayList[index] = new TreeDictionary(new TreeDictionary[8], new HashSet<>());
                treeDictionary.arrayList[index].wordSet.add(word);
                addToDictionary(treeDictionary.arrayList[index], word, signature.substring(1));

            } else {

                treeDictionary.arrayList[index].wordSet.add(word);
                addToDictionary(treeDictionary.arrayList[index], word, signature.substring(1));

            }
        }
    }

    /**
     * The helpGetWords method is used to get the set of the words from the TreeDictionary
     * that match the signature.
     *
     * @param treeDictionary The dictionary need to be found.
     * @param signature The signature need to be found.
     * @return the set that contains the words.
     */
    public Set<String> helpGetWords(TreeDictionary treeDictionary, String signature){

        if(treeDictionary == null){

            return new HashSet<>();

        } else {

            if(signature.length() == 0){

                return treeDictionary.wordSet;

            } else {

                int index = Integer.parseInt(signature.substring(0,1)) - 2;
                return helpGetWords(treeDictionary.arrayList[index], signature.substring(1));

            }
        }
    }

    /**
     * The signatureToWords method is used to take the given numeric signature and returns
     * a set of possible matching words from the dictionary.
     *
     * @param signature the signature need to be used to get the matches value of the key signature.
     * @return The set of the words that matches the signature.
     */
    @Override
    public Set<String> signatureToWords(String signature) {

        return helpGetWords(this, signature);

    }
}
