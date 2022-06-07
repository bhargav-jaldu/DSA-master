import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 10}; //
        f(arr);
    }

    private static void f(int[] arr) {

        int whereToInsert = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int el1 = arr[i];
            int el2 = arr[i + 1];

            int diff = Math.abs(el1 - el2);
            max = Math.max(diff, max);

            if (max > whereToInsert) {
                if (el1 > el2) {
                    whereToInsert = i + 1;
                }
                else {
                    whereToInsert = i;
                }
            }
        }

        System.out.println(whereToInsert);

//        which num we have to insert
//        find max el
        int maxEl = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxEl = Math.max(maxEl, arr[i]);
        }

        System.out.println(maxEl);

//        Add everything to the list
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < maxEl; i++) {
            list.add(whereToInsert, i);
            System.out.println(list);

//            find cost
            int cost = 0;
            for (int j = 0; j < list.size() - 1; j++) {
                int el1 = list.get(j);
                int el2 = list.get(j + 1);

                int diff = el1 - el2;
                int sq = diff * diff;
                System.out.println(el1 + " " + el2 + " " +sq);
                cost += sq;
            }
            list.remove(whereToInsert);

            res = Math.min(cost, res);
        }

        System.out.println(res);
    }
}
