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
* GOAL: find all numbers that appear more than once in the array,
*        returned in sorted order with no duplicates in the result itself

* initialize seen = empty HashSet (tracks numbers we've encountered before)
* initialize dups = empty TreeSet (tracks numbers found to be duplicates,
    kept sorted automatically since TreeSet maintains ascending order,
    and naturally avoids adding the same duplicate value more than once)

* traverse each number n in nums
    * try to add n into seen
        - Set.add() returns FALSE if n was ALREADY present in the set
        - if the add fails (meaning n was already seen before):
            - add n into dups (it's confirmed as a duplicate)

* if dups is empty (no duplicates found at all):
    - return a special array {-1} as a sentinel signaling "none found"

* otherwise:
    - create a result array sized to match dups
    - copy each value from dups into result, in order
    - return result
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
