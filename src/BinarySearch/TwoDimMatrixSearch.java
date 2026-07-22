package BinarySearch;

import org.junit.jupiter.api.Test;

public class TwoDimMatrixSearch {

    @Test
    public void test1(){
        int[][]matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean b = twoDimMatrixSearch(matrix,target);
        System.out.println(b);
    }
    @Test
    public void test2(){
            int[][]matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
            int target = 13;
        boolean b = twoDimMatrixSearch(matrix,target);
        System.out.println(b);

    }

        public boolean twoDimMatrixSearch(int[][] matrix, int target){
                    int m = matrix.length;
                    int n = matrix[0].length;

                    int low = 0;
                    int high = m * n - 1;
                    while (low <= high) {
                        int mid = low + (high - low) / 2;
                        int row = mid / n;
                        int col = mid % n;
                        int newmid = matrix[row][col];

                        if (target == newmid) {
                            return true;
                        } else if (newmid > target) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    }
                    return false;
                }
            }
