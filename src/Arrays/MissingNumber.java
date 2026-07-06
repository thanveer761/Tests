package Arrays;

import org.junit.jupiter.api.Test;

public class MissingNumber {

    @Test
    public void test1() {
        int[] nums = {3,0,1};
       int op= missingNum(nums);
        System.out.println(op);
    }
    @Test
    public void test2() {
        int[] nums = {};
        int op= missingNum(nums);
        System.out.println(op);
    }
    @Test
    public void test3() {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int op= missingNum(nums);
        System.out.println(op);
    }


    /*
  --initiliaze a sum variable pointer as 0
     ---traverse through the loop
     ---and add the sum for next next index
     ---finally, return the missing num using n*(n+1)/2-sum

     */

    //time--o[n]

    private int missingNum(int[] nums) {

       int sum=0;
       int n=nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
       return n*(n+1)/2-sum;
    }
}
