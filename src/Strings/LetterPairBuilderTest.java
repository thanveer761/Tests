package Strings;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterPairBuilderTest {

    @Test
    public void positiveCase() {
        // normal mixed-case input with duplicate letters -> unique letters sorted, paired Upper+lower
        String input = "AcBCbDEdea";
        assertEquals("AaBbCcDdEe", solve(input));
    }

    @Test
    public void negativeCase() {
        // input with no letters at all (only digits/symbols) -> no pairs produced
        String input = "123!@#456";
        assertEquals("", solve(input));
    }

    @Test
    public void edgeCase_emptyString() {
        // empty string -> loop never runs, result stays empty
        String input = "";
        assertEquals("", solve(input));
    }

    public String solve(String str) {
        TreeSet<Character> uniqueLetters = new TreeSet<>();
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                uniqueLetters.add(Character.toUpperCase(ch));
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : uniqueLetters) {
            result.append(Character.toUpperCase(ch));
            result.append(Character.toLowerCase(ch));
        }

        return result.toString();
    }
}