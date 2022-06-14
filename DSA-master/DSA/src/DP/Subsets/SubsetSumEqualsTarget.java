package DP.Subsets;

import java.util.Arrays;

public class SubsetSumEqualsTarget {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int target = 4;
        System.out.println(f(arr, arr.length - 1, target));

        boolean[][] dp = new boolean[arr.length][target + 1];
        System.out.println(memo(arr, arr.length - 1, target, dp));
    }

//    time: O(2^n)
//    space: O(n)
    static boolean f(int[] arr, int index, int target) {


        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return arr[0] == target;
        }

        boolean notPick = f(arr, index - 1, target);

        boolean pick = false;
        if (arr[index] <= target) {
            pick = f(arr, index - 1,target - arr[index]);
        }

        return pick || notPick;
    }

//    time: O(N * K) + O(N)
//    space: O(N * K) + O(N)
    static boolean memo(int[] arr, int index, int target, boolean[][] dp) {

        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return arr[0] == target;
        }

        if (dp[index][target]) {
            return true;
        }

        boolean notPick = memo(arr, index - 1, target, dp);
        boolean pick = false;
        if (arr[index] <= target) {
            pick = memo(arr, index - 1, target - arr[index], dp);
        }

        return dp[index][target] = notPick || pick;
    }
}
