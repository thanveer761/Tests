package Strings;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class encodeString {

    @Test
    public void positiveCase() {
        // normal case: multiple characters, each followed by a repeat count
        String s = "aaaabbccdddddeeeaabb";
        String op=encodeI(s);
        System.out.println(op);
        String op1=encodeII(s);
        System.out.println(op1);

    }

    @Test
    public void negativeCase() {
        // a character with repeat count 0 should contribute nothing to output
        String s = "abab";
        String op=encodeI(s);
        System.out.println(op);
        String op1=encodeII(s);
        System.out.println(op1);

    }
    /*
    /*
    --initialize a string builder as result
    --initialize count as 1
    --traverse using i from 1 till length of s
    --if s.charAt(i) equals s.charAt(i-1)
      --increment count
    --else
      --append s.charAt(i-1) and count to result
      --reset count to 1
  --after loop ends, append the last character and its count to result
  --return result
*/
    public String encodeI(String s) {
        StringBuilder result=new StringBuilder();
        int count=1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                result.append(s.charAt(i-1)).append(count);
                count=1;
            }

        }
       result.append(s.charAt(s.length() - 1)).append(count);

        return result.toString();
    }

    /*
  --initialize a LinkedHashMap called freq (stores character -> total count,
    keeps order of first appearance)

  --traverse every character ch in s
    --if ch already exists as a key in freq
      --increment its stored count by 1
    --else
      --add ch to freq with a starting count of 1

  --initialize a string builder as result

  --traverse each entry in freq, in insertion order
    --append the character and its count to result

  --return result
*/

    public String encodeII(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            result.append(entry.getKey()).append(entry.getValue());
        }

        return result.toString();
    }
}
