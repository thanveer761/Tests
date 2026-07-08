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
