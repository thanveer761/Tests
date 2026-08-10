package BinarySearch;

import org.junit.jupiter.api.Test;

public class SearchInsertPosition{

    @Test
    public void test1() {
        int[] nums = {1, 3, 3, 5, 5, 5, 8, 10};
        int n = 5;
        int op1 = searchInsertPosition(nums, n);
        System.out.println(op1); // expect 3
    }

    @Test
    public void test2() {
        int[] nums = {1, 3, 5, 6};
        int n = 100;
        int op1 = searchInsertPosition(nums, n);
        System.out.println(op1); // expect nums.length (4)
    }

    @Test
    public void test3() {
        int[] nums = {5, 6, 7, 8};
        int n = 2;
        int op1 = searchInsertPosition(nums, n);
        System.out.println(op1); // expect 0
    }

    /*
    * GOAL: find the index of the first element in a sorted array
    *        that is >= n (using binary search since array is sorted)

    * initialize low = 0, high = nums.length - 1
    * initialize result = nums.length
        (default: if no element is >= n, the answer is "insert at the very end")

    * while low <= high:
        * mid = (low + high) / 2
        * if nums[mid] >= n:
            - this index is a valid candidate
            - record result = mid
            - but there might be an even earlier valid index, so keep searching left
            - move high = mid - 1
        * else:
            - nums[mid] is too small, valid answer must be further right
            - move low = mid + 1

    * return result
    */

    public int searchInsertPosition(int[] nums, int n) {
        int low = 0, high = nums.length - 1;
        int result = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= n) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}