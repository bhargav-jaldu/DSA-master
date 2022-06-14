package DP.Subsets;

public class CountSubsetsWithSumK {
    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3};
        int k = 3;

        System.out.println(f(arr, k, arr.length - 1));
    }

    static int f(int[] arr, int k, int index) {
        if (k == 0) {
            return 1;
        }

        if (index == 0 && arr[index] == k) {
            return 1;
        }

        if (index < 0) return 0;

        int notPick = f(arr, k, index - 1);
        int pick = 0;
        if (arr[index] <= k) {
            pick = f(arr, k - arr[index], index - 1);
        }

        return notPick + pick;
    }
}
