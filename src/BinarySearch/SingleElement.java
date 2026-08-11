package BinarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingleElement {

    @Test
    public void test() {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        Assertions.assertEquals(2, singleElement(nums));
    }
    /*
       Iteration   low	 high	  mid	    nums[mid] vs nums[mid+1]	Equal?	 Action
       1	       0	 8	      4	        3 vs 4	                     No	     high = 4
       2	       0	 4	      2	        2 vs 3	                     No	     high = 2
       3	       0	 2	      1	        1 vs 1	                     Yes	 low = 2
       —	       2	 2	      —	        —	                         —	     loop ends
     */
    /*
    /*
* GOAL: find the single element that appears once in a sorted array
*        where every other element appears exactly twice

* initialize low = 0, high = n-1

* while low < high:
    * mid = (low + high) / 2

    * if mid is odd:
        - adjust mid to the nearest even index (mid = mid - 1)
          (this keeps mid always aligned to the START of a potential pair)

    * if nums[mid] == nums[mid+1]:
        - this is an INTACT pair, meaning the disruption (single element)
          has not occurred yet — it must be somewhere after this pair
        - skip past this entire pair
        - low = mid + 2

    * else:
        - this pair is BROKEN, meaning the disruption has already
          happened at or before this point
        - high = mid
          (keep mid in range, since it could be part of the disruption)

* when low == high, that index holds the single non-duplicate element
* return nums[low]
*/


    public int singleElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // ensure mid is even (so mid, mid+1 form a proper pair)
            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                // the pair is intact, single element is to the right
                low = mid + 2;
            } else {
                // the pair is broken, single element is at mid or to the left
                high = mid;
            }
        }

        return nums[low];
    }
}