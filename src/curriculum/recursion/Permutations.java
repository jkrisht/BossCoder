package curriculum.recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/
// Solution: https://leetcode.com/problems/permutations/discuss/2135941/Java-Runtime%3A-1-ms-faster-than-96.63
public class Permutations {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(new Permutations().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        permute(result, 0, nums);
        return result;
    }

    public void permute(List<List<Integer>> result, int index, int nums[]) {
        /**
         * When index reaches length of the nums, then load the values into result
         */
        if (index >= nums.length) {
            List<Integer> res = new ArrayList<>();
            for (int num : nums) {
                res.add(num);
            }
            result.add(res);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            /**
             * Swap the values to make a permute
             */
            swap(nums, index, i);
            permute(result, index + 1, nums);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }
}
