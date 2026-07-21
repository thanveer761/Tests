package Strings;

import org.junit.jupiter.api.Test;

public class LongestNiceSubString {
    @Test
    public void test1(){
        String s = "YazaAay";
        String op1= longestNiceSubstring(s);;
        System.out.println(op1);
    }
    @Test
    public void test2(){
        String s="Bb";
        String op1= longestNiceSubstring(s);;
        System.out.println(op1);
    }
    @Test
    public void test3(){
        String s="c";
        String op1= longestNiceSubstring(s);;
        System.out.println(op1);
    }
    /*
    /*
* GOAL: find the longest "nice" substring of s
*   (a string is "nice" if every letter that appears also appears
*    in both its uppercase AND lowercase form)

* initialize len = length of s
* if len < 2, return "" (a single character can never satisfy both-case requirement)

* create lower[26] = boolean array tracking which lowercase letters appear in s
* create upper[26] = boolean array tracking which uppercase letters appear in s

* traverse every character c in s
    * if c is lowercase:
        - mark lower[c - 'a'] = true
    * else (c is uppercase):
        - mark upper[c - 'A'] = true

* traverse using pointer i from 0 to len-1
    * let c = character at i
    * let index = lowercase version of c, mapped to 0-25 (c - 'a' after lowering)

    * if lower[index] != upper[index]:
        (this means c's letter appears in only ONE case, not both —
         so c can never be part of any nice substring;
         it must act as a "splitter" dividing the string)

        - recursively find the longest nice substring in the LEFT part (before i)
        - recursively find the longest nice substring in the RIGHT part (after i)
        - return whichever of left/right is longer
          (if tied, return left, per the >= comparison)

* if no splitting character was found (loop completes with no mismatch):
    - the entire string s is already nice
    - return s
*/


        public String longestNiceSubstring(String s) {
            int len = s.length();
            if(len < 2) return "";

            boolean[] lower = new boolean[26];
            boolean[] upper = new boolean[26];
            for(char c : s.toCharArray()){
                if(Character.isLowerCase(c)){
                    lower[c - 'a'] = true;
                }else{
                    upper[c - 'A'] = true;
                }
            }

            for(int i = 0 ; i < len ; i++){
                char c = s.charAt(i);
                int index = Character.toLowerCase(c) - 'a';
                if(lower[index] != upper[index]){
                    String left = longestNiceSubstring(s.substring(0,i));
                    String right = longestNiceSubstring(s.substring(i+1));
                    return left.length() >= right.length() ? left : right;
                }
            }
            return s;
        }
    }
