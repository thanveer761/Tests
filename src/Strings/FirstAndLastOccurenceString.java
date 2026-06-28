package Strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FirstAndLastOccurenceString {

        @Test
        public void test1() {
            String s = "amazonaanazzz";
           int[] op = firstAndLastOccurenceString(s);
           System.out.println(Arrays.toString(op));
            int[] op1 = firstAndLastOccurrenceString1(s,'a');
            System.out.println(Arrays.toString(op1));
        }

        //brute Force
       private int[] firstAndLastOccurenceString(String s) {
            for (int i = 0; i < s.length(); i++) {
                for (int j = s.length()-1; j >=0 ; j--) {
                    if(s.charAt(i)==s.charAt(j)){
                        return new int[] {i,j};
                    }
                }
            }
            return new int[] {-1,-1};
        }
    private int[] firstAndLastOccurrenceString1(String s, char target) {
        int left = 0, right = s.length() - 1;
        char[] ch = s.toCharArray();

        // move left pointer until it finds the target
        while (left <= right && ch[left] != target) {
            left++;
        }

        // move right pointer until it finds the target
        while (right >= left && ch[right] != target) {
            right--;
        }

        if (left > right) {
            return new int[] {-1, -1}; // target not found at all
        }

        return new int[] {left, right};
    }
    }

