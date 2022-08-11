package curriculum.C12;

import java.util.Arrays;

// https://leetcode.com/problems/single-element-in-a-sorted-array/
public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(nums.length);
        System.out.println(nums.length / 2);
        System.out.println(new SingleElementInSortedArray().singleNonDuplicate(nums));
        System.out.println(new SingleElementInSortedArray().smartSolution(nums));
    }

    public int smartSolution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0, end = nums.length - 1;

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[end] != nums[end - 1]) {
            return nums[end];
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            if ((mid % 2 == 0 && nums[mid + 1] == nums[mid]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return nums[start];
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("Invalid array");
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        int n = nums.length - 1;

        if (nums[n] != nums[n - 1]) {
            return nums[n];
        }

        int start = 0, end = nums.length - 1; // 3,3,7,7,10,11,11

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid >= 1 && nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (mid >= 1 && (end + 1 - mid) % 2 == 0 && nums[mid] != nums[mid - 1]) {
                end = mid - 1;
            } else {
                start = start + 1;
            }
        }

        return -1;
    }
}
