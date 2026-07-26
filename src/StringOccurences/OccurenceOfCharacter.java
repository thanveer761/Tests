package StringOccurences;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class OccurenceOfCharacter {
    @Test
    public void test1() {
        String s = "ThanveerAhmed";
        String op = occurenceOfCharacter(s);
        System.out.println(op);
    }

    @Test
    public void test2() {
        String s = "aabbcc";
        String op = occurenceOfCharacter(s);
        System.out.println(op);
    }

    private String occurenceOfCharacter(String s) {
        Map<Character, Integer> mn = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mn.put(s.charAt(i), mn.getOrDefault(s.charAt(i), 0) + 1);
        }
        // Print each character with its frequency
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (mn.containsKey(ch)) {
                result.append(ch).append("-").append(mn.get(ch)).append(" ");
                mn.remove(ch); // remove to avoid printing duplicates
            }
        }
        return result.toString().trim();
    }
}
