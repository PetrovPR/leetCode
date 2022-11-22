package org.leetcode;

public class IsPalindrome_09 {
    public static void main(String[] args) {
        System.out.print(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        int reverce = 0;
        if(x < 0 || (x % 10 == 0 && x != 0 )) return false;
        while (reverce < x) {
            reverce = reverce * 10 + x % 10;
            x /= 10;
        }
        return  (reverce == x) || (reverce == x/ 10);
    }
}
