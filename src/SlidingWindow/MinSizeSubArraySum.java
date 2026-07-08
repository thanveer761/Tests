package SlidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinSizeSubArraySum {
    @Test
    public void test(){
        int[] nums={2,3,1,2,4,3};
        int target=7;
        Assertions.assertEquals(2, minSizeSubArraySum(target, nums));
    }

    private int minSizeSubArraySum(int target, int[] nums) {
        int minSize=Integer.MAX_VALUE, runningSum=0;
        int left=0, right=0;
        while (right<nums.length){
            runningSum+=nums[right];
            while(runningSum>=target){
                runningSum-=nums[left];
                minSize=Math.min(minSize, right-left+1);
                left++;
            }
            right++;
        }
        return minSize==Integer.MAX_VALUE?0:minSize;
    }
}
