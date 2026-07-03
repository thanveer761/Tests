package MathProblems;

import org.junit.jupiter.api.Test;
public class SquareRoot {
    @Test
    public void test1() {
        int n = 4;
        int op = mySqrtBruteForce(n);
        System.out.println(op);
    }

    @Test
    public void test2() {
        int n = 8;
        int op = mySqrtBruteForce(n);
        System.out.println(op);
    }

    @Test
    public void test3() {
        int n = 1;
        int op = mySqrtBruteForce(n);
        System.out.println(op);
    }

    @Test
    public void test4() {
        int n = 0;
        int op = mySqrtBruteForce(n);
        System.out.println(op);
    }
    /* pseudocode:
    Tracing with n = 8, step by step:
Start: i = 1
Loop check #1: Is i * i <= n? → 1 * 1 = 1 → is 1 <= 8? → Yes → enter loop → i++ → now i = 2
Loop check #2: Is i * i <= n? → 2 * 2 = 4 → is 4 <= 8? → Yes → enter loop → i++ → now i = 3
Loop check #3: Is i * i <= n? → 3 * 3 = 9 → is 9 <= 8? → No → loop stops, i stays at 3
After the loop: i = 3, but the loop stopped because 3 was too big. So the last "good" value was actually i - 1 = 2.
Return: i - 1 = 3 - 1 = 2
     */
    public int mySqrtBruteForce(int n) {
        if (n == 0) return 0;

        long i = 1;
        while (i * i <= n) {
            i++;
        }

        return (int) (i - 1);
    }
}
