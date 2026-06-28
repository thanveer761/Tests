package Strings;

import org.junit.jupiter.api.Test;

public class CheckAComesAfterB {
    @Test
    public void test1(){
        String s1="ababa";
        String op1= String.valueOf(checkAcomesBeforeB(s1));;
        System.out.println(op1);
}
    @Test
    public void test2(){
        String s1="aaabb";
        String op1= String.valueOf(checkAcomesBeforeB(s1));;
        System.out.println(op1);
    }
    @Test
    public void test3(){
        String s1="aabab";
        String op1= String.valueOf(checkAcomesBeforeB(s1));;
        System.out.println(op1);
    }

    private boolean checkAcomesBeforeB(String s1) {

        boolean bseen=false;
        for (char c:s1.toCharArray()){
            if(c =='b') bseen= true;
            if(c=='a'&& bseen) return false;
        }

        return true;
    }
    }
