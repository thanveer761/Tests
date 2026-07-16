package Arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RotateArray {



    @Test
    public void test1() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int[] op=  rotate(nums,k);
        System.out.println(Arrays.toString(op));
    }
    @Test
    public void test2() {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        int[] op=  rotate(nums,k);
        System.out.println(Arrays.toString(op));
    }
    /*
    * initialise till nums.length as n
    * initalize empty result array
    * traverse till n
    *  each element at index i belongs at index (i + k) % n in the rotated array
    * place it there: result[(i + k) % n] = nums[i]
     * place nums[i] into result[newIndex] (nums[i]=result[newIndex])
     *

     */
    public int[] rotate(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }
        for(int i = 0; i < n; i++){
            nums[i] = result[i];            // copy back to original array
        }
        return result;
    }
}
