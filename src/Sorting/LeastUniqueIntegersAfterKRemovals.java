package Sorting;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LeastUniqueIntegersAfterKRemovals {

    @Test
    public void test1() {
        int[] arr = {5, 5, 4};
        int k = 1;
        System.out.println(findLeastNumOfUniqueInts(arr, k)); // expect 1
    }

    @Test
    public void test2() {
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int k = 3;
        System.out.println(findLeastNumOfUniqueInts(arr, k)); // expect 2
    }
    /*
    * GOAL: minimize the number of unique integers remaining after removing k elements

    * build freq = map of number -> count of occurrences
    * extract just the frequency VALUES into a list
    * sort the frequency list in ascending order

    * initialize uniqueCount = number of distinct values (size of freq map)

    * traverse the sorted frequency list
        * if k >= current frequency:
            - we can afford to remove ALL copies of this number
            - subtract this frequency from k
            - decrement uniqueCount by 1 (one fewer distinct number remains)
        * else:
            - not enough budget left to fully remove this number
            - stop (can't eliminate this or any remaining number, since they only get bigger)

    * return uniqueCount
    */
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(freq.values());
        Collections.sort(counts);

        int uniqueCount = freq.size();

        for (int count : counts) {
            if (k >= count) {
                k -= count;
                uniqueCount--;
            } else {
                break;
            }
        }

        return uniqueCount;
    }
}