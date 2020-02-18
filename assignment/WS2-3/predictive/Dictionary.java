package predictive;

import java.util.Set;

/**
 * This is the interface Dictionary. The interface has a signatureToWords method.
 *
 * @author: Fuwei Feng
 * @version: 2020/2/8
 */
public interface Dictionary {
    /**
     * The signatureToWords method is used to take the given numeric signature and returns
     * a set of possible matching words from the dictionary. The returned list must not have duplicates
     * and each word should be in lower-case.
     *
     * @param signature
     * @return the Set that contain the words
     */
    public Set<String> signatureToWords(String signature);
}
