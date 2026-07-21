package MathProblems;

import org.junit.jupiter.api.Test;

public class HappyNumbers {

    @Test
    public void test1() {
        int n = 19;
        boolean op= happyNumber(n);
        System.out.println(op);
    }
    @Test
    public void test2() {
        int n = 2;
        boolean op= happyNumber(n);
        System.out.println(op);
    }
    /*
    * GOAL: determine if n is a "happy number"
    *   (repeatedly replace n with the sum of squares of its digits;
    *    if this process reaches 1, n is happy; otherwise it cycles forever)

    * if n == 1 OR n == 7:
        - return true
        (1 is the terminating happy value;
         7 is a single-digit number that is also known to be happy)

    * else if n < 10:
        - return false
        (every other single-digit number, other than 1 and 7,
         is known to eventually fall into the unhappy cycle 4→16→37→58→89→145→42→20→4...
         so any single digit other than 1 or 7 can be safely declared unhappy)

    * else:
        * initialize sum = 0
        * while n > 0:
            - let temp = last digit of n (n % 10)
            - add temp squared to sum
            - remove last digit from n (n = n / 10)
        * recursively call happyNumber(sum) and return its result
          (this repeats the digit-square-sum process on the new value)
    */
    public boolean happyNumber(int n) {
        if(n==1 || n==7) return true;
        else if(n<10) return false;
        else{
            int sum=0;
            while(n>0){
                int temp=n%10;
                sum+= temp*temp;
                n=n/10;
            }
            return happyNumber(sum);
        }
    }
    }

