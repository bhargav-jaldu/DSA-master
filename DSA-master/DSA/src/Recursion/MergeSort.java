package Recursion;

import java.util.*;

public class MergeSort {
    public static void main(String[] args) {

        int[] arr = {90, 80, 10, 30, 100, 34, 200};
        int[] ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] ans = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                ans[k] = left[i];
                i++;
            }
            else {
                ans[k] = right[j];
                j++;
            }
            k++;
        }

        if (i < left.length) {
            ans[k] = left[i];
            k++;
            i++;
        }

        if (j < right.length) {
            ans[k] = right[j];
            j++;
            k++;
        }

        return ans;
    }
}
