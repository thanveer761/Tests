package MathProblems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ReverseNum {

    @Test
    public void test1() {
        int num=123;
        int op=revNum(num);
        System.out.println(op);
    }

    private int revNum(int x) {
        long rev=0;
        while (x!=0) {
            int last_digit = x % 10;
            rev = rev * 10 + last_digit;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;

            }

            x = x / 10;
        }
        return (int) rev;
    }
}
