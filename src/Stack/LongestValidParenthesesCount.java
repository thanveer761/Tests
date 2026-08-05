package Stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestValidParenthesesCount {

    @Test
    public void test1() {
        String s = "(()";
        assertEquals(2, longestValidParens(s));
    }

    @Test
    public void test2() {
        String s = ")()())";
        assertEquals(4, longestValidParens(s));
    }

    @Test
    public void test3() {
        String s = "";
        assertEquals(0, longestValidParens(s));
    }
    /*
    * GOAL: find the LENGTH of the longest valid (well-formed) parentheses substring

    * initialize stack, push -1 onto it (base marker)
    * initialize maxLen = 0

    * traverse using pointer i from 0 to length-1
        * if s.charAt(i) == '(':
            - push i onto stack

        * else (s.charAt(i) == ')'):
            - pop the stack
            - if stack is now empty:
                - this ')' has no match; push i as a new base marker
            - else:
                - stack NOT empty means this ')' matched something
                - currentLen = i - stack.peek()
                - update maxLen = max(maxLen, currentLen)

    * return maxLen
    */
    public int longestValidParens(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int currentLen = i - stack.peek();
                    maxLen = Math.max(maxLen, currentLen);
                }
            }
        }

        return maxLen;
    }
}