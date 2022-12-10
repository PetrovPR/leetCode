package org.leetcode;

public class RemoveElement_27 {

    public static void main(String[] args) {
        removeElement(new int[]{3,2,2,3}, 2);
    }

    public static int removeElement(int[] nums, int val) {

        int start = 0;
        int end = nums.length ;
        while (start < end) {
            if (nums[start] ==  val) {
                nums[start] =  nums[end - 1];
                end--;
            }
            start++;
        }
        return start;
    }

}
