import java.util.*;

public class MinMaxGame {
    public static void main(String[] args) {
        int[] nums = {3};
        System.out.println(minMaxGame(nums));
    }

    public static int minMaxGame(int[] nums) {

        boolean f = false;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++) {
            list.add(nums[i]);
        }

        int size = nums.length;
        while(size != 1) {
            ArrayList<Integer> newList = new ArrayList<>();
            for(int i = 0;i < list.size() - 1;i+=2) {
                int el1 = list.get(i);
                int el2 = list.get(i + 1);

                if (!f) {
                    min = Math.min(el1, el2);
                    f = true;
                    newList.add(min);
                }
                else {
                    max = Math.max(el1, el2);
                    f = false;
                    newList.add(max);
                }
            }

            list.clear();
            list.addAll(newList);

            size = size / 2;
        }

        return list.get(0);
    }
}
