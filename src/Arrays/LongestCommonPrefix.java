package Arrays;

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

    /*
    pseudocode: 0[n*m]
    * initialize an empty op variable
    *traverse through each word
      --extract the charaacter for 1st word
      *traverse the each character from j at 1st index
      *return the op if misatch found for strs[j] with character i
      *if match foun append character to op
     */
    public String longestCommonPrefix(String[] strs){
        String op="";
        for (int i = 0; i < strs[0].length() ; i++) {
            char c= strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i>= strs[j].length()||strs[j].charAt(i)!=c){
                    return op;
                }

            }
            op+=c;
        }
        return op;
    }
    /*0[N log N]
       *sort the array
       * take first and last words
       * traverse and compare if the words present in first character and last character are same increment the index
       * and, return substring of first word

     */

    public String longestCommonPrefix1(String[] strs){
        Arrays.sort(strs);
        String first=strs[0];
        String last=strs[strs.length-1];
        int i=0;
        while(i<first.length()&&first.charAt(i)==last.charAt(i)){
            i++;
        }
        return first.substring(0,i);
    }
}
