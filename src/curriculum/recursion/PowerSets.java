package curriculum.recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/submissions/
public class PowerSets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new PowerSets().subsets(nums));
    }

    public void powerSets(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            powerSets(nums, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        powerSets(nums, 0, new ArrayList<>(), list);
        return list;
    }
}
