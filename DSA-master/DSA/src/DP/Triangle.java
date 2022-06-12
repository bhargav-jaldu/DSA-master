package DP;

//https://www.codingninjas.com/codestudio/problems/triangle_1229398

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        int[][] triangle = {
                {1},
                {2,3},
                {3,6,7},
                {8,9,6,10}
        };

        int row = triangle.length;
        int col = triangle[triangle.length - 1].length;

        System.out.println(f(triangle, 0, 0));

        int[][] dp = new int[row][col];
        for(int[] r: dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(memo(triangle, 0, 0, dp));
    }

    static int f(int[][] triangle, int row, int col) {

        if (row == triangle.length - 1) {
            return triangle[row][col];
        }

//        go down
        int down = triangle[row][col] + f(triangle, row + 1, col);
//        go diagonal
        int dg = triangle[row][col] + f(triangle, row + 1, col + 1);

        return Math.min(down, dg);
    }

    static int memo (int[][] triangle, int row, int col, int[][] dp) {
        if (row == triangle.length - 1) {
            return triangle[row][col];
        }

        if (dp[row][col] != -1) return dp[row][col];

//        go down
        int down = triangle[row][col] + memo(triangle, row + 1, col,dp);
//        go diagonal
        int dg = triangle[row][col] + memo(triangle, row + 1, col + 1, dp);

        return dp[row][col] = Math.min(down, dg);
    }
}
