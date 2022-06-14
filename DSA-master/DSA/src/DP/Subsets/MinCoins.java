package DP.Subsets;


// https://www.codingninjas.com/codestudio/problems/minimum-elements_3843091?leftPanelTab=0

import java.util.Arrays;

public class MinCoins {
    public static void main(String[] args) {
        int[] arr ={1,2,3};
        int T=7;

        System.out.println(f(arr, T, arr.length - 1));

        int[][] dp = new int[arr.length][T + 1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        int ans = memo(arr, T, arr.length - 1, dp);
        if(ans >= (int)Math.pow(10,9)) {
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }

    static int f(int[] arr, int T, int ind) {

        if (ind == 0) {
            if (T % arr[ind] == 0) return T/arr[0];
            else return (int)Math.pow(10,9);
        }

        int notPick = f(arr, T, ind - 1);
        int pick = (int)Math.pow(10,9);
        if (arr[ind] <= T) {
            pick = 1 + f(arr, T - arr[ind], ind);
        }

        return Math.min(notPick, pick);
    }

    static int memo(int[] arr, int T, int ind, int[][] dp) {

        if (ind == 0) {
            if (T % arr[0] == 0) return T / arr[0];
            else return (int)Math.pow(10, 9);
        }

        if (dp[ind][T] != -1) return dp[ind][T];

        int notPick = memo(arr, T, ind - 1, dp);
        int pick = (int) Math.pow(10, 9);
        if (arr[ind] <= T) {
            pick = 1 + memo(arr, T - arr[ind], ind, dp);
        }

        return dp[ind][T] = Math.min(notPick, pick);
    }
}
