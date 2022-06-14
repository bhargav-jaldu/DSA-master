package DP.Subsets;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int target = 3;

        int sum = 0;
        System.out.println(f(arr, target, arr.length - 1, sum));
    }

    static int f(int[] arr, int target, int ind, int sum) {

        if (ind == 0) {
            if (sum + arr[ind] == target || sum - arr[ind] == target) return 1;
            else return 0;
        }

        int neg = f(arr, target, ind - 1, sum - arr[ind]);
        int pos = f(arr, target, ind - 1, sum + arr[ind]);

        return neg + pos;

    }
//
//    static int memo(int[] arr, int target, int ind, int sum, int[][] dp) {
//
//    }
}
