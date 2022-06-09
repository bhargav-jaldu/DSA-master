package Recursion;

import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        subsets(arr, 0, list, ans);
        System.out.println(ans);
    }

    static void subsets(int[] arr, int index, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        if (index == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[index]);
        subsets(arr, index + 1, list, ans);
        list.remove(list.size() - 1);
        subsets(arr, index + 1, list, ans);
    }
}
