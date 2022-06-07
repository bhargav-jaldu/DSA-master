package DP;

import java.util.Arrays;

public class MaxSumOfNonAdjElem {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        System.out.println(f(arr.length - 1, arr));

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(memo(arr, arr.length - 1, dp));
    }

    private static int f(int index, int[] arr) {
        if (index == 0) {
            return arr[index];
        }

        if (index < 0) return 0;

        int pick = arr[index] + f(index - 2, arr);
        int notPick = f(index - 1, arr);

        return Math.max(pick, notPick);
    }

    private static int memo(int[] arr, int index, int[] dp) {
        if (index == 0) {
            return arr[index];
        }

        if (index < 0) return 0;

        if (dp[index] != -1) return dp[index];

        int pick = arr[index] + memo(arr, index - 2, dp);
        int notPick = memo(arr, index - 1, dp);

        return dp[index] = Math.max(pick, notPick);
    }
}
