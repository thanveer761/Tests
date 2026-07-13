package SlidingWindow;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubArraySumEqualsK {

    @Test
    public void test1() {
        int[] nums = {1, 1, 1};
        int k = 2;
        assertEquals(2, subarraySum(nums, k));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3};
        int k = 3;
        assertEquals(2, subarraySum(nums, k));
    }

    /*
    -- initialise prefixSum as 0
-- initialise count as 0
-- initialise map with {0: 1}        (empty prefix sum of 0 has occurred once, before we start)

-- traverse i from 0 to nums.length-1

--   add nums[i] to prefixSum         (running total up to and including index i)

--   if map contains key (prefixSum - k)
--     add map.get(prefixSum - k) to count
--     (this many earlier points had a prefix sum that, combined with everything since,
--      sums exactly to k)

--   increment map[prefixSum] by 1    (record that this prefix sum value has now occurred,
                                        so future indices can check against it)

-- return count
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);   // empty prefix sum occurs once, before we start

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // how many earlier prefix sums equal (prefixSum - k)?
            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }

            // record that this prefix sum has now occurred (one more time)
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}