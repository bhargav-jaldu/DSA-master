package DP.Subsets;

import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {
        int[] wt = {1, 2, 4, 5};
        int[] val = {5, 4, 8, 6};
        int W = 5; // bag weight

        System.out.println(knapSack(wt, val, wt.length - 1, W));

        int[][] dp = new int[wt.length][W + 1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(memo(wt, val, wt.length - 1, W, dp));
    }

    static int knapSack(int[] wt, int[] val, int ind, int W) {

        if (ind == 0) {
            if (wt[0] <= W) return val[0];
            else return 0;
        }

        int notTake = knapSack(wt, val, ind - 1, W);
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= W) {
            take = val[ind] + knapSack(wt, val, ind - 1, W - wt[ind]);
        }

        return Math.max(notTake, take);
    }

    static int memo(int[] wt, int[] val, int ind, int W, int[][] dp) {

        if (ind == 0) {
            if (wt[ind] <= W) return val[ind];
            else return 0;
        }

        if (dp[ind][W] != -1) return dp[ind][W];

        int notTake = memo(wt, val, ind - 1, W, dp);
        int take = Integer.MIN_VALUE;
        if (wt[ind] <= W) {
            take = val[ind] + memo(wt, val, ind - 1, W - wt[ind], dp);
        }

        return dp[ind][W] = Math.max(take, notTake);
    }
}
