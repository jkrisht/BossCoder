package curriculum.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        int target = 8;
        System.out.println(new CombinationSumII().combinationSum2(nums, target));
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        combSumHelper(nums, result, 0, 0, target, temp);
        return result;
    }

    public void combSumHelper(int[] nums, List<List<Integer>> result, int sum, int index, int target, List<Integer> temp) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            sum += nums[i];
            temp.add(nums[i]);
            combSumHelper(nums, result, sum, i, target, temp);
            temp.remove(temp.size() - 1);
            sum -= nums[i];
        }
    }
}
