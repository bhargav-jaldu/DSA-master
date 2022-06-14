package DP.Subsets;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 4, 5};

        int totalSum = 0;
        for(int i = 0;i < arr.length;i++) {
            totalSum += arr[i];
        }

//        this if should write for memo as well
        if (totalSum % 2 != 0) {
            System.out.println("false");
            return;
        }

        int target = totalSum / 2;
        if (f(arr, arr.length - 1, target)) {
            System.out.println("The array can be partitioned into two equal subsets");
        }
        else {
            System.out.println("The Array cannot be partitioned into two equal subsets");
        }

        boolean[][] dp = new boolean[arr.length][target + 1];
        if (memo(arr, arr.length - 1, target, dp)) {
            System.out.println("The array can be partitioned into two equal subsets");
        }
        else {
            System.out.println("The Array cannot be partitioned into two equal subsets");
        }
    }

    static boolean f(int[] arr, int index, int target) {

        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return arr[index] == target;
        }

        boolean notPick = f(arr, index - 1, target);
        boolean pick = false;
        if (arr[index] <= target) {
            pick = f(arr, index - 1, target - arr[index]);
        }

        return notPick || pick;
    }

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
