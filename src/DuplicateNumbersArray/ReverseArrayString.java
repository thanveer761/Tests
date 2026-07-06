package DuplicateNumbersArray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ReverseArrayString {
    @Test
    public void test1() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
     char[] op=reverseString(s);
     System.out.println(op);
    }

    public char[] reverseString(char[] s) {
       int left=0;
       int right=s.length-1;
     while(left<right){
         char temp=s[left];
         s[left]=s[right];
         s[right]=temp;
         left++;
         right--;
     }
     return Arrays.toString(s).toCharArray();
    }

}
