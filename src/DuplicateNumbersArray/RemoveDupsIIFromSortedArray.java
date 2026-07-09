package DuplicateNumbersArray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RemoveDupsIIFromSortedArray {

    @Test
    public void test1() {
        int[] nums = {1,1,1,2,2,3};
        int op1 = removeDupsUsingSlidingWindow(nums);
        System.out.println(op1);

    }
    @Test
    public void test2() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int op1 = removeDupsUsingSlidingWindow(nums);
        System.out.println(op1);


    }
    /*
    -- if nums.length is less than or equal to 2
    --   return nums.length              (arrays of size 0,1,2 already satisfy "at most twice")

     -- initialise k as 2                 (k = write pointer; first 2 elements are always kept as-is)

      -- traverse i from 2 to nums.length-1     (i = read pointer, scanning the rest)

        --   if nums[i] is NOT equal to nums[k-2]
         --     (this means nums[i] is different from the element 2 positions back
      --      in our "kept so far" result — so keeping it won't create a 3rd duplicate)
     --     assign nums[i] to nums[k]
      --     increment k

      -- return k
     */

    private int removeDupsUsingSlidingWindow(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int k=2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i]!=nums[k-2]){
                nums[k]=nums[i];
                k++;
            }
        }

        return k;
    }
}
