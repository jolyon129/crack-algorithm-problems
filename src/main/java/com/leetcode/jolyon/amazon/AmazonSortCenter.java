package com.leetcode.jolyon.amazon;

import java.util.*;

/**
 * In Amazon's sort center, a computer system decides what packages are to be
 * loaded on what trucks. All rooms and spaces are abstracted into space units
 * which is represented as an integer. For each type of truck, they have
 * different space units, For each package, they will be occupying different
 * space units.
 * <p>
 * As a software development engineer in sort centers, you will need to write a
 * method, Give truck space units and a list of product space units, find out
 * exactly TWO products that fit into the truck. You will also implement an
 * internal rule that the truck has to reserve exactly 30 space units for safety
 * purposes. Each package is assigned a unique ID, numered from 0 to N-1
 * <p>
 * Conditions
 * <p>
 * You will pick up exactly 2 packages You cannot pick up one package twice. If
 * you have muliple pairs, select the pair with the largest package. Input The
 * input to the function/method consists of two arguments are
 * <p>
 * truckSpace : an integer representing the truck space. packagesSpace : a list
 * of integers representing the space units occupying by packages.
 * <p>
 * Output Return a list of integers representing the IDs of two packages who
 * combine space will leave exactly 30 space units on the truck.
 */

/**
 * The statement want to find a pair which sums up to a exact number. Hence, we
 * don't need to sort them. Just use freqMap and calculate on the fly.
 */

/*
Input: truckSpace = 90, packagesSpace = [1, 10, 25, 35, 60]
Output: [2, 3]
Explaination: Given a truck of `90` space units, a list of packages space units `[1, 10, 25, 35, 60]`.
Your method should select the thrid(ID-2) and fouth (ID-3) package since you have to reserve exactly 30 space units.
https://leetcode.com/discuss/interview-question/271073/Amazon-or-Online-Assessment-2019-or-Sort-Center
 */
public class AmazonSortCenter {
    public List<Integer> twoSum(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        int maxNum = 0; //keep track of the largest number in the answer list

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                if (Math.max(diff, nums[i]) > maxNum) //only update the answer when its larger
                {
                    maxNum = Math.max(diff, nums[i]);
                    List<Integer> list = new ArrayList<>();
                    list.add(map.get(diff));
                    list.add(i);
                    ans = list;
                }
            }
            map.put(nums[i], i);
        }
        return ans;
    }


}
