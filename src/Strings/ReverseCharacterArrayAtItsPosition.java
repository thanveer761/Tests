package Strings;

import org.junit.jupiter.api.Test;

public class ReverseCharacterArrayAtItsPosition {

    @Test
    public void test1(){
        String s1="this is a test class";
        String op1=revCharacter(s1);
        System.out.println(op1);


    }

    /*

     */

    private String revCharacter(String s1) {

        char[] letters= new char[s1.length()];
        int count=0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)!=' '){
                letters[count++]=s1.charAt(i);
            }
        }
       int  left=0;
        int right = count - 1;
        while(left<right){
            char temp= letters[left];
            letters[left]=letters[right];
            letters[right]=temp;
            left++;
            right--;
        }
        StringBuilder result = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)==' '){
               result.append(' ');
            }else{
                result.append(letters[j++]);
            }
        }
        return result.toString();
    }
}
