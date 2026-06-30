package day3;

import org.junit.jupiter.api.Test;

public class RemoveDuplicates {
    @Test
    public void test1() {
        int[] nums = {1,1,2};
        int op= removeDups(nums);
        System.out.println(op);
    }
    @Test
    public void test2() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int op= removeDups(nums);
        System.out.println(op);
    }
    @Test
    public void test3() {
        int[] nums = {9,9,9,9};
        int op= removeDups(nums);
        System.out.println(op);
    }
    @Test
    public void test4() {
        int[] nums = {};
        int op= removeDups(nums);
        System.out.println(op);
    }

    /*
    pseudocode:
    -initialize left pointer 0
    -traverse till length using sequentials right pointer from
    -if array value left doesn't match with  right
    -just increment left pointer
    -assign, left to right
    -finally return left+1 to get total length of it

     */

    private int removeDups(int[] nums) {
       int left=0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[left]!=nums[right]){
                left++;
                nums[left]=nums[right];
        }

    }

         return left+1;

    }
}
