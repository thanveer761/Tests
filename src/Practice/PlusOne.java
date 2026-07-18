package Practice;

import java.util.Arrays;

public class PlusOne {

/*
    pseudocode:
      - traverse the array from the last index backward to the first index
    - at each index:
        - if the digit is less than 9:
            - increment that digit by 1
            - return the array immediately (done, no carry needed)
        - else (digit is 9):
            - set that digit to 0
            - continue to the next index to the left (carry the 1 forward)
    - if the loop finishes without returning (every digit was 9):
    - create a new array of size n+1 (all zeros by default)
    - set the first index of the new array to 1
    - return the new array

    TC: O[N]
    SC: O[N]
     */

    public static int[] plusOne(int[] digits){
        int n= digits.length;

        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;

        return result;

    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        int[] op = plusOne(input);
        System.out.println(Arrays.toString(op));
        int[] input1 = {9,9,9};
        int[] op1 = plusOne(input1);
        System.out.println(Arrays.toString(op1));

    }
}
