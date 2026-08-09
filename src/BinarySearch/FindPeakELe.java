package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindPeakELe {


    @Test
    public void test(){
        int[] nums={1,2,3,1};
        Assertions.assertEquals(2, findPeak(nums));
    }

    @Test
    public void test1(){
        int[] nums={1,2,1,3,5,6,4};
        Assertions.assertEquals(5, findPeak(nums));
    }

    @Test
    public void test3(){
        int[] nums={1,2,3,4,5,6};
        Assertions.assertEquals(5, findPeak(nums));
    }

    @Test
    public void test4(){
        int[] nums={5,4,3,2,1};
        Assertions.assertEquals(0, findPeak(nums));
    }
    /*
    * GOAL: find the index of a peak element (an element strictly greater
    *        than its neighbors), using binary search

    * initialize low = 0, high = n-1

    * while low < high:
        * mid = (low + high) / 2

        * if nums[mid] < nums[mid+1]:
            - we're on an "uphill" slope, a peak must exist somewhere to the right
            - move low = mid + 1

        * else:
            - we're on a "downhill" slope (or mid itself is already a peak)
            - move high = mid
              (keep mid in range, since it could be the peak)

    * when low == high, that index holds a peak
    * return low
    */
    public int findPeak(int[] nums){
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;   // peak is to the right
            } else {
                high = mid;      // peak is at mid or to the left
            }
        }
        return low;
    }
}