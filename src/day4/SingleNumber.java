package day4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SingleNumber {
    @Test
    public void test1() {
        int[] nums = {2,2,1};
        int op= singleNumber(nums);
        System.out.println(op);
    }
    @Test
    public void test2() {
        int[] nums = {4,1,2,1,2,};
        int op= singleNumber(nums);
        System.out.println(op);
    }
    @Test
    public void test3() {
        int[] nums = {1};
        int op= singleNumber(nums);
        System.out.println(op);
    }
    @Test
    public void test4() {
        int[] nums = {-1};
        int op= singleNumber(nums);
        System.out.println(op);
    }
    @Test
    public void test5() {
        int[] nums = {};
        assertThrows(RuntimeException.class, () -> singleNumber(nums));
    }
    /*
    /*
    pseudocode:
   - sort the array so duplicates sit next to each other
- traverse with j starting at index 1, jumping by 2 each step
    - if nums[i] does NOT match nums[j]:
        - return nums[i] immediately (this is the single number)
    - if nums[i] DOES match nums[j]:
        - move i forward by 2 (skip the matched pair, check next pair)
- if loop finishes without returning:
    - return nums[nums.length - 1] (single number is the last element)

     */


    private int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("array is null or empty");
        }
        Arrays.sort(nums);
        int i=0;
        for (int j =i+1; j < nums.length ; j+=2) {
            if(nums[i]!=nums[j]){
                return nums[i];
            }
            i+=2;
        }

        return nums[nums.length-1];
    }
}
