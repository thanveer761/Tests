package ReverseStringProblems;

import org.junit.jupiter.api.Test;

public class ReverseWords {

    @Test
    public void test1(){
        String s ="thanveer ahmmed";
        String op= reverseWord(s);
        System.out.println(op);
    }

    private String reverseWord(String s) {

        StringBuilder rev= new StringBuilder();

     String[] words=   s.split(" ");
        for (int i = words.length-1; i >=0 ; i--) {
           if(i<words.length-1)rev.append(" ") ;
           rev.append(words[i]);
        }
        return rev.toString();
    }
}
