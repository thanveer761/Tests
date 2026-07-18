package SlidingWindow;

import org.junit.jupiter.api.Test;

public class PermutationString {

    @Test
    public void test1(){
        String s1 = "ab", s2 = "eidbaooo";
        boolean op= checkInclusion(s1,s2);
        System.out.println(op);
    }
    @Test
    public void test2(){
        String s1 = "ab", s2 = "eidboaoo";
        boolean op= checkInclusion(s1,s2);
        System.out.println(op);
    }
    /*
     * initialize n = length of s1, m = length of s2
     * if n > m, return false (s1 can't fit inside s2)

     * create need[26] = frequency count of each character in s1
     * create window[26] = frequency count of first n characters of s2

     * if need equals window, return true (first window is already a match)

     * traverse using right pointer from n to end of s2
     * let left = right - n (the character about to leave the window)
     * add character at right into window (window[s2[right]]++)
     * remove character at left from window (window[s2[left]]--)
     * if need equals window, return true (current window is a permutation match)

     * after traversing entire s2, return false (no matching window found)
     */

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < n; i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if (matches(need, window)) {
            return true;
        }

        for (int right = n; right < m; right++) {
            int left = right - n;
            window[s2.charAt(right) - 'a']++;
            window[s2.charAt(left) - 'a']--;
            if (matches(need, window)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] need, int[] window) {
        for (int i = 0; i < 26; i++) {
            if (need[i] != window[i]) return false;
        }
        return true;
    }
}