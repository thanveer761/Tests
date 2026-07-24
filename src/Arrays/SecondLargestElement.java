package Arrays;

import org.junit.jupiter.api.Test;

public class SecondLargestElement {

    @Test
    public void positiveCase() {
        // normal case: distinct values, second largest clearly exists
        int[] nums = {9, 10, 13, 15, 18};
        System.out.println(secondLargest(nums)); // expect 15
    }

    @Test
    public void negativeCase_withDuplicates() {
        // largest value repeats -> must not treat the duplicate as "second largest"
        int[] nums = {5, 8, 8, 3, 1};
        System.out.println(secondLargest(nums)); // expect 5 (not 8)
    }

    @Test
    public void edgeCase_allSameElements() {
        // every element is identical -> no valid "second largest" exists
        int[] nums = {7, 7, 7, 7};
        System.out.println(secondLargest(nums)); // expect Integer.MIN_VALUE (no second largest found)
    }
    /*
   * GOAL: find the second largest element in an array

     * initialize largest = Integer.MIN_VALUE (smallest possible value, so any real number beats it)
* initialize secondLargest = Integer.MIN_VALUE

* traverse every num in nums
    * if num > largest:
        - current largest becomes the new secondLargest (it's been "demoted")
        - num becomes the new largest

    * else if num > secondLargest AND num != largest:
        - num isn't bigger than the current largest, but it beats the current secondLargest
        - (the != largest check avoids counting a duplicate of the largest value
           as if it were a distinct "second largest")
        - update secondLargest = num

* after traversal, secondLargest holds the answer
* print secondLargest
*/

    public int secondLargest(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}