package DuplicateNumbersArray;

import org.junit.jupiter.api.Test;
import java.util.*;

public class FindDuplicateNums {

    @Test
    public void test1() {
        int[] nums={3,1,3,4,2};
      int op= findDups(nums);
        System.out.println(op);
        int op1=findDupsUsingTwoPointer(nums);
        System.out.println(op1);

    }

    @Test
    public void test2() {
        int[] nums={1,2,3,4,5};
        int op= findDups(nums);
        System.out.println(op);
        int op1=findDupsUsingTwoPointer(nums);
        System.out.println(op1);

    }
    @Test
    public void test3() {
        int[] nums={3,3,3};
        int op= findDups(nums);
        System.out.println(op);
        int op1=findDupsUsingTwoPointer(nums);
        System.out.println(op1);

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
    public int findDupsUsingTwoPointer(int[] nums){
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                return nums[left];
            }
            left++;
            right++;
        }
        return -1;
       }
}
