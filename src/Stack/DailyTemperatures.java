package Stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    @Test
    public void test1() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures))); // expect [1,1,4,2,1,1,0,0]
    }

    @Test
    public void test2() {
        int[] temperatures = {30, 40, 50, 60};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures))); // expect [1,1,1,0]
    }

    @Test
    public void test3() {
        int[] temperatures = {30, 60, 90};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures))); // expect [1,1,0]
    }
    /*
    * GOAL: for each day, find how many days until a warmer temperature occurs

    * initialize answer array of size n, all zeros
    * initialize an empty stack (holds INDICES, not temperature values)

    * traverse using pointer i from n-1 down to 0
        * while stack is NOT empty AND temperatures[stack.peek()] <= temperatures[i]:
            - pop the stack (this day can never be "the answer" for anything
              further left, since day i is closer and at least as warm)

        * if stack is empty:
            - answer[i] = 0 (no warmer day found ahead)
        * else:
            - answer[i] = stack.peek() - i (the day-gap to the next warmer day)

        * push i onto the stack

    * return answer
    */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            stack.push(i);
        }

        return answer;
    }
}