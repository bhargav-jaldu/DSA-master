package DP.Subsets;

import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int target = 4;

        int[][] dp = new int[arr.length][target + 1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(memo(arr, target, arr.length - 1, dp));
    }

    static int memo(int[] arr, int target, int index, int[][] dp) {

        if (index == 0) {
            if (target % arr[0] == 0) return 1;
            else return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notPick = memo(arr, target, index - 1, dp);
        int pick = 0;
        if (arr[index] <= target) {
            pick = memo(arr, target - arr[index], index, dp);
        }

        return dp[index][target] = notPick + pick;

    }

}
