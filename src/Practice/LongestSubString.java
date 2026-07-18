package Practice;
import java.util.*;
public class LongestSubString {

  //  Pseudocode:approach sliding window using hashset:-
        /*
         * initialise left pointer and maxLen as 0
         *initialize set with var name as window
         *traverse from right index and check if the character is present in the window
         *if present remove from left and increment the left
         * if not add it to the window
         * and, compute the maxLen with right-left+1
         * return maxLen

         */
        //Tc-O[N]
        //sc-o[1]

        public static int longestSub(String s){
            int left=0, maxLen=0;
            if (s.isEmpty()) {
                throw new IllegalArgumentException("string is empty");
            }
            Set<Character> window= new HashSet<>();
            for(int right=0;right<s.length();right++){
                Character c= s.charAt(right);
                while(window.contains(c)){
                    window.remove(s.charAt(left));
                    left++;
                }
                window.add(c);
                maxLen=Math.max(maxLen, right-left+1);
            }
            return maxLen;

        }
        public static void main(String[] args) {
            int op= longestSub("abcabcbb");
            System.out.println(op);
            int op1= longestSub("bbbbb");
            System.out.println(op1);
            int op2= longestSub("pwwkew");
            System.out.println(op2);
        }
    }
