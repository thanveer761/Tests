package Arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KdiffPairs {
    @Test
    public void test1() {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        int op = findPairs(nums, k);
        System.out.println(op);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 1;
        int op = findPairs(nums, k);
        System.out.println(op);
    }

    /*
    // Step 1: Count how many times each value appears
    CREATE empty map freq (value -> count)
    FOR each num IN nums:
        freq[num] = freq[num] + 1   (or 1 if not present yet)

    // Step 2: Count valid pairs using only distinct values
    SET count = 0

    FOR each distinct value "num" IN freq's keys:
        IF k == 0:
            // pair needs same value appearing at two different indices
            IF freq[num] >= 2:
                count = count + 1
        ELSE:
            // pair needs the "bigger" partner (num + k) to exist
            IF (num + k) EXISTS IN freq:
                count = count + 1

    RETURN count
     */

    public int findPairs(int[] nums, int k) {
                Map<Integer, Integer> freq = new HashMap<>();
                for (int num : nums) {
                    freq.put(num, freq.getOrDefault(num, 0) + 1);
                }

                int count = 0;
                for (int num : freq.keySet()) {
                    if (k == 0) {
                        // need at least two occurrences of the same value
                        if (freq.get(num) >= 2) {
                            count++;
                        }
                    } else {
                        // need num + k to also exist
                        if (freq.containsKey(num + k)) {
                            count++;
                        }
                    }
                }
                return count;
            }
        }