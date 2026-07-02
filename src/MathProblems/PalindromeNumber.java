package MathProblems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PalindromeNumber {

    @Test
    public void test1() {
        int nums = 121;
        int op= palindromeNumber(nums);
        System.out.println(op == nums ? "Palindrome" : "Not a Palindrome");
    }
    @Test
    public void test2() {
        int nums = 321;
        int op= palindromeNumber(nums);
        System.out.println(op == nums ? "Palindrome" : "Not a Palindrome");
    }

    /*
        STORE the original number in a variable called "original"
        SET reversed = 0
    WHILE nums is greater than 0
        GET the last digit of nums (nums MOD 10)
        ADD that digit to reversed (reversed = reversed * 10 + digit)
        REMOVE the last digit from nums (nums = nums DIVIDE 10)
    END WHILE
     */
    private int palindromeNumber(int nums) {
        int reversed = 0;
        int n = nums;

        while (n > 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n = n / 10;
        }

        return reversed;


    }
}
