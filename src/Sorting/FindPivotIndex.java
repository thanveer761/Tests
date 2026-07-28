package Sorting;

import org.junit.jupiter.api.Test;

public class FindPivotIndex {

    @Test
    public void test1() {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums)); // expect 3
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3};
        System.out.println(pivotIndex(nums)); // expect -1 (no pivot exists)
    }

    @Test
    public void test3() {
        int[] nums = {2, 1, -1};
        System.out.println(pivotIndex(nums)); // expect 0 (left sum=0, right sum=1+-1=0)
    }

    /*
    * compute totalSum = sum of all elements in nums

    * initialize leftSum = 0

    * traverse using pointer i from 0 to n-1
        * rightSum = totalSum - leftSum - nums[i]

        * if leftSum == rightSum:
            - return i immediately

        * add nums[i] into leftSum

    * if no pivot found, return -1
    */

    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}