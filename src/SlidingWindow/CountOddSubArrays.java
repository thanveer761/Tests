package SlidingWindow;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountOddSubArrays {

    @Test
    public void test1() {
        int[] nums = {1, 3,5};
       
       
        assertEquals(4, countOddSubArrays(nums));
    }
    /*
    All sub-array—[[1], [1,3], [1,3,5], [3], [3,5], [5]]

   All sub array sums—[1, 4, 9, 3, 8, 5]

   Odd sums-{1,9,3,5)

Hence, output should be 4
     */
   /* initialize runningSum as 0
            * initialize evenCount as 1   // empty prefix (sum=0) counts as even
            * initialize oddCount as 0
            * initialize result as 0

            * traverse through the loop from 0 to nums.length-1
            * runningSum += nums[i]
            * check, if runningSum % 2 != 0   // odd prefix sum
            * result += evenCount
        * oddCount++
            * else                            // even prefix sum
            * result += oddCount
        * evenCount++

            * return result*/
    private int countOddSubArrays(int[] nums) {
        int runningSum = 0, oddCount = 0, result = 0, evenCount = 1;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (runningSum % 2 != 0) {
                result += evenCount;
                oddCount++;
            } else {
                result += oddCount;
                evenCount++;
            }
        }
        return result;
    }
     /*
    All sub-array—[[1], [1,3], [1,3,5], [3], [3,5], [5]]

   All sub array sums—[1, 4, 9, 3, 8, 5]

   Odd sums-{1,9,3,5)

Hence, output should be 4
     */
    /*
     * initialize an empty list called oddSums
     *
     * traverse i from 0 to nums.length-1        // start of subarray
     *   initialize sum as 0
     *   traverse j from i to nums.length-1      // end of subarray
     *     sum += nums[j]
     *     check, if sum % 2 != 0
     *       add sum to oddSums
     *
     * return oddSums.size()
     */
  /*   private int countOddSubArrays(int[] nums) {
         List<Integer> oddSums = new ArrayList<>();

         for (int i = 0; i < nums.length; i++) {
             int sum = 0;
             for (int j = i; j < nums.length; j++) {
                 sum += nums[j];
                 if (sum % 2 != 0) {
                     oddSums.add(sum);
                 }
             }
         }

         return oddSums.size();
     }*/


}
