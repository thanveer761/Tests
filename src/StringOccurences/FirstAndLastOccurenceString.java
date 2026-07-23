package StringOccurences;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class FirstAndLastOccurenceString {

    @Test
    public void test1() {
        String s = "amaz";
        List<String> result1 = firstAndLastOccurenceString1(s);
        System.out.println(result1);
        firstAndLastOccurenceString2(s);
    }

        /*pseudocode:
       - create a boolean[] visited of size 256 (covers all ASCII characters)
       - guard: if string is null or empty, print message and stop
      - traverse the string character by character:
      - store current char as ch
       - if ch is NOT visited:
        - mark visited[ch] = true
        - print ch, s.indexOf(ch) as first occurrence, s.lastIndexOf(ch) as last occurrence

         */
        private List<String> firstAndLastOccurenceString1 (String s){  // fix 2: void since we're printing
            List<String> result = new ArrayList<>();
            if (s == null || s.isEmpty()) {
                System.out.println("null or empty string");
                return result;
            }

            boolean[] visited = new boolean[256];  // 256 covers all ASCII characters

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (!visited[ch]) {
                    visited[ch] = true;
                    result.add("char--'" + ch + "'--first--" + s.indexOf(ch) + "--last--" + s.lastIndexOf(ch));
                }
            }

            return result;
        }

    private void firstAndLastOccurenceString2 (String s) {
        LinkedHashMap<Character, int[]> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new int[]{i, i});  // first time seen: first=i, last=i
            } else {
                map.get(ch)[1] = i;            // seen again: update last index
            }
        }
        for (var entry : map.entrySet()) {
            System.out.println("char='" + entry.getKey() + "' first=" + entry.getValue()[0] + " last=" + entry.getValue()[1]);
        }
    }
    }