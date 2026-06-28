package day1;

import org.junit.jupiter.api.Test;

public class FindDuplicateNums {

   /* Problem solving template

1.Did I understand the problem? yes
    If no ask the person to provide with more details with examples
    If yes go to the next step

    What is the input(s)?  int[] nums={3,1,3,4,2};
    What is the expected output? return duplicate example-->3
    Do I’ve constraints to solve the problem? yes
    Do Ive all the information to go to the next steps--yes
    How big is your test data set will be? 5

2.Test data set
    Minimum  3 data set including positive, negative and edge
    Validate with the interviewer if the data set is fine by his/ her assumptions
3.Do I know to solve it?
    Yes- great is there an alternate ?
    No - can I break the problem into sub problems?

 4.Ask for hint (if you don’t know how to solve this
            5.  Do I know alternate solutions as well
            Yes- what are those?
            No- that is still fine, proceed to solve by what you know

                                        Simple technique brute force

6.If you know the alternate solution find out the O-notations (performance)
7.Then, explain either both are the best (depends on the time)
    Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
    Approach 2: Write down the options and benefits and code the best
8.Start always with the Pseudo code (explain the pseudo code to the interviewer with some test data)
    -write the code
9.Test against different test data
10.If it fails then debug to solve it
11.Optimize the code and remove unnecessary code

*/

    @Test
    public void test1() {
        int[] nums={3,1,3,4,2};
      int op= findDups(nums);
        System.out.println(op);
    }
    /*
    brute force:
   * traverse with outer index i (0 to n-1)
   * for each i, traverse inner index j from i+1 to n-1
   * if nums[i] == nums[j], we found the duplicate → return nums[i]
   * if no match found after checking all pairs, return -1
     */
    public int findDups(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                if(nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return  -1;
    }
}
