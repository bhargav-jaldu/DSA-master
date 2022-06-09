package Recursion;

import java.util.ArrayList;

public class Subsequence {
    public static void main(String[] args) {
        String str = "abc";
        char[] arr = str.toCharArray();

        ArrayList<Character> list = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        subsets(arr, 0, list, ans);
        System.out.println(ans);
    }

    private static void subsets(char[] arr, int index, ArrayList<Character> list, ArrayList<String> ans) {
        if (index == arr.length) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                str.append(list.get(i));
            }
            ans.add(str.toString());
            return;
        }

        char ch = arr[index];
        list.add(ch);
        subsets(arr, index + 1, list, ans);
        list.remove(Character.valueOf(ch));
        subsets(arr, index + 1, list, ans);
    }
}
