package Recursion;

import java.util.ArrayList;

public class PrintAllindexes {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 8};
        int el = 4;
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(find(arr, el, 0, list));
        System.out.println(find(arr, el, 0));
    }

    static ArrayList<Integer> find(int[] arr, int el, int index, ArrayList<Integer> list) {
        if (arr.length == index) {
            return list;
        }

        if (arr[index] == el) {
            list.add(index);
        }

        return find(arr, el, index + 1, list);
    }

    static ArrayList<Integer> find(int[] arr, int el, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr.length == index) {
            return list;
        }

        if (arr[index] == el) {
            list.add(index);
        }

        ArrayList<Integer> ansFromBelowCall = find(arr, el, index + 1);

        list.addAll(ansFromBelowCall);

        return list;
    }
}
