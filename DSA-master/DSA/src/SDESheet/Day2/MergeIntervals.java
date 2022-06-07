package SDESheet.Day2;

import java.util.ArrayList;

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<Pair> list = new ArrayList<>();
        list.add(new Pair(1, 3));
        list.add(new Pair(2, 6));
        list.add(new Pair(8, 10));
        list.add(new Pair(15, 18));

        merge(list);
    }

    private static void merge(ArrayList<Pair> list) {
        ArrayList<Pair> ans = new ArrayList<>();

        for(int i = 0;i < list.size();i++) {
            int first = list.get(i).x;
            int end = list.get(i).y;

            if (!ans.isEmpty()) {
                if (first <= ans.get(ans.size() - 1).y) {
                    continue;
                }
            }

            for(int j = i + 1;j < list.size();j++) {
                int sFirst = list.get(j).x;
                int sEnd = list.get(j).y;

                if (sFirst <= end) {
                    end = sEnd;
                }
            }

            ans.add(new Pair(first, end));
        }

//        print the ans
        for(int i = 0;i < ans.size();i++) {
            int first = ans.get(i).x;
            int second = ans.get(i).y;
            System.out.println(first + " " + second);
        }
    }
}
