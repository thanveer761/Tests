package BinarySearch;

import org.junit.jupiter.api.Test;

public class FirstOccurrenceGreaterOrEqual{

    @Test
    public void test1() {
        // positive case: n exists in array, multiple duplicates before and after
        int[] nums = {1, 3, 3, 5, 5, 5, 8, 10};
        int n = 5;
        int op1 = firstGreaterOrEqual(nums, n);
        System.out.println(op1); // expect 3 (first index where value >= 5)
    }

    @Test
    public void test2() {
        // negative case: n is bigger than every element -> no valid index exists
        int[] nums = {1, 3, 5, 6};
        int n = 100;
        int op1 = firstGreaterOrEqual(nums, n);
        System.out.println(op1); // expect -1 (or nums.length, depending on convention)
    }

    @Test
    public void test3() {
        // edge case: n is smaller than every element -> answer is index 0
        int[] nums = {5, 6, 7, 8};
        int n = 2;
        int op1 = firstGreaterOrEqual(nums, n);
        System.out.println(op1); // expect 0
    }

    /*
    * GOAL: find the index of the first element in a sorted array
    *        that is >= n (using binary search since array is sorted)

    * initialize left = 0, right = nums.length - 1
    * initialize result = -1 (default: no valid index found)

    * while left <= right:
        * mid = (left + right) / 2
        * if nums[mid] >= n:
            - this index is a valid candidate
            - record result = mid
            - but there might be an even earlier valid index, so keep searching left
            - move right = mid - 1
        * else:
            - nums[mid] is too small, valid answer must be further right
            - move left = mid + 1

    * return result
    */

    public int firstGreaterOrEqual(int[] nums, int n) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= n) {
                result = mid;
                right = mid - 1;   // keep searching left for an even earlier match
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}