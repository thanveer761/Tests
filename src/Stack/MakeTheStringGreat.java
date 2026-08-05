package Stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class MakeTheStringGreat {

    @Test
    public void test1() {
        String s = "leEeetcode";
        System.out.println(makeGood(s)); // expect "leetcode"
    }

    @Test
    public void test2() {
        String s = "abBAcC";
        System.out.println(makeGood(s)); // expect ""
    }

    @Test
    public void test3() {
        String s = "s";
        System.out.println(makeGood(s)); // expect "s"
    }

    /*
    * initialize an empty stack

    * traverse each character ch in s
        * if stack is NOT empty AND top of stack is opposite-case of ch (same letter):
            - pop the stack (cancels out both characters)
        * else:
            - push ch onto the stack

    * build result from stack contents, bottom to top
    * return result
    */

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}