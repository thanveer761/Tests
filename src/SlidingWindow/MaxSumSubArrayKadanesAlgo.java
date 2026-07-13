package SlidingWindow;

import org.junit.jupiter.api.Test;

public class MaxSumSubArrayKadanesAlgo {

    @Test
    public void test1(){
       int[] nums = {2, 3, -8, 7, -1, 2, 3};
       int op= maxSumSubArrayKadanesAlgo(nums);
       System.out.println(op);
    }

    private int maxSumSubArrayKadanesAlgo(int[] nums) {
        int maxSum=nums[0];
        int currSum=nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum=Math.max(currSum+nums[i], nums[i]);
            maxSum=Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
