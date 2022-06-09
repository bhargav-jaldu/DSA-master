package Recursion;

public class SortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 19, 12};
        System.out.println(sorted(arr, 0));
    }

    private static boolean sorted(int[] arr, int index) {

        if (index == arr.length - 1) {
            return true;
        }

        int el1 = arr[index];
        int el2 = arr[index + 1];

        if (el1 <= el2) {
            if (!sorted(arr, index + 1)) {
                return false;
            }
        }
        else {
            return false;
        }

        return true;
    }
}
