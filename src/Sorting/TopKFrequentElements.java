package Sorting;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TopKFrequentElements {

    @Test
    public void test1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k))); // expect [1,2] (any order)
    }

    @Test
    public void test2() {
        int[] nums = {1};
        int k = 1;
        System.out.println(Arrays.toString(topKFrequent(nums, k))); // expect [1]
    }

    @Test
    public void test3() {
        int[] nums = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k))); // expect [1,2]
    }
    /*
    * GOAL: find the k most frequent elements in nums, using sorting

    * create map = HashMap of number -> count of occurrences
        * traverse nums, incrementing map[element] for each occurrence

    * convert map's entries into a List
        (so they can be sorted, since maps themselves have no guaranteed order)

    * sort the list by frequency, in DESCENDING order
        (so the most frequent numbers come first)

    * create result array of size k

    * traverse using pointer i from 0 to k-1
        * take the key (the number) from the i-th entry in the sorted list
        * store it in result[i]

    * return result
    */
        public int[] topKFrequent(int[] nums, int k) {

            // Step 1: Count frequency of every number
            HashMap<Integer,Integer> map = new HashMap<>();

            for(int element : nums){
                map.put(element, map.getOrDefault(element,0)+1);
            }

            // Step 2: Convert HashMap into a List
            ArrayList<Map.Entry<Integer,Integer>> arr =
                    new ArrayList<>(map.entrySet());

            // Step 3: Sort by frequency in descending order
            arr.sort((a,b)->b.getValue()-a.getValue());

            // Step 4: Pick first K elements
            int[] last = new int[k];

            for(int i=0;i<k;i++){
                last[i]=arr.get(i).getKey();
            }

            return last;
        }
    }
