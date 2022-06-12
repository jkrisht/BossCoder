package binarySearch;

// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int count = Integer.MAX_VALUE;

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = 0, sum = 0, n = nums.length - 1;

        while (end <= n) {
            sum += nums[end];

            if (sum >= target) {
                while (sum >= target) {
                    sum -= nums[start++];
                }

                count = Math.min(count, end - start + 2);
            }

            end++;
        }

        return count == Integer.MAX_VALUE ? 0 : count;
    }
}
