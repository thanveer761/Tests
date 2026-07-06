package StringOccurences;

import org.junit.jupiter.api.Test;

public class LastNonRepeatingCharacterString {

    @Test
    public void test1() {
        String s = "ThanveerAhmed";
        String op = lastNonRepeatingCharacterString(s);
        System.out.println(op);  // Output: d
    }

    @Test
    public void test2() {
        String s = "aabbcc";
        String op = lastNonRepeatingCharacterString(s);
        System.out.println(op);  // Output: No non-repeating character found
    }

    @Test
    public void test3() {
        String s = "swiss";
        String op = lastNonRepeatingCharacterString(s);
        System.out.println(op);  // Output: i
    }

    private String lastNonRepeatingCharacterString(String s) {
        // Brute force: for each character, check if it appears anywhere else
        for (int i = s.length() - 1; i >= 0; i--) {
            boolean isRepeating = false;

            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    isRepeating = true;
                    break;
                }
            }

            if (!isRepeating) {
                return String.valueOf(s.charAt(i));
            }
        }

        return "No non-repeating character found";
    }
   /* private String lastNonRepeatingCharacterString(String s) {
        // Step 1: Build frequency array (ASCII 256)
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        // Step 2: Scan right to left, return first char with freq == 1
        for (int i = s.length() - 1; i >= 0; i--) {
            if (freq[s.charAt(i)] == 1) {
                return String.valueOf(s.charAt(i));
            }
        }

        return "No non-repeating character found";*/

}