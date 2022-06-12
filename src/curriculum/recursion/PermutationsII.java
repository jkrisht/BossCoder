package curriculum.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/permutations-ii/
public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(new PermutationsII().permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        permuteUnique(nums, result, 0);
        return result;
    }

    public void permuteUnique(int[] nums, List<List<Integer>> result, int index) {
        if (index >= nums.length) {
            List<Integer> integers = new ArrayList<>();
            for (int num : nums) {
                integers.add(num);
            }
            result.add(integers);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums, index, i);
                permuteUnique(nums, result, index + 1);
                swap(nums, index, i);
            }
        }
    }

    public void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }
}
