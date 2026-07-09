package Arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {

    @Test
    public void test1() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] op= arrIntersection(nums1,nums2);
        System.out.println(Arrays.toString(op));
    }
    @Test
    public void test2() {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] op= arrIntersection(nums1,nums2);
        System.out.println(Arrays.toString(op));
    }

/*
-- initialise an empty set called set1

-- traverse each number n in nums1
--   add n to set1                      (store all unique values from nums1)

-- initialise an empty set called result

-- traverse each number n in nums2
--   if set1 contains n
--     add n to result                  (n is in both arrays, and sets auto-avoid duplicates)

-- convert result set into an int array
-- return the array
*/

    private int[] arrIntersection(int[] nums1, int[] nums2) {

            Set<Integer> set1 = new HashSet<>();
            for (int n : nums1) set1.add(n);

            Set<Integer> result = new HashSet<>();
            for (int n : nums2) {
                if (set1.contains(n)) {
                    result.add(n);
                }
            }

            int[] op = new int[result.size()];
            int i = 0;
            for (int n : result) op[i++] = n;
            return op;
        }
    }

