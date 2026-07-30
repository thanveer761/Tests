package Sorting;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MaxDistinctElementsAfterOperations {

        @Test
        public void test1() {
            int[] nums = {1, 2, 2, 3, 3, 4};
            int k = 2;
            System.out.println(maxDistinctElements(nums, k)); // expect 6
        }

        @Test
        public void test2() {
            int[] nums = {4, 4, 4, 4};
            int k = 1;
            System.out.println(maxDistinctElements(nums, k)); // expect 3
        }
          /*
    * sort nums in ascending order
    * initialize lastUsed = Integer.MIN_VALUE (nothing assigned yet)
    * initialize count = 0

    * traverse each num in sorted nums
        * low = num - k, high = num + k
        * candidate = max(low, lastUsed + 1)

        * if candidate <= high:
            - count++
            - lastUsed = candidate
        * else:
            - skip (no available distinct value in range)

    * return count
    */
  /*  sorted = [1,2,2,3,3,4]
    lastUsed = Integer.MIN_VALUE, count=0

    num=1: low=-1, high=3, candidate=max(-1, MIN_VALUE+1)=-1. -1<=3? YES → count=1, lastUsed=-1
    num=2: low=0, high=4, candidate=max(0, -1+1=0)=0. 0<=4? YES → count=2, lastUsed=0
    num=2: low=0, high=4, candidate=max(0, 0+1=1)=1. 1<=4? YES → count=3, lastUsed=1
    num=3: low=1, high=5, candidate=max(1, 1+1=2)=2. 2<=5? YES → count=4, lastUsed=2
    num=3: low=1, high=5, candidate=max(1, 2+1=3)=3. 3<=5? YES → count=5, lastUsed=3
    num=4: low=2, high=6, candidate=max(2, 3+1=4)=4. 4<=6? YES → count=6, lastUsed=4

            return 6
            */
    private int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int lastUsed=Integer.MIN_VALUE;
        int count =0;
        for(int num:nums){
            int low=num-k;
            int high=num+k;
            int  candidate=Math.max(low, lastUsed+1);
            if(candidate<=high){
                count++;
                lastUsed=candidate;
            }
        }
        return count;
    }

}
