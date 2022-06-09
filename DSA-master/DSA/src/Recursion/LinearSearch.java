package Recursion;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        int el = 51;
        System.out.println(search(arr, el, 0));
    }

    static int search(int[] arr, int el, int index) {

        if (arr.length == index) {
            return -1;
        }

        if (arr[index] == el) {
            return index;
        }

        return search(arr, el, index + 1);

    }
}
