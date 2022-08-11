package curriculum.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/subsets/submissions/
public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};
        System.out.println(new SubsetsII().subsetsWithDup(nums));
    }

    public void powerSets(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.add(nums[i])) {
                curr.add(nums[i]);
                powerSets(nums, i + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        powerSets(nums, 0, new ArrayList<>(), list);
        return list;
    }
}
