package DuplicateNumbersArray;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class RemoveDuplicatesFromSortedArray {

    @Test
    public void test1() {
        int[] nums = {1,1,2};
        int op1 = removeDups1(nums);
        System.out.println(op1);
        int op2 = removeDups2(nums);
        System.out.println(op2);
        int[] op3 = removeDups3(nums);
        System.out.println(Arrays.toString(op3));

    }


    /*
    *initialize list and add nums with 1st index
    * traverse from 1st index till length of the array
    * and, check if index values doesn't match till last element
    * add to the list
    * finally, traverse till size of the op
    * and, copy back to the nums
     */

    private int removeDups1(int[] nums) {

        List<Integer> op = new ArrayList<>();
            op.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=op.getLast()){
                op.add(nums[i]);
            }
        }
        for (int i = 0; i < op.size(); i++) {
                nums[i]=op.get(i);
            }
       return op.size();
    }

    /*
    brute Force:
    * initailize left as 0
    * traverse and check if value in left is not equal right
    *increment left
    * assign left value to right value
    * return left+1 to get total count of it

     */
    private int removeDups2(int[] nums) {
        int left=0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[left]!=nums[right]){
                left++;
                nums[left]=nums[right];
            }

        }

        return left+1;

    }


    public int[] removeDups3(int[] nums) {

        int left=0;
        for (int right = 0; right < nums.length ; right++) {
            if(nums[left]!=nums[right]){
                left++;
               nums[left]=nums[right];
            }
        }
        return Arrays.copyOf(nums, left + 1);
    }
}