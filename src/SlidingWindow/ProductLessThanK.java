package SlidingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductLessThanK {
    @Test
    public void test(){
        int[] nums={10,5,2,6};
        int k = 100;
    int op=  numSubarrayProductLessThanK(nums,k);
    System.out.println(op);
    }

    /*
-- initialise left as 0
-- initialise product as 1
-- initialise count as 0

-- if k is less than or equal to 1
--   return 0                          (nothing can ever be smaller than 1, since all nums >= 1)

-- traverse right from 0 to nums.length

--   multiply product by nums[right]   (bring the new right element into the window)

--   while product is greater than or equal to k
--     divide product by nums[left]    (shrink window from the left until valid again)
--     increment left

--   add (right - left + 1) to count   (every subarray ending at 'right' and starting
                                         anywhere from 'left' to 'right' is valid —
                                         count them all at once)

-- return count

     */

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int left = 0;
        long product = 1;   // use long to avoid overflow while multiplying
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }

    }
