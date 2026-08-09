package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingleElement {

    @Test
    public void test() {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        Assertions.assertEquals(2, singleElement(nums));
    }

    public int singleElement(int[] nums) {
        int last = nums.length - 1;
        if (nums[0] != nums[1]) return nums[0];
        if (nums[last] != nums[last - 1]) return nums[last];

        int low = 1, high = last - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];
            if (mid % 2 == 0 && nums[mid] == nums[mid + 1] || mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
                low=mid+1;
            }
            else high=mid-1;
        }
        return -1;
    }
}