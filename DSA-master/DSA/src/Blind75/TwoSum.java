package Blind75;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++) {
            int el = nums[i];

            int search = target - el;
            if (map.containsKey(el)) {
                int ind = map.get(el);
                return new int[]{ind, i};
            }
            else {
                map.put(search, i);
            }
        }

        return new int[]{-1, -1};
    }
}
