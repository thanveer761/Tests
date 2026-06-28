package Strings;

import org.junit.jupiter.api.Test;

public class ReverseCharacterStringAtItsPosition {

    @Test
    public void test1(){
        String s ="Thanveer Ahmed muju";
        String op= reverseWords(s);
        System.out.println(op);
    }

    private String reverse(String s){
        StringBuilder result= new StringBuilder();
        for (int i =s.length()-1; i >=0 ; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    private String reverseWords(String s) {

        String[] words = s.split(" ");
        StringBuilder op= new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            op.append(reverse(words[i]));
            if(i < words.length - 1) op.append(" ");//Purpose — add space between words but not at the end:
        }

        return op.toString();
    }
}

