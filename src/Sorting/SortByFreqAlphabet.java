package Sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByFreqAlphabet {

    @Test
    public void test1() {
        String s1 = "tree";
        String op1 = sortByFreqAlphabet(s1);
        System.out.println(op1);
    }

    private String sortByFreqAlphabet(String s) {
        // Step 1: Count frequency of each character
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : ch) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sort by frequency (desc), then alphabetically (asc) for ties
        List<Character> ls = new ArrayList<>(map.keySet());
        ls.sort((a, b) -> {
            if (map.get(a) != map.get(b))
                return map.get(b) - map.get(a);   // higher frequency first
            return Character.compare(a, b);        // alphabetical for equal freq
        });

        // Step 3: Build result — repeat each char by its frequency
        StringBuilder ans = new StringBuilder();
        for (char c : ls) {
            int freq = map.get(c);
            while (freq-- > 0) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}
