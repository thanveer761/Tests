package SortColorsUsingDutchFlag;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortColorsDutchFlag {
    @Test
    public void test1() {
        int[] nums = {2,0,2,1,1,0};

        int[] op= sortColorsUsingDutchFlag(nums);
        System.out.println(Arrays.toString(op));
    }
    @Test
    public void test2() {
        int[] nums = {2,0,1};

        int[] op= sortColorsUsingDutchFlag(nums);
        System.out.println(Arrays.toString(op));
    }
/*

 */
    private int[] sortColorsUsingDutchFlag(int[] nums) {
        int left=0, mid=0;
        int right=nums.length-1;
        while (mid <= right) {
            if(nums[mid]==0){
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
                left++;
                mid++;
            } else if (nums[mid]==1) {
               mid++;
            }else{
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
        return nums;
    }

}
