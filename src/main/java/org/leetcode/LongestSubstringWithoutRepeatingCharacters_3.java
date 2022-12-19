package org.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_3 {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
    public static int lengthOfLongestSubstring(String s) {

        int max = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < s.length() ; j ++) {
            if (map.containsKey(s.charAt(j))) {
                i = map.get(s.charAt(j));
                max = Math.max(max, j - i + 1);
            }
            map.put(s.charAt(j), j + 1);
        }
        return max;
    }
}
