package MathProblems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    @Test
    public void test1() {
        int nums = 3;
        List<String> op = fizzBuzz(nums);
        System.out.println(op);
    }

    @Test
    public void test2() {
        int nums = 5;
        List<String> op = fizzBuzz(nums);
        System.out.println(op);
    }

    @Test
    public void test3() {
        int nums = 15;
        List<String> op = fizzBuzz(nums);
        System.out.println(op);
    }

    /*
     * pseudocode:
     * traverse from 1 to n
     * if i % 3 == 0 AND i % 5 == 0
     *   — return "FizzBuzz"
     * else if i % 3 == 0
     *   — return "Fizz"
     * else if i % 5 == 0
     *   — return "Buzz"
     * else
     *   — return i (as string)
     */
    public List<String> fizzBuzz(int n) {


        List<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i));
            }
        }

        return answer;
    }
}