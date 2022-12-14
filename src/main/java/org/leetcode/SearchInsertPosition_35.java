package org.leetcode;

public class SearchInsertPosition_35 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3}, 2));
    }

    public static int searchInsert(int[] nums, int target) {

        int begin = 0;
        int  middle = 0;
        int end = nums.length -1;

        while (begin <= end) {
            middle = ((end - begin) / 2 + begin);
            if (nums[middle] > target) {
                end = middle -1;
            } else if (nums[middle] < target) {
                begin = middle + 1;
            } else {
                return middle;
            }
        }
        return  begin;
    }
}
