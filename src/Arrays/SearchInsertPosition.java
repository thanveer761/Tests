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
