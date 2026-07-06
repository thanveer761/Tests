package ReverseStringProblems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ReverseWordsAtSamePosition {

    @Test
    public void test1(){
        String[] s ={"Thanveer", "Ahmed"};
       String[] op= reverseWords(s);
       System.out.println(Arrays.toString(op));
    }

    private String reverse(String s){
        StringBuilder result= new StringBuilder();
        for (int i =s.length()-1; i >=0 ; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    private String[] reverseWords(String[] s) {
        String[] op = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            op[i]=reverse(s[i]);

        }
        return op;
    }
}
