package SlidingWindow;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    @Test
    public void test1(){
        String s = "pwwkew";
        int op=longestSubString(s);
        System.out.println(op);

    }
    @Test
    public void test2(){
        String s = "abcabcbb";
        int op=longestSubString(s);
        System.out.println(op);

    }
    /*
   * initialize left pointer as 0 and maxLen as 0, and an empty set (the "window")
   * traverse using right pointer from 0 to end of string
    * let c = character at right
    * while c is already present in the window:
          - remove the character at the left pointer from the window
          - move left pointer forward by 1
      (this shrinks the window from the front until c is no longer a duplicate)
    * add c to the window
    * update maxLen = max(maxLen, right - left + 1)
    * finally, return maxLen
     */
    public int longestSubString(String s){
        int left=0,maxLen=0;
        Set<Character> window= new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
           char c= s.charAt(right);
           while (window.contains(c)){
               window.remove( s.charAt(left));
               left++;
           }
           window.add(c);
maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }

}
