package org.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class TwoSum_01
{
    public static void main( String[] args )
    {
        System.out.print(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {


        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int a = 0; a < nums.length; a++) {
            int search = target - nums[a];
            if (map.containsKey(search)) {
                return new int[]{map.get(search),a};
            }

            map.put(nums[a], a);
        }
        return null;
    }
}
