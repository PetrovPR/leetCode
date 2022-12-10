package org.leetcode;

import java.util.*;

public class IntersectionTwoArrays_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length == 0 || nums1.length == 0) {
            return new int[]{};
        }


        if (nums1.length < nums2.length) {
           return getArray(nums2, nums1);

        } else {
           return getArray(nums1, nums2);
        }
    }


   public int[] getArray(int[] nums1, int[] nums2) {
       List<Integer> list = new ArrayList<>();

       Map<Integer, Integer> map = new HashMap<>();

       for (int i = 0; i < nums1.length; i ++) {
           map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
       }
       for (int i = 0; i < nums2.length; i ++) {
           if (map.containsKey(nums2[i])) {
               list.add(nums2[i]);
               if(map.get(nums2[i]) > 1) {
                   map.put(nums2[i], map.get(nums2[i]) -1);
               } else {
                   map.remove(nums2[i]);
               }
           }
       }
       return list.stream().mapToInt(Integer::intValue).toArray();
   }
}
