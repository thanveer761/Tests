package DuplicateNumbersArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class returnLargetsNumsInArray {
    @Test
    public void test1() {
        int[] nums={5,78,90,7,6};
        int op= returnLargestNums(nums);
        System.out.println(op);
    }
    @Test
    public void test2() {
        int[] nums={-7,-9,-8,-3};
        int op= returnLargestNums(nums);
        System.out.println(op);

    }
    @Test
    public void test3() {
        int[] nums = {};
        assertThrows(IllegalArgumentException.class, () -> returnLargestNums(nums));
    }
    @Test
    public void test4() {
        int[] nums={9,9,7,8,1};
        int op= returnLargestNums(nums);
        System.out.println(op);
    }
    /*
    brute force:
    * initialize maxindex as 0
   * traverse and check if nums value greater than maxindex
   * if true store greatest value index to maxindex
   *retur maxindex
     */
    public int returnLargestNums(int[] nums){
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int maxInd=0;
        for (int i = 1; i < nums.length; i++) {
                if(nums[i]>=nums[maxInd]){
                maxInd=i;
                }
            }

        return  maxInd;
    }
}

