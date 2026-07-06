package MathProblems;

import java.util.ArrayList;
import java.util.List;

public class primeNumber {

        public static void main(String[] args) {
            int n = 30;
            List<Integer> primes = new ArrayList<>();
            for (int num = 2; num <= n; num++) {
                if (isPrime(num)) {
                    primes.add(num);
                }
            }
            System.out.println(primes);
        }

        public static boolean isPrime(int num) {
            if (num < 2) return false;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }
