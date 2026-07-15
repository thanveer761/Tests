package HardProblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    @Test
    public void test0() {
        String s = "ADOBECODEBANC", t = "ABC";
        String op=minWindow(s,t);
        System.out.println(op);
    }

    @Test
    public void test1() {
        String s = "a", t = "a";
        String op=minWindow(s,t);
        System.out.println(op);
    }

    @Test
    public void test2() {
        String s = "a", t = "aa";
        String op=minWindow(s,t);
        System.out.println(op);
    }
    /**
     * initialise a HashMap called need to store the frequency of each character in t
     * initialise a HashMap called window to store the frequency of each character currently in the sliding window
     * initialise two pointers left=0, right=0
     * initialise required = number of unique characters in t (i.e need.size())
     * initialise formed=0 to track how many unique characters are currently satisfied in the window
     * initialise minLen=Integer.MAX_VALUE and minStart=0 to track the smallest valid window found
     *
     * iterate the string s using the right pointer till the end
     * - add the current character into the window map, incrementing its count
     * - if this character exists in need and its count in window now matches the count in need, increment formed
     *
     * - while the window has formed all required characters (formed == required)
     *   - check if the current window (right - left + 1) is smaller than minLen, if so update minLen and minStart
     *   - remove the leftmost character from the window map, decrementing its count
     *   - if this character exists in need and its count in window drops below the count in need, decrement formed
     *   - move the left pointer forward
     *
     * - move the right pointer forward and continue expanding
     *
     * after the loop, if minLen is still Integer.MAX_VALUE, no valid window was found, return ""
     * otherwise return the substring of s starting at minStart with length minLen
     * <p>
     * TC: O(m + n) where m = length of s, n = length of t
     * SC: O(m + n) for the two HashMaps
     */
        public String minWindow(String s, String t) {

            // Step 1: Count characters needed from t
            Map<Character, Integer> need = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            // Step 2: Setup sliding window variables
            Map<Character, Integer> window = new HashMap<>();
            int left = 0, right = 0;
            int required = need.size();      // how many unique chars must be satisfied
            int formed = 0;                  // how many unique chars currently satisfied

            int minLen = Integer.MAX_VALUE;
            int minStart = 0;

            // Step 3: Expand window with right pointer
            while (right < s.length()) {
                char c = s.charAt(right);
                window.put(c, window.getOrDefault(c, 0) + 1);

                // If this character's count matches what's needed, mark satisfied
                if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                    formed++;
                }

                // Step 4: Try shrinking window from left while it's still valid
                while (left <= right && formed == required) {

                    // Update result if this window is smaller
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minStart = left;
                    }

                    // Remove leftmost character from window
                    char leftChar = s.charAt(left);
                    window.put(leftChar, window.get(leftChar) - 1);

                    // If removing it breaks the requirement, decrease formed
                    if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                        formed--;
                    }

                    left++;
                }

                right++;
            }

            // Step 5: Return result
            return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
        }
    }
