package leetcodecontests.weeklycontest296;

import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        int k = 0;
        System.out.println(new PartitionArraySuchThatMaximumDifferenceIsK().partitionArraySmartApporach(nums, k));
    }

    public int partitionArraySmartApporach(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        Arrays.sort(nums);

        int c = 1, prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - nums[prev] <= k) continue;
            c++; prev = i;
        }
        return c;
    }

    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int partitionCount = 0, index = 0;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) { // 1, 2, 3, 5, 6
            int curr = nums[i];
            nums[i] = Math.max(curr, nums[i - 1]) - Math.min(curr, nums[i - 1]);

            if (nums[i] > k) {
                partitionCount++;
                nums[i] = curr;
                index = i;
            }
        }

        for (int i = index; i < nums.length - 1; i++) {
            if (nums[i] <= k) {
                partitionCount++;
            }
        }

        return partitionCount + 1;
    }
}
