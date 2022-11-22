package org.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt_13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("CM"));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = populateRomanMap();

        int a = 0;
        int result = 0;

        while (a < s.length()) {
            if (a + 2 <= s.length() && map.get(s.substring(a, a + 1)) < map.get(s.substring(a + 1, a + 2))) {
                result +=( map.get(s.substring(a + 1, a + 2))  - map.get(s.substring(a, a + 1)));
                a += 2;
            } else {
                result += map.get(s.substring(a, a + 1));
                a++;
            }
        }
        return result;
    }

    public static Map<String, Integer> populateRomanMap() {
        Map<String, Integer> map = new HashMap<String, Integer>() {
        };

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        return map;
    }
}
