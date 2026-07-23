package Strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecodeRunLengthString {

    @Test
    public void positiveCase() {
        // normal case: multiple characters, each followed by a repeat count
        String input = "a3b2c1";
        assertEquals("aaabbc", decode(input));
    }

    @Test
    public void negativeCase() {
        // a character with repeat count 0 should contribute nothing to output
        String input = "a0b2";
        assertEquals("bb", decode(input));
    }

    @Test
    public void edgeCase_emptyString() {
        // empty input -> empty output
        String input = "";
        assertEquals("", decode(input));
    }

    /*
    * GOAL: decode a string where every character is immediately followed
    *        by a single digit representing how many times to repeat it

    * initialize result = empty StringBuilder

    * traverse using pointer i from 0 to length-1, stepping by 2 each time
        * let ch = character at index i        (the letter)
        * let count = digit at index i+1, converted from char to int
                       (the repeat count for that letter)

        * append ch to result, count number of times

    * return result as a string
    */

    public String decode(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2) {
            char ch = s.charAt(i);
            int count = s.charAt(i + 1) - '0';

            for (int j = 0; j < count; j++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}