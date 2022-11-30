package org.leetcode;

public class RemoveDuplicates_26 {


    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2,2,3,4,5,5,6}));
    }

    public static int removeDuplicates(int[] nums) {
        int previous = 0;
        for(int i = 0; i< nums.length; i++) {
            if(nums[previous] < nums[i]){
                nums[previous + 1] = nums[i];
                previous++;
            }
        }
        return previous + 1;
    }
}
