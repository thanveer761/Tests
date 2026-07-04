package Strings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ReverseEvenLetters {
    @Test
    public void test1() {
        String s = "thanveer";
        String op = reverseEvenLetters(s);
        System.out.println(op);
    }

    private String reverseEvenLetters(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> ls = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0) {
                ls.add(s.charAt(i));
            }
        }
        int evenChar = ls.size() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0) {
                sb.append(ls.get(evenChar--));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
