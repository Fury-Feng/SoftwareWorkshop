/**
 * @Author: Fuwei Feng
 * @Date: 2019/10/5
 **/
public class Swap {
    /**
     * swaps i and j
     * @param nums[] is  an array
     * The method use array to change the values of i and j.
     */
    public static void swap(int[] nums){
        int t = nums[0];	// give the first number to an empty varibale
        nums[0] = nums[1];	// then give the second number to the first 
        nums[1] = t;		// then give the original first number to the second
    }

    public static void main(String[] args) {
        int i = 2;
        int k = 6;
        int[] nums = {i, k};
        System.out.println("Original i : " + nums[0] + " k : " + nums[1]);
        swap(nums);	// swap the number in the array
        System.out.println("After swapping i : " + nums[0] + " k : " + nums[1]);
    }
}
