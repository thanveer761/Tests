package SlidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxSumSubArrayOfSizeK {
    @Test
    public void test() {
        int[] nums = {2, 1, 5, 3, 4, 6, 2, 8};
        int k = 3;
        Assertions.assertEquals(16, maxSumSubArray(nums, k));
    }
/*
 * initialise a variable maxSum=0, sum=0, left=0 to keep track of running sum and max value
 * iterate the array of window size (k), compute running sum
 * compare the sum with maxSum and update as needed
 * iterate the array from size k till the end
 * - add the element at the current index
 * - remove the k-left element from the window, so that the window size stays constant
 * - keep computing the max sum
 * return the max sum
 *
 *  TC: O(n)
 *  SC: O(1)

 */
    private int maxSumSubArray(int[] nums, int k) {
        int sum=0,maxSum=0;
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        maxSum=Math.max(sum,maxSum);
        for (int i = k; i < nums.length; i++) {
            sum=sum+nums[i];
            sum=sum-nums[i-k];
            maxSum=Math.max(sum, maxSum);
        }
        return sum;
    }
}
