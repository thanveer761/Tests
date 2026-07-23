package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindMinInRotatedSortedArray {

    @Test
    public void test(){
        int[] nums={3,4,5,1,2};
        Assertions.assertEquals(1, findMin(nums));
    }

    @Test
    public void test1(){
        int[] nums={4,5,6,7,0,1,2};
        Assertions.assertEquals(0, findMin(nums));
    }

    @Test
    public void test3(){
        int[] nums={11,13,15,17};
        Assertions.assertEquals(11, findMin(nums));
    }

    /*
* GOAL: find the minimum element in a rotated sorted array, in O(log n) time

* initialize left = 0, right = nums.length - 1

* while left < right:
    * mid = (left + right) / 2

    * if nums[mid] > nums[right]:
        - the minimum is NOT in the left half (left half, including mid,
          is part of the larger "first chunk" — it's all bigger than the true min)
        - the rotation point must be somewhere to the right of mid
        - move left = mid + 1

    * else (nums[mid] <= nums[right]):
        - mid is either the minimum itself, or the minimum is somewhere
          to its left (this half, from mid to right, is already sorted,
          so it can't contain a smaller element than nums[mid] unless
          mid itself is the smallest)
        - keep mid in range (don't rule it out)
        - move right = mid

* when left == right, that index holds the minimum
* return nums[left]
*/
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
