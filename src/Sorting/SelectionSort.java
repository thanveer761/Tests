package Sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SelectionSort {

    @Test
    public void test1() {
        int[] nums = {5, 1, 3, 4, 2};
        int[] op = selection(nums);
        System.out.println(Arrays.toString(op));
    }
    /*
    * GOAL: sort an array by repeatedly finding the minimum element
    *        in the remaining unsorted portion and placing it at the front

    * traverse using pointer i from 0 to n-2
        * initialize minIndex = i (assume current position holds the smallest, for now)

        * traverse using pointer j from i+1 to n-1
            * if nums[j] < nums[minIndex]:
                - found a smaller value further along
                - update minIndex = j

        * swap nums[i] and nums[minIndex]
          (place the smallest found value into its correct sorted position)

    * after all passes, array is sorted
    * return nums
    */
    private int[] selection(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i; // assume current position holds the smallest value so far

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j; // found a smaller value, remember its index
                }
            }

            // swap the smallest found value into position i
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

        return nums;
    }
}
