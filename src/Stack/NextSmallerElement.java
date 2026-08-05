package Stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    @Test
    public void test1() {
        int[] arr = {4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(nextSmallerElement(arr))); // expect [2, 5, 2, -1, -1]
    }

    @Test
    public void test2() {
        int[] arr = {13, 7, 6, 12};
        System.out.println(Arrays.toString(nextSmallerElement(arr))); // expect [7, 6, -1, -1]
    }

    @Test
    public void test3() {
        int[] arr = {4, 1};
        System.out.println(Arrays.toString(nextSmallerElement(arr))); // expect [1, -1]
    }
    /*
    * GOAL: for each element, find the next element to its right that is strictly smaller

    * initialize result array of same size as arr
    * initialize an empty stack

    * traverse using pointer i from n-1 down to 0 (right to left)
        * while stack is NOT empty AND stack.peek() >= arr[i]:
            - pop the stack (this element can never be useful again,
              since arr[i] is closer and smaller)

        * if stack is empty:
            - result[i] = -1 (no valid next smaller element found)
        * else:
            - result[i] = stack.peek() (the current top is the closest valid smaller element)

        * push arr[i] onto the stack
          (it might become the answer for something even further to the left)

    * return result
    */
    public int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        return result;
    }
}