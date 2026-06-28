package Arrays;

import org.junit.jupiter.api.Test;

public class RemoveElement {

    @Test
    public void test1() {
        int[] nums = {3, 2, 2,3};
        int val=3;
        int op1 = removeElem(nums, val);
        System.out.println(op1);
    }

    /*   Approach: fast/slow pointer
        Time complexity: O[N], space is o[1]

          * intitalize an int op
          * traverse and check if array nums did not match value
          * copy the nums back into same array which is not matching and increment the op
          * finally return op.

     */
    private int removeElem(int[] nums, int val) {
        int op = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i]!=val){
                nums[op]=nums[i];
                op++;
            }
        }

        return op;

    }
    private int removeElem2(int[] nums, int val) {
        int left=0, right =nums.length-1;
        while(left<right){
            if(nums[left]!=nums[right]){
                nums[left]=nums[right];
                right--;
            }else left++;
        }
        return left;

    }
}
