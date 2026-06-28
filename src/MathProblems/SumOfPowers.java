package MathProblems;

import org.junit.jupiter.api.Test;

public class SumOfPowers {

    @Test
    public void test1() {
        System.out.println("1^1+2^2+3^3: " + sumOfPowers(3, 1));   // 32
        System.out.println("1^1-2^2-3^3: " + sumOfPowers(3, -1));  // -30
    }

    private long sumOfPowers(int n, int sign) {
        long sum = (long) Math.pow(1, 1); // first term always positive
        for (int i = 2; i <= n; i++) {
            sum += sign * (long) Math.pow(i, i);
        }
        return sum;
    }
}