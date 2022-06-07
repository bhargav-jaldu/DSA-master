package DP;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 2;
        int[][] dp = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(paths(m - 1, n - 1, dp));
    }

    private static int paths(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) {
            return 1;
        }

        if (m < 0 || n < 0) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        int left = paths(m, n - 1, dp);
        int up = paths(m - 1, n, dp);

        return dp[m][n] = left + up;
    }
}
