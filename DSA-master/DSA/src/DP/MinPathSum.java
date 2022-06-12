package DP;

import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 4},
                {7, 5, 9}
        };
        int m = matrix.length;
        int n = matrix[0].length;

        System.out.println( f(matrix, m - 1, n - 1));

        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(memo(matrix, m - 1, n - 1, dp));

        for(int[] row: dp) {
            System.out.println(Arrays.toString(row));
        }
    }

    static int f(int[][] matrix, int m, int n) {
        if (m == 0 && n == 0) {
            return matrix[m][n];
        }

        if (m == -1 || n == -1) {
            return Integer.MAX_VALUE - 100;
        }

        int up = matrix[m][n] + f(matrix, m - 1, n);
        int left = matrix[m][n] + f(matrix, m, n - 1);

        return Math.min(up, left);
    }

    static int memo(int[][] matrix, int m, int n, int[][] dp) {
        if (m == 0 && n == 0) {
            return matrix[m][n];
        }

        if (m == -1 || n == -1) {
            return Integer.MAX_VALUE - 100;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        int up = matrix[m][n] + memo(matrix, m - 1, n, dp);
        int left = matrix[m][n] + memo(matrix, m, n - 1, dp);

        return dp[m][n] = Math.min(up, left);
    }
}
