package Recursion;

// time: O(n!) * n
// space: O(n) + O(n)

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] freq = new boolean[arr.length];
        permutations(arr, ans, list, freq);
        System.out.println(ans);
    }

    static void permutations(int[] arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list, boolean[] freq) {
        if (arr.length == list.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0;i < arr.length;i++) {
            if (!freq[i]) {
                freq[i] = true;
                list.add(arr[i]);
                permutations(arr, ans, list, freq);
                list.remove(list.size() - 1);
                freq[i] = false;
            }
        }
    }
}
