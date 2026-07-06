package Strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LongestCommonPrefix {

    @Test
    public void test1(){
       String[] strs = {"flower","flow","flight"};
       String ans=longestCommonPrefix(strs);
        System.out.println(ans);
        String anss=longestCommonPrefix1(strs);
        System.out.println(anss);
    }
    @Test
    public void test2(){
        String[] strs = {"ab","a"};
        String ans=longestCommonPrefix(strs);
        System.out.println(ans);
        String anss=longestCommonPrefix1(strs);
        System.out.println(anss);
    }

    /*
    pseudocode: 0[n*m]
    * initialize an empty op variable
    *traverse through each word
      --extract the charaacter for 1st word
      *traverse the each character from j at 1st index
      *return the op if misatch found for strs[j] with character i
      *if match foun append character to op
     */
    public String longestCommonPrefix(String[] words) {
        String op = "";
        for (int i = 0; i < words[0].length(); i++) {
            char c = words[0].charAt(i);
            boolean matched = false;
            for (int j = 1; j < words.length; j++) {
                if (i >= words[j].length() || words[j].charAt(i) != c) {
                    matched = true;
                    break;
                }
            }
            if (matched) {
                break; // stop as soon as a mismatch is found
            }else {
                op += c;      // character matched in all words, keep it
            }

        }
        return op;
    }
    /*0[N log N]
       *sort the array
       * take first and last words
       * traverse and compare if the words present in first character and last character are same increment the index
       * and, return substring of first word

     */

    public String longestCommonPrefix1(String[] words){
        Arrays.sort(words);
        String first=words[0];
        String last=words[words.length-1];
        int i=0;
        while(i<first.length()&&first.charAt(i)==last.charAt(i)){
            i++;
        }
        return first.substring(0,i);
    }
}
