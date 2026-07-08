package Arrays;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrumpyBookstoreOwner {

    @Test
    public void test1() {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        assertEquals(16, maxSatisfied(customers, grumpy, minutes));
    }

    @Test
    public void test2() {
        int[] customers = {1};
        int[] grumpy = {0};
        int minutes = 1;
        assertEquals(1, maxSatisfied(customers, grumpy, minutes));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        // Part 1: baseline - customers already satisfied (grumpy = 0)
        int baseline = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                baseline += customers[i];
            }
        }

        // Part 2: sliding window - find best extra gain from using the trick
        int windowSum = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                windowSum += customers[i];
            }
        }

        int maxExtra = windowSum;

        for (int i = minutes; i < n; i++) {
            // element entering the window (rightmost)
            if (grumpy[i] == 1) {
                windowSum += customers[i];
            }
            // element leaving the window (leftmost, now out of range)
            int leftIndex = i - minutes;
            if (grumpy[leftIndex] == 1) {
                windowSum -= customers[leftIndex];
            }
            maxExtra = Math.max(maxExtra, windowSum);
        }

        return baseline + maxExtra;
    }
}

