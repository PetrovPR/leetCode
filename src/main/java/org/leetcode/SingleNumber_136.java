package org.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber_136 {

    public static void main(String[] args) {
        int a = 1;
        a ^= 2;
        System.out.println(a);
    }

    public static int singleNumber2(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^=num;
        }
        return a;
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, 1);
            }
        }
        return map.keySet().iterator().next();
    }
}
