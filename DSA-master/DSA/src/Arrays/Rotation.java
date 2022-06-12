package Arrays;

import java.util.Arrays;

public class Rotation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;
        f(arr, d);
    }

    static void f(int[] arr, int d) {

        for(int i = 0;i < d;i++) {
            int last = arr[arr.length - 1];

            for(int j = arr.length - 1;j >= i;j--) {
                if (j == i) {
                    arr[i] = last;
                    break;
                }
                int el = arr[j - 1];
                arr[j] = el;

            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
