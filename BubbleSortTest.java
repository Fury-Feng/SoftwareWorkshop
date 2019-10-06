/**
 * @Author: Fuwei Feng
 * @Date: 2019/10/6
 **/
import java.util.Arrays;

public class BubbleSortTest {
    public static void main(String[] args) {
        int[] ns = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        // 排序前：
        System.out.println("排序前数组为： " + Arrays.toString(ns));
        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] > ns[j + 1]) {
                    int tmp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = tmp;
                }
            }
        }
        // 排序后：
        System.out.println("升序排序后的数组 ： " + Arrays.toString(ns));

        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] < ns[j + 1]) {
                    int tmp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = tmp;
                }
            }
        }
        System.out.println("降序排序后的数组 ： " + Arrays.toString(ns));
    }
}


