package Strings;

import org.junit.jupiter.api.Test;

import java.util.*;


public class ReverseVowels {
    @Test
    public void test1(){
        String s1="ThanveerAhmed";
        String op1=reverseVowels(s1);
        System.out.println(op1);
      String op=reverseVowels2(s1);
        System.out.println(op);

    }

    //collect vowels position left to right
    //reveres the vowels
    //put back in same position
    /* Pseudocode:
     * initialize vowels
     * Create 2 list one for position and one for vowels
     * traverse through each index of string
       - if character at i is a vowel
       - add i to position list
       - add character to vowels list
     * reverse the vowels
     * traverse till position size
       - put each vowel back
       -at its matching position
     */
    public String reverseVowels(String s){
           String vow="aeiouAEIOU";
          char[] arr= s.toCharArray();
          //step 1: collect vowels position
        List<Character> vowels = new ArrayList<>();
        List<Integer> position = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if(vow.indexOf(arr[i])!=-1){
                position.add(i);
                vowels.add(arr[i]);
            }
        }
        Collections.reverse(vowels);
        for (int i = 0; i < position.size(); i++) {
            arr[position.get(i)]=vowels.get(i);
        }
        return new String(arr);
    }
    private boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'||c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        return false;
    }
    public String reverseVowels2(String s){
       char[] ch= s.toCharArray();
        int left=0, right=ch.length-1;
       while(left<right){
           if(isVowel(ch[left])&& isVowel(ch[right])){
               char temp= ch[right];
               ch[right--]=ch[left];
               ch[left++]=temp;
           } else if (isVowel(ch[left])) {
               right--;
           }else{
               left++;
           }

       }
        return  new String(ch);
    }


}
