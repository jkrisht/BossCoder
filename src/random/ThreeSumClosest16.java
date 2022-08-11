package random;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest16 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        int target = 1;
        System.out.println(new ThreeSumClosest16().threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("Invalid array");
        }

        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }

                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
            }
        }

        return closest;
    }
}
