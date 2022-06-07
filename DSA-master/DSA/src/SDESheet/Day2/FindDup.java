package SDESheet.Day2;


import java.util.*;

public class FindDup {
    public static void main(String[] args) {
        int[] arr = {3,1,3,4,2};
        System.out.println(find(arr));
        System.out.println(Arrays.toString(arr));
    }

    private static int find(int[] arr) {
        int i = 0, n = arr.length;
        while(i < n) {
            int num = arr[i];
            int whereNumShouldBe = num - 1;
            if (num != arr[whereNumShouldBe]) {
                swap(arr, i, whereNumShouldBe);
            }
            else {
                if (num <= i) {
                    return num;
                }
                i++;
            }
        }

        return -1;
    }

    private static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
