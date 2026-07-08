package Matrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DiagonalSum {


    @Test
    public void test1() {
        int[][] nums1 = {{1,2,3},
                {4,5,6},
                {7,8,9}};

        int op= diagonalSum(nums1);
        System.out.println(op);
    }
    @Test
    public void test2() {
        int[][] nums1 = {{1,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}};

        int op= diagonalSum(nums1);
        System.out.println(op);
    }

    /*

     */


        public int diagonalSum(int[][] mat) {
            int n = mat.length;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j && i + j == n - 1) {
                        sum += mat[i][j];        // center cell, add once
                    } else if (i == j) {
                        sum += mat[i][j];        // primary diagonal
                    } else if (i + j == n - 1) {
                        sum += mat[i][j];        // secondary diagonal
                    }
                }
            }
            return sum;
        }
    }

