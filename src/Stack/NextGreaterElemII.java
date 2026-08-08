package Stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElemII {

    @Test
    public void test1() {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElementII(nums))); // expect [2,-1,2]
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElementII(nums))); // expect [2,3,4,-1,4]
    }

    /*
    * GOAL: for each element, find the next greater element, wrapping around
    *        circularly if nothing greater is found before the array ends

    * initialize result array of size n
    * initialize an empty stack

    * traverse using pointer i from 2n-1 down to 0 (simulates two full passes)
        * idx = i % n (maps back to the real array index)

        * while stack is NOT empty AND stack.peek() <= nums[idx]:
            - pop the stack (this candidate is not useful anymore)

        * if i < n:
            - this is the "real" pass — record the answer
            - result[idx] = stack.isEmpty() ? -1 : stack.peek()

        * push nums[idx] onto the stack
          (do this on BOTH passes, so wrap-around candidates are available)

    * return result
    */

    public int[] nextGreaterElementII(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;

            while (!stack.isEmpty() && stack.peek() <= nums[idx]) {
                stack.pop();
            }

            if (i < n) {
                result[idx] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(nums[idx]);
        }

        return result;
    }
}