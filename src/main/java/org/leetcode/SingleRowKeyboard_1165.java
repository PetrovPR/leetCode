package org.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleRowKeyboard_1165 {

    public static void main(String[] args) {

        System.out.println(calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));
    }

    public static int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();

        int counter = 0;

        for (char c: keyboard.toCharArray()) {
            map.put(c, counter++);
        }

        counter = 0;
        int previous = 0;

        for (char ch : word.toCharArray()) {
            int position = map.get(ch);
            if (position > previous) {
                counter += position - previous ;
            } else {
                counter += previous - position;
            }
            previous = position;
        }

        return counter;
    }
}
