package SlidingWindow;

import org.junit.jupiter.api.Test;

public class MaxSumSubArrayKadanesAlgo {

    @Test
    public void test1(){
       int[] nums = {2, 3, -8, 7, -1, 2, 3};
       int op= maxSumSubArrayKadanesAlgo(nums);
       System.out.println(op);
    }
    /*
    -- initialise maxSum as nums[0]
-- initialise currSum as nums[0]

-- traverse i from 1 to nums.length-1

--   currSum = max(currSum + nums[i], nums[i])
--   (decide: is it better to EXTEND the current subarray by adding nums[i],
--    or to START A FRESH subarray at nums[i]?
--    If currSum so far is negative/unhelpful, dragging it along only hurts,
--    so it's better to restart from nums[i] alone.)

--   maxSum = max(currSum, maxSum)
--   (keep track of the best subarray sum seen anywhere so far,
--    even if currSum later drops)

-- return maxSum



     */

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
