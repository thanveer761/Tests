package MathProblems;

import org.junit.jupiter.api.Test;

public class SumOfPowers {

    @Test
    public void test1() {
        System.out.println("1^1+2^2+3^3: " + sumOfPowers(3, 1));   // 32
        System.out.println("1^1-2^2-3^3: " + sumOfPowers(3, -1));  // -30
    }
    /*
    * GOAL: compute the sum 1^1 (+ or -) 2^2 (+ or -) 3^3 ... up to n^n,
    *        where the first term is always positive, and every term after
    *        that is either added or subtracted based on "sign"

    * initialize sum = 1^1 (always 1, computed directly, always positive)

    * traverse using pointer i from 2 to n
        * compute value = i raised to the power i
        * multiply value by sign
            (if sign = 1, this leaves value unchanged  → effectively "add it")
            (if sign = -1, this flips value negative   → effectively "subtract it")
        * add (sign * value) to sum

    * return sum
    */
    private long sumOfPowers(int n, int sign) {
        int sum = (int) Math.pow(1, 1); // first term always positive
        for (int i = 2; i <= n; i++) {
            sum += (int) (sign *  Math.pow(i, i));
        }
        return sum;
    }
}