package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class PreviousSmallerElements {

    @Test
    public void test() {
        int[] nums = {1, 5, 0, 3, 2, 4};
        Assertions.assertArrayEquals(new int[]{-1, 1, -1, 0, 0, 2}, findPreviousSmaller(nums));
    }

    @Test
    public void test1() {
        int[] nums = {1, 5, 5, 3, 2, 2, 4};
        Assertions.assertArrayEquals(new int[]{-1, 1, 1, 1, 1,1, 2}, findPreviousSmaller(nums));
    }

    @Test
    public void test2() {
        int[] nums = {8, 8, 2, 2, 4, 9, 1, 1, 5, 10};
        Assertions.assertArrayEquals(new int[]{-1, -1, -1, -1, 2, 4, -1, -1, 1, 5}, findPreviousSmaller(nums));
    }
    /*
    * GOAL: for each element, find the closest element to its LEFT
    *        that is strictly smaller than it

    * initialize output array of same size as nums
    * initialize an empty stack

    * traverse using pointer i from 0 to n-1 (left to right)
        * while stack is NOT empty AND nums[i] <= stack.peek():
            - pop the stack
              (this candidate is not smaller than nums[i], so it can never
               be a valid "previous smaller" for nums[i] or anything after it)
            - if stack is now empty:
                - output[i] = -1 (no smaller element found so far)

        * if stack is NOT empty AND nums[i] > stack.peek():
            - output[i] = stack.peek() (closest valid smaller element to the left)

        * push nums[i] onto the stack
          (it might become the "previous smaller" for elements coming next)

    * return output
    */
    public int[] findPreviousSmaller(int[] nums){
        int[] output= new int[nums.length];
        output[0]=-1;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<nums.length;i++){
            while (!stack.isEmpty() && nums[i]<=stack.peek()){
                stack.pop();
                if(stack.isEmpty())
                    output[i]=-1;
            }
            if(!stack.isEmpty() && nums[i]>stack.peek()){
                output[i]=stack.peek();
            }

            stack.push(nums[i]);
        }
        return output;
    }
}