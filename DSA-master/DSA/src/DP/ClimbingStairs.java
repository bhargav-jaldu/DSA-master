package DP;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int num = 3;
        System.out.println(stairs(num));

        int[] dp = new int[num + 1];
        Arrays.fill(dp, - 1);
        System.out.println(memo(num, dp));

        tabulation(num);
    }

    private static int stairs(int num) {
        if (num == 0) {
            return 1;
        }

        if (num < 0) {
            return 0;
        }

        int left = stairs(num - 1);
        int right = stairs(num - 2);

        return left + right;
    }

//  memoization
    private static int memo(int num, int[] dp) {
        if (num == 0) {
            return 1;
        }

        if (num < 0) {
            return 0;
        }

        if (dp[num] != -1) {
            return dp[num];
        }

        int left = memo(num - 1, dp);
        int right = memo(num - 2, dp);

        return dp[num] = left + right;
    }

//    Tabulation
    private static void tabulation(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 1;

        for(int i = 1;i < dp.length;i++) {
            int left = dp[i - 1];
            int right = 0;
            if (i - 2 >= 0) {
                right = dp[i - 2];
            }
            dp[i] = left + right;
        }

        System.out.println(dp[dp.length - 1]);
    }
}
