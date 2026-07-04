package day1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TwoSum {

   /* Problem Solving Template

    1. Understand the problem

    Did I understand the problem? Yes / No
    If no — ask the person for more details with examples.
    If yes — go to the next step.


    What is/are the input(s)?
    What is the expected output?
    Do I have constraints to solve the problem?
    Do I have all the information to go to the next steps?
    How big will the test data set be?


            2. Test data set


    Minimum 3 data sets including positive, negative, and edge cases.
    Validate with the interviewer if the data set fits their assumptions.


            3. Do I know how to solve it?


    Yes — great, is there an alternate solution?
    No — can I break the problem into sub-problems?


            4. Ask for a hint


    If I don't know how to solve this, ask for a hint.


            5. Alternate solutions


    Do I know alternate solutions as well?

    Yes — what are those?
    No — that's still fine, proceed to solve by what you know: the simple technique, brute force.

            6. Performance (Big-O)

    If I know an alternate solution, find out its Big-O notation (performance).

            7. Pick the best approach


    Explain which approach is best (depends on time available).
    Approach 1 — start with the worst, improve/optimize, end up with the best.
            Approach 2 — write down the options and benefits, then code the best one.


            8. Pseudocode, then code


    Always start with pseudocode.
    Explain the pseudocode to the interviewer using some test data.
    Write the actual code.


            9. Test it


    Test against different test data.


10. Debug


    If it fails, debug to solve it.


            11. Optimize


    Optimize the code and remove unnecessary code.*/
    @Test
    public void test1() {
        int[] nums={2,3,5,7};
        int target=9;
        int[] op= twoSum(nums,target);
        System.out.println(Arrays.toString(op));
        int[] op1= twoSumTwoPointer(nums,target);
        System.out.println(Arrays.toString(op1));

    }
    /*
    *pseudocode: Bruteforce-->o[N2]
    if array is empty trow an exception
    traverse with outer index i (0 to n.len)
    for each i, traverse inner index j from i+1 to n.len
   *if nums of i +j equals to target
    we found it return of i & j
    *if not found return -1,-1*/



    public int[] twoSum(int[] nums, int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){

                   return new int[] {i,j};
                }
            }

        }
        return new int[] {-1,-1};
}

    /*two pointer:
       --initialize left ponter as 0 and right pointer till last index
       ---condition left< right
       ---sum ==target
        --return the index of left, right
       --if sum< target
       --increment left++
       ---else right --

       --return -1,-1

        */
    public int[] twoSumTwoPointer(int[] nums, int target){
       int left=0, right= nums.length-1;
       while(left<right){
           int sum = nums[left] + nums[right];
           if (sum == target) {
               return new int[]{left, right};
           } else if (sum < target) {
               left++;
           } else {
               right--;
           }
       }
        return new int[]{-1, -1};
    }
}
