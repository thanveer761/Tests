package DuplicateNumbersArray;

import org.junit.jupiter.api.Test;

public class FindDuplicateNums {

    @Test
    public void test1() {
        int[] nums={3,1,3,4,2};
      int op= findDups(nums);
        System.out.println(op);
    }
    /*
    brute force:
   * traverse with outer index i (0 to n-1)
   * for each i, traverse inner index j from i+1 to n-1
   * if nums[i] == nums[j], we found the duplicate → return nums[i]
   * if no match found after checking all pairs, return -1
     */
    public int findDups(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                if(nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return  -1;
    }
}
