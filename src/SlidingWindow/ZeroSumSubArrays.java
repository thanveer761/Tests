package SlidingWindow;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroSumSubArrays {

    @Test
    public void test1() {
        int[] arr1 = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<String> op = findZeroSumSubarraysBrute(arr1);
        System.out.println(op);
        List<String> op1 = findZeroSumSubarraysHashMap(arr1);
        System.out.println(op1);
    }

    @Test
    public void test2() {
        int[] arr2 = {1, 2, -3, 3, -1, -1};
        List<String> op = findZeroSumSubarraysBrute(arr2);
        System.out.println(op);
        List<String> op1 = findZeroSumSubarraysHashMap(arr2);
        System.out.println(op1);
    }
    /*
    /*
* GOAL: find all subarrays in arr[] whose sum is 0, using a hashmap

* initialize n = length of arr
* initialize sum = 0 (running prefix sum)
* initialize result = empty list (to collect output messages)

* create a map: prefixSum -> list of indices where that prefix sum occurred
* put entry: prefixSum 0 -> list containing -1
    (this handles subarrays that start from index 0 and sum to zero,
     treating "before the array starts" as index -1)

* traverse using pointer i from 0 to n-1
    * add arr[i] to sum (sum = sum + arr[i])

    * if sum already exists as a key in the map:
        - get the list of previous indices stored under this sum
        - for every previous index j in that list:
            - a subarray from (j + 1) to i has sum 0
            - add "Subarray found from Index (j+1) to i" into result

    * add current index i to the list of indices for this sum in the map
      (create a new list if this sum hasn't been seen before,
       otherwise append to the existing list)

* after traversing entire arr, return result
*/

    public List<String> findZeroSumSubarraysHashMap(int[] arr) {
        int n = arr.length;
        int sum = 0;
        List<String> result = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(List.of(-1)));

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                List<Integer> indices = map.get(sum);
                for (int j : indices) {
                    result.add("Subarray found from Index " + (j + 1) + " to " + i);
                }
            }

            map.computeIfAbsent(sum, key -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public List<String> findZeroSumSubarraysBrute(int[] arr) {
        int n = arr.length;
        List<String> result = new ArrayList<>();

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += arr[end];
                if (sum == 0) {
                    result.add("Subarray found from Index " + start + " to " + end);
                }
            }
        }

        return result;
    }
}