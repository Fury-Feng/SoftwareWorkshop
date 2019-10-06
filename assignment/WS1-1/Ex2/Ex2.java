/**
 * @Author: Fuwei Feng
 * @Date: 2019/10/3
 **/
public class Ex2 {
    public static double imperialToKg(double ton, double hundredweight, double quarter, double stone,
                                      double pound, double ounce, double drachm, double grain){
        /**
         * change the converts masses given in the imperial system into kilograms
         */
        double tontokg =  ton * 2240 * 0.45359237;
        double hundredweighttokg = hundredweight * 112 * 0.45359237;
        double quartertokg = quarter * 28 * 0.45359237;
        double stonetokg = stone * 14 * 0.45359237;
        double poundtokg = pound * 0.45359237;
        double ouncetokg = ounce / 16 * 0.45359237;
        double drachmtokg = drachm / 256 * 0.45359237;
        double graintokg = grain / 7000 * 0.45359237;
        double weight = tontokg + hundredweighttokg + quartertokg + stonetokg + poundtokg + ouncetokg + drachmtokg
                + graintokg;
        // return the weight of a person
        return weight;
    }

    public static void main(String[] args) {
        // get the weight of a person who is 11 stones and 6 pounds
        double humanweight = imperialToKg(0, 0, 0, 11, 6, 0, 0, 0);
        System.out.println("Your weight is " + humanweight + " kg.");
    }
}
