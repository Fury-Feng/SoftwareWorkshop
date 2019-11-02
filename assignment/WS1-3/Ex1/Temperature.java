/**
 * The program is a class named Temperature, the class has a non-empty array of double values,
 * the class has a method named coldest.
 * The class is used to find the coldest day of the year.
 * @author: Fuwei Feng
 * @version: 2019/10/29
 */
public class Temperature {

    private double[] temperatures = new double[365];

    /**
     * This method is used to find the first day of the year with lowest temperature.
     * @param temperatures   The temperatures is an array contain the temperature of everyday in the year.
     * @return coldestDay+1   The first day of the year with lowest temperature.
     */
    public static int coldest(double[] temperatures) {

        int coldestDay = 0;

        for (int i = 0; i < temperatures.length - 1; i ++) {
            if (temperatures[coldestDay] > temperatures[i + 1]) {
                coldestDay = i + 1;
            }
        }

        return coldestDay + 1;
    }
}
