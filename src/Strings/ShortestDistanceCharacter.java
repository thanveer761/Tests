package Strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ShortestDistanceCharacter {
    @Test
    public void testCase1() {
        String s="aaab";
        char c='b';
int[] op=closestOccu(s,c);
System.out.println(Arrays.toString(op));
    }
    @Test
    public void testCase2() {
        String s="loveleetcode";
        char c='e';
        int[] op=closestOccu(s,c);
        System.out.println(Arrays.toString(op));
    }

    /*pseudocode:
* GOAL: for each index i in string s, find the distance to the nearest occurrence of character c

* initialize len = length of s
* create op[len] = new array to store the answer for each index
* initialize index = -len (a far-away placeholder, meaning "no occurrence of c seen yet")

* FIRST PASS (left to right) — captures distance to nearest c found so far ON THE LEFT (or itself)
    * traverse using pointer i from 0 to len-1
        * if s[i] == c:
            - update index = i (mark this as the most recent occurrence of c)
        * set op[i] = i - index
          (distance from current position to the last seen occurrence;
           will be a huge number if c hasn't been seen yet, since index is still -len)

* SECOND PASS (right to left) — captures distance to nearest c found so far ON THE RIGHT (or itself)
    * traverse using pointer i from len-1 down to 0
        * if s[i] == c:
            - update index = i (mark this as the most recent occurrence of c, scanning backwards)
        * set op[i] = min(op[i], abs(i - index))
          (take the smaller of: distance to nearest c on the left [from pass 1],
           or distance to nearest c on the right [from this pass])

* return op
*/

    /*
    s="loveleetcode"
     * -12,-11,-10,0,1,0,0,1,2,3,4,0
     * 3,2,1,0,1,0,0,1,2,2,1,0
     */
    //2 pointers
    public int[] closestOccu(String s,char c) {
        int len = s.length();
        int [] op = new int[len];
        int index = -len;
        for (int i = 0; i < len; i++) {
            if(s.charAt(i)==c) {
                index=i;
            }
            op[i]=i-index;
        }
        for (int  i= len-1;i>= 0; i--) {
            if(s.charAt(i)==c) {
                index=i;
            }

            op[i]=Math.min(op[i], Math.abs(i-index));
        }



        return op;

    }

}
