package Sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleSort {

    @Test
    public void test1(){
        int[] nums={5,1,3,4,2};
        int[] op=bubbleSort(nums);
        System.out.println(Arrays.toString(op));
    }

   /*
* GOAL: sort an array by repeatedly comparing adjacent elements
*        and swapping them if they're in the wrong order

* traverse using pointer i from 0 to n-2
    * traverse using pointer j from 0 to (n-2-i)
        (shrinks by 1 each outer pass, since the last i elements
         are already sorted and don't need re-checking)

        * if nums[j] > nums[j+1]:
            - they are out of order
            - swap nums[j] and nums[j+1]
              (the bigger value "bubbles" one step to the right)

* after all passes, array is sorted
* return nums
*/

    public int[] bubbleSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1; j++) {
                if (nums[j] > nums[j + 1]) {
                int temp=nums[j];
                nums[j]=nums[j+1];
                nums[j+1]=temp;
            }}
        }
        return nums;
    }
}
