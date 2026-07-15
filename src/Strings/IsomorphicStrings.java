package Strings;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    @Test
    public void test1() {
        String s = "egg";
        String t = "add";
    //    boolean op = isomorphic(s, t);
    //    System.out.println(op);
        boolean op1 = isIsomorphic(s, t);
        System.out.println(op1);
    }

    @Test
    public void test2() {
        String s = "f11";
        String t = "b23";
     //   boolean op = isomorphic(s, t);
   //     System.out.println(op);
        boolean op1 = isIsomorphic(s, t);
        System.out.println(op1);
    }
    /*
    /**
 * initialise a single HashMap called hm to store mapping from characters of s to characters of t
 * initialise n = length of string s
 * iterate through the strings s and t together using index i from 0 till n
 * - for every index i, take the current character from s (call it ch1) and from t (call it ch2)

 * - check if ch1 already exists as a key in hm
 *   - if it exists, verify its mapped value equals ch2, if not return false (ch1 is trying to map to two different characters)
 *   - else if ch2 already exists as a value somewhere in hm (mapped from a different key), return false (two different characters can't map to the same character)

 * - put/update the mapping ch1 -> ch2 into hm

 * proceed to the next index and repeat

 * after the loop completes without conflicts, return true

 * TC: O(n)
 * SC: O(1)
 */
     */


    public boolean isIsomorphic(String s, String t) {

            HashMap<Character,Character> hm = new HashMap<>();
            int n=s.length();
            for(int i=0;i<n;i++)
            {
                char ch1 = s.charAt(i);
                char ch2 = t.charAt(i);
                if(hm.containsKey(ch1))
                {
                    if(hm.get(ch1)!=ch2)
                        return false;
                }
                else if(hm.containsValue(ch2))
                {
                    return false;
                }
                hm.put(ch1,ch2);

            }
            return true;
        }
    }
