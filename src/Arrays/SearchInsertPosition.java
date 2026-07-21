package Arrays;

import org.junit.jupiter.api.Test;

public class SearchInsertPosition {

    @Test
    public void test1() {
        int[] nums = {1,3,5,6};
        int target=5;
        int op1 = searchInsert(nums, target);
        System.out.println(op1);
    }
    @Test
    public void test2() {
        int[] nums = {1,3,5,6};
        int target=2;
        int op1 = searchInsert(nums, target);
        System.out.println(op1);
    }

    /*
* GOAL: find the index of target in a sorted array nums,
*        or the index where it should be inserted to keep the array sorted

* traverse using pointer i from 0 to nums.length-1
    * if nums[i] == target:
        - target already exists at this position
        - return i

    * if nums[i] > target:
        - we've found the first element bigger than target
        - target belongs right here (before this element)
        - return i

* if the loop completes without returning:
    - target is bigger than every element in the array
    - it belongs at the very end
    - return nums.length
*/
        public int searchInsert(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {  // target found, return its index
                    return i;
                }
                if (nums[i] > target) {   // first element greater than target
                    return i;             // this is where target should be inserted
                }
            }
            return nums.length;           // target is greater than all elements
            // insert at end
        }
    }
