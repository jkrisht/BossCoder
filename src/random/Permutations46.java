package random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations46 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new Permutations46().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, 0);
        return result;
    }

    public void helper(int[] nums, List<List<Integer>> result, int index) {

        if (index >= nums.length) {
            List<Integer> numbers = new ArrayList<>();
            for (int num : nums) {
                numbers.add(num);
            }
            result.add(numbers);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums, index, i);
                helper(nums, result, index + 1);
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
