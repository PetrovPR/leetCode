package org.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix_14 {
    public static void main(String[] args) {
        "leeetr".indexOf("lee");
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        String myWord = strs[0];
        int min = 0;
        int max = myWord.length()-1;
        int middle= max/2;

        while (min < max) {
//            String sub = myWord.substring()
        }

    return "";
    }
}
