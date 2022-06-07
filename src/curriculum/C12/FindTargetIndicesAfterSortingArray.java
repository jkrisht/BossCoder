package curriculum.C12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 3, 2}; // 1,2,2,3,5,6,7
        int k = 3;
        System.out.println(new FindTargetIndicesAfterSortingArray().targetIndices(nums, k));
        System.out.println(new FindTargetIndicesAfterSortingArray().superSmartApproach(nums, k));
    }

    public List<Integer> superSmartApproach(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return list;
        }

        int lessThanTargetCount = 0, targetCount = 0;

        for (int num : nums) {
            if (num < target) {
                lessThanTargetCount++;
                continue;
            }

            if (num == target) {
                targetCount++;
            }
        }

        for (int i = 0; i < targetCount; i++) {
            list.add(lessThanTargetCount + i);
        }

        return list;
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return list;
        }

        Arrays.sort(nums);

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            System.out.println(mid + " -> " + start + " -> " + end);

            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            if (nums[mid] == target) {
                list.add(mid);
            }
        }

        Collections.sort(list);

        return list;
    }
}
