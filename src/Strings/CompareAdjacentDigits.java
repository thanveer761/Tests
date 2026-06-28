package Strings;

import org.junit.jupiter.api.Test;

public class CompareAdjacentDigits {
    @Test
    public void test1(){
        String s1="658488";
        String op1=compareAdjacentDigits(s1);
        System.out.println(op1);
}

    private String compareAdjacentDigits(String s1) {
        String op="";
        for (int i = 0; i < s1.length()-1 ; i++) {
            if(s1.charAt(i)>s1.charAt(i+1)){
                op+=">";
            } else if (s1.charAt(i) < s1.charAt(i+1)){
              op+="<";
            } else{
                op+="=";
            }}
            return op;
    }
    }
