package Stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class LongestValidParentheses {

    @Test
    public void test1() {
        String s = "(()";
        System.out.println(longestValidParens(s)); // expect "()"
    }

    @Test
    public void test2() {
        String s = ")()())";
        System.out.println(longestValidParens(s)); // expect "()()"
    }

    @Test
    public void test3() {
        String s = "";
        System.out.println(longestValidParens(s)); // expect ""
    }
/*
i=0, ch=')':
  pop stack → removes -1 → stack = []
  stack is empty → push i(0) as new base → stack = [0]

i=1, ch='(':
  push i(1) → stack = [0, 1]

i=2, ch=')':
  pop stack → removes 1 → stack = [0]
  stack NOT empty → length = i(2) - top(0) = 2
  maxLen = 2, this substring is s[0+1..2] = s[1..2] = "()"

i=3, ch='(':
  push i(3) → stack = [0, 3]

i=4, ch=')':
  pop stack → removes 3 → stack = [0]
  stack NOT empty → length = i(4) - top(0) = 4
  maxLen = 4, this substring is s[0+1..4] = s[1..4] = "()()"

i=5, ch=')':
  pop stack → removes 0 → stack = []
  stack is empty → push i(5) as new base → stack = [5]
 */
    public String longestValidParens(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLen = 0;
        int maxStart = 0;

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
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                        maxStart = stack.peek() + 1;
                    }
                }
            }
        }
        if (maxLen == 0) {
            return "";
        }
        return s.substring(maxStart, maxStart + maxLen);
    }
}