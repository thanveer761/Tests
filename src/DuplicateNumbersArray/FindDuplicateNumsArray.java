package DuplicateNumbersArray;

import org.junit.jupiter.api.Test;

import java.util.*;

public class FindDuplicateNumsArray {

    @Test
    public void test1() {
        int[] nums = {3, 5, 7, 9, 7, 5};
        int[] op= findDupsNumArr(nums);
        System.out.println(Arrays.toString(op));


    }


    /*
    brute force:
   * traverse with outer index i (0 to n-1)
   * for each i, traverse inner index j from i+1 to n-1
   * if nums[i] == nums[j], we found the duplicate → return nums[i]
   * if no match found after checking all pairs, return -1
     */

    public int[] findDupsNumArr(int[] nums){

            Set<Integer> seen = new HashSet<>();
            Set<Integer> dups = new TreeSet<>();

            for (int n : nums) {
                if (!seen.add(n)) {
                    dups.add(n);
                }
            }

            if (dups.isEmpty()) {
                return new int[]{-1};
            }

            int[] result = new int[dups.size()];
            int i = 0;
            for (int d : dups) {
                result[i] = d;
                i++;
            }
            return result;
        }
       }
