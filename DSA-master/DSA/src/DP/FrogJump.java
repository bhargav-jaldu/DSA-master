package DP;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int[] weights = {30, 10, 60, 10, 60, 50};
        System.out.println(jump(weights, weights.length - 1));

        int[] dp = new int[weights.length + 1];
        Arrays.fill(dp, -1);
        System.out.println(memo(weights, weights.length - 1, dp));
    }

    private static int jump(int[] weights, int i) {
        if (i == 0) {
            return 0;
        }

        int left = jump(weights, i - 1) + Math.abs(weights[i] - weights[i - 1]);
        int right = Integer.MAX_VALUE;
        if (i > 1) {
            right = jump(weights, i - 2) + Math.abs(weights[i] - weights[i - 2]);
        }

        return Math.min(left, right);
    }

    private static int memo(int[] weights, int i, int[] dp) {
        if (i == 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int left = memo(weights, i - 1, dp) + Math.abs(weights[i] - weights[i - 1]);
        int right = Integer.MAX_VALUE;
        if (i > 1) {
            right = memo(weights, i - 2, dp) + Math.abs(weights[i] - weights[i - 2]);
        }

        return dp[i] = Math.min(left, right);
    }
}
