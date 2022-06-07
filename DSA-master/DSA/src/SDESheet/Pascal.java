package SDESheet;

import java.util.*;

public class Pascal {
    public static void main(String[] args) {
        List<List<Integer>> ans = generate(5);
        System.out.println(ans);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        int count = 0;
        int k = 1;
        while(true) {
            List<Integer> ans = new ArrayList<>();

            for(int i = 0;i < k;i++) {
                if (i == 0) {
                    ans.add(1);
                }
                else if (i == k - 1) {
                    ans.add(1);
                }
                else {
                    int el1 = list.get(count - 1).get(i - 1);
                    int el2 = list.get(count - 1).get(i);
                    ans.add(el1 + el2);
                }
            }

            if (count == numRows) {
                break;
            }

            list.add(ans);
            k++;

            count++;
        }

        return list;
    }
}
