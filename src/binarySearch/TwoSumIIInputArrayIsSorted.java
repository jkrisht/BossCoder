package binarySearch;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        int[] nums = {-1,0};
        int target = -1;
        System.out.println(Arrays.toString(new TwoSumIIInputArrayIsSorted().twoSum(nums, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1) {
            return new int[]{-1, -1};
        }

        int[] result = new int[]{-1, -1};
        int start = 0, end = numbers.length - 1;

        while (start <= end) {
            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }

        return result;
    }
}
