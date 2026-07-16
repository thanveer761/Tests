package HardProblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrapRainWater {


        @Test
        public void test() {
            int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
            Assertions.assertEquals(6, trapWaterPrefixHeight(heights));
        }

        @Test
        public void test1() {
            int[] heights = {4, 2, 0, 3, 2, 5};
            Assertions.assertEquals(9, trapWaterPrefixHeight(heights));
        }

        @Test
        public void test2() {
            int[] heights = {4, 2, 0, 3, 2, 1};
            Assertions.assertEquals(4, trapWaterPrefixHeight(heights));
        }

        /**
         * initialise two variables called leftMaxHeight=Integer.MIN_VALUE, rightMaxHeight=Integer.MIN_VALUE, save=0
         * iterate the array from start index till the end
         * - for every index i, compute the leftMaxHeight, rightMaxHeight
         * - Take a minimum between the left and right max heights (i.e water can be stored till the wall that has the min height)
         * - to compute the units of water stored subtract the building height (value at current index) from the minHeight
         * - if the ans is less than zero, do a math.max() with 0, since the water can't be saved in -ve units
         * - accumulate the result into save variable and proceed
         * return save
         * TC: O(n^2)
         * SC: O(1)
         */

        public int trapWater(int[] heights) {

            int save = 0;
            for (int i = 1; i < heights.length - 1; i++) { // O(n)
                // findLeftMax
                int lMaxHeight = findMax(heights, i, "left");  //1
                // find rightMax
                int rMaxHeight = findMax(heights, i, "right");// O(n). //3
                int units = Math.max(0, Math.min(lMaxHeight, rMaxHeight) - heights[i]);
                save += units;
            }
            return save;
        }

        public int findMax(int[] heights, int index, String direction) {
            int maxHeight = Integer.MIN_VALUE;
            if (direction.equals("left")) {
                for (int i = 0; i < index; i++) {
                    maxHeight = Math.max(maxHeight, heights[i]);
                }
            } else {
                for (int i = index + 1; i < heights.length; i++) {
                    maxHeight = Math.max(maxHeight, heights[i]);
                }
            }
            return maxHeight;
        }

        /**
         * initialise variables save=0,
         * initialise leftPrefixHeight, rightPefixHeight arrays which are of same length as input heights
         * iterate the input array from left to right, compute all left max heights so far
         * iterate the input array from right to left, compute the right max heights so far
         * iterate the input array
         *  - compare and take min height between the left and right max heights
         *  - subtract the height with the current element, handle the negative result case (Math.max(0,)
         *  - accumulate the sum
         *
         * TC: O(n)
         * SC: O(n)
         * @param heights
         * @return
         */

        public int trapWaterPrefixHeight(int[] heights){
            int save=0;
            int[] leftMaxHeights= new int[heights.length];
            int[] rightMaxHeights= new int[heights.length];
            leftMaxHeights[0]=heights[0];
            // find left max heights and store
            for(int i=1;i<leftMaxHeights.length;i++){
                leftMaxHeights[i]=Math.max(leftMaxHeights[i-1], heights[i]);
            }

            // find the right max heights and store
            rightMaxHeights[rightMaxHeights.length-1]=heights[heights.length-1];
            for (int i=heights.length-2;i>=0;i--){
                rightMaxHeights[i]=Math.max(heights[i], rightMaxHeights[i+1]);
            }

            // compute the save and return answer
            for (int i=0;i<heights.length;i++){
                save += Math.max(0,Math.min(leftMaxHeights[i], rightMaxHeights[i])-heights[i]);
            }
            return save;
        }

        // TC: O(n)
        // SC: O(1)
        public int trapWithTwoPointers(int[] heights){
            int save=0, leftMaxHeight=0, rightMaxHeight=0;
            int left=0, right=heights.length-1;
            while (left<right){
                if(heights[left]<=heights[right]){
                    // process left max height
                    if(leftMaxHeight<heights[left]){
                        leftMaxHeight=heights[left];
                    }else {
                        save+=leftMaxHeight-heights[left];
                    }
                    left++;
                }else{
                    // process of right max height
                    if(rightMaxHeight<heights[right]){
                        rightMaxHeight=heights[right];
                    }else {
                        save+=rightMaxHeight-heights[right];
                    }
                    right--;
                }
            }
            return save;
        }



































        public int trapWaterWithSpace(int[] heights) {
            int[] leftHeights = new int[heights.length];
            int[] rightHeights = new int[heights.length];
            int save = 0;
            leftHeights[0] = heights[0];
            rightHeights[heights.length - 1] = heights[heights.length - 1];
            for (int i = 1; i < heights.length; i++) {
                leftHeights[i] = Math.max(leftHeights[i - 1], heights[i]);
            }

            for (int i = heights.length - 2; i >= 0; i--) {
                rightHeights[i] = Math.max(rightHeights[i + 1], heights[i]);
            }

            for (int i = 0; i < heights.length; i++) {
                save += Math.max(0, Math.min(leftHeights[i], rightHeights[i]) - heights[i]);
            }
            return save;
        }

        public int trapWaterTwoPointer(int[] heights) {
            int left = 0, right = heights.length - 1, leftMaxHeight = Integer.MIN_VALUE, rightMaxHeight = Integer.MIN_VALUE, save = 0;
            while (left < right) {
                if (heights[left] <= heights[right]) {
                    if (leftMaxHeight < heights[left]) {
                        leftMaxHeight = heights[left];
                    } else {
                        save += leftMaxHeight - heights[left];
                    }
                    left++;
                } else {
                    if (rightMaxHeight < heights[right]) {
                        rightMaxHeight = heights[right];
                    } else {
                        save += rightMaxHeight - heights[right];
                    }
                    right--;
                }

            }
            return save;
        }

    }

