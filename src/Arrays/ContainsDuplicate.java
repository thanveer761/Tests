package Arrays;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums)); // expect true
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums)); // expect false
    }

    @Test
    public void test3() {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums)); // expect true
    }
    /*
    * GOAL: determine if any value appears more than once in nums

    * initialize an empty set called seen

    * traverse each num in nums
        * if seen already contains num:
            - a duplicate was found
            - return true immediately

        * otherwise, add num to seen

    * if the loop completes without finding any duplicate
        - return false
    */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }
}