package Arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {5,4,-1,7,8};
        f(arr);
    }

    private static void f(int[] arr) {

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = i; j < arr.length; j++) {
                max += arr[j];
                ans = Math.max(max, ans);
            }
        }

        System.out.println(ans);
    }
}
