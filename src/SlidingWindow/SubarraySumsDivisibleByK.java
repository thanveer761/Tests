package SlidingWindow;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {

    @Test
    public void test1() {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByK(nums, k)); // Expected: 7
    }

    @Test
    public void test2() {
        int[] nums = {5};
        int k = 9;
        System.out.println(subarraysDivByK(nums, k)); // Expected: 0
    }
/*
i=0: nums[0]=4, sum=4, rem=((4%5)+5)%5=4
     remainderCount has 4? No.
     remainderCount = {0:1, 4:1}

i=1: nums[1]=5, sum=9, rem=((9%5)+5)%5=4
     remainderCount has 4? YES, count=1 → count=0+1=1
     remainderCount = {0:1, 4:2}

i=2: nums[2]=0, sum=9, rem=4
     remainderCount has 4? YES, count=2 → count=1+2=3
     remainderCount = {0:1, 4:3}

i=3: nums[3]=-2, sum=7, rem=((7%5)+5)%5=2
     remainderCount has 2? No.
     remainderCount = {0:1, 4:3, 2:1}

i=4: nums[4]=-3, sum=4, rem=((4%5)+5)%5=4
     remainderCount has 4? YES, count=3 → count=3+3=6
     remainderCount = {0:1, 4:4, 2:1}

i=5: nums[5]=1, sum=5, rem=((5%5)+5)%5=0
     remainderCount has 0? YES, count=1 → count=6+1=7
     remainderCount = {0:2, 4:4, 2:1}
 */
    /*
    /*
* GOAL: count subarrays whose sum is divisible by k

* initialize sum = 0 (running prefix sum)
* initialize count = 0 (number of valid subarrays found)
* create remainderCount = HashMap of remainder -> how many times it's occurred
* seed remainderCount with {0: 1}
    (an empty prefix, before the array starts, has remainder 0 — this lets
     subarrays starting from index 0 be counted correctly)

* traverse using pointer i from 0 to n-1
    * add nums[i] to sum
    * compute rem = ((sum % k) + k) % k
      (normalizes negative remainders into the range [0, k-1])

    * if remainderCount contains rem:
        - add remainderCount[rem] to count
          (each prior occurrence of this remainder pairs with the current
           position to form a valid divisible subarray)

    * increment remainderCount[rem] by 1
      (record that this remainder has now occurred one more time)

* return count
*/
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            // Handle negative remainders
            int rem = ((sum % k) + k) % k;

            if (remainderCount.containsKey(rem)) {
                count += remainderCount.get(rem);
            }

            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}