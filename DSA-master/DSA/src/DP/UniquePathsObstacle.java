package DP;

import java.util.Arrays;

public class UniquePathsObstacle {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };
        System.out.println(f(matrix, matrix.length - 1, matrix[0].length - 1));
        int[][] dp = new int[matrix.length][matrix.length];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(memo(matrix, matrix.length - 1, matrix[0].length - 1, dp));
    }

    static int f(int[][] matrix, int row, int col) {


        if (row == 0 && col == 0) {
            return 1;
        }

        if (row == -1 || col == -1) {
            return 0;
        }

        if (matrix[row][col] == -1) {
            return 0;
        }

//        go up
        int up = f(matrix, row - 1, col);
//        go left
        int left = f(matrix, row, col - 1);
        return up + left;
    }

    static int memo(int[][] matrix, int row, int col, int[][] dp) {
        if (row == 0 && col == 0) {
            return 1;
        }

        if (row == -1 || col == -1) {
            return 0;
        }

        if (matrix[row][col] == -1) {
            return 0;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

//        go up
        int up = f(matrix, row - 1, col);
//        go left
        int left = f(matrix, row, col - 1);

        return dp[row][col] = up + left;
    }
}
