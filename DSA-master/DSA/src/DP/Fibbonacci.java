package DP;

import java.util.*;

public class Fibbonacci {
    public static void main(String[] args) {
        int num = 6;
        System.out.println(fibbo(num));

//        memoization
        int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);
        System.out.println(memo(num, dp));

        tabulation(num);
        spaceOptimization(num);
    }

//    recursion
    private static int fibbo(int num) {

        if (num < 2) {
            return num;
        }

        return fibbo(num - 1) + fibbo(num - 2);
    }

//    memoization
    private static int memo(int num, int[] dp) {
        if (num < 2) {
            return num;
        }

        if (dp[num] != -1) {
            return dp[num];
        }

        return dp[num] = memo(num - 1, dp) + memo(num - 2, dp);
    }

//    tabulation
    private static void tabulation(int num) {
        int[] dp = new int[num + 1];

        dp[0] = 0;dp[1] = 1;
        for(int i = 2;i < dp.length;i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[dp.length - 1]);
    }

//    space optimization
    private static void spaceOptimization(int num) {
        int prev1 = 0, prev2 = 1;
        for (int i = 0; i < num; i++) {
            int curri = prev1 + prev2;
            prev2 = prev1;
            prev1 = curri;
        }

        System.out.println(prev1);
    }
}
