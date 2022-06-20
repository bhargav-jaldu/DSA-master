package Blind75;

import java.util.*;

public class LongestSubstringWithOutRepeChars {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        int ans = 0;
        while(j < s.length()) {

            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            else {
                set.add(s.charAt(j));
                ans = Math.max(set.size(), ans);
                j++;
            }
        }

        return ans;
    }
}
