package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {

    @Test
    public void test() {
        String s = "([])";
        Assertions.assertTrue(isValid(s));
    }

    @Test
    public void test1() {
        String s = "{(}[])";
        Assertions.assertFalse(isValid(s));
    }

    @Test
    public void test2() {
        String s = "()[]{}{()}";
        Assertions.assertTrue(isValid(s));
    }
    /*
    * GOAL: determine if a string of brackets is valid (properly matched and nested)

    * create a map: closing bracket -> its matching opening bracket
        (e.g., ')' -> '(', ']' -> '[', '}' -> '{')

    * initialize an empty stack

    * traverse each character ch in s
        * if stack is NOT empty
            AND ch is a closing bracket (exists as a key in the map)
            AND the top of the stack matches ch's expected opening bracket:
            - pop the stack (this pair successfully matched)

        * else:
            - push ch onto the stack
              (this covers opening brackets, and also closing brackets
               that didn't find a valid match)

    * after traversal, the string is valid ONLY IF the stack is empty
      (an empty stack means every opening bracket found its matching closer)

    * return whether the stack is empty
    */
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && map.containsKey(ch) && map.get(ch) == stack.peek()) {
                stack.pop();
            } else stack.push(ch);
        }
        return stack.isEmpty();
    }
}