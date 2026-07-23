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
    /*
* GOAL: reverse the digits of an integer x, and return 0 if the reversed
*        value overflows the 32-bit int range

* initialize rev = 0 (using a long, to safely detect overflow before casting back to int)

* while x != 0:
    * let last_digit = last digit of x (x % 10)
    * update rev = rev * 10 + last_digit
      (shift existing digits left by one place, then add the new digit)

    * if rev > Integer.MAX_VALUE OR rev < Integer.MIN_VALUE:
        - the reversed number doesn't fit in a 32-bit int
        - return 0 immediately (per problem constraints)

    * remove the last digit from x (x = x / 10)

* after the loop, cast rev back down to int and return it
*/

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
