package random;

import java.util.Arrays;

// https://leetcode.com/problems/sort-an-array/
public class SortAnArray912 {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        System.out.println(Arrays.toString(new SortAnArray912().sortArray(nums)));
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int mid = nums.length / 2;

        int[] leftArr = new int[mid];
        int[] rightArr = new int[mid];

        if (nums.length % 2 != 0) {
            rightArr = new int[mid + 1];
        }

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = nums[i];
        }

        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = nums[mid + i];
        }

        leftArr = sortArray(leftArr);
        rightArr = sortArray(rightArr);

        return mergeArrays(leftArr, rightArr);
    }

    public int[] mergeArrays(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int l = 0, r = 0;
        for (int i = 0; i < result.length; i++) { // 5 , 2
            if (l < left.length && r < right.length) {
                if (left[l] < right[r]) {
                    result[i] = left[l++];
                } else {
                    result[i] = right[r++];
                }
            } else if (r < right.length) {
                result[i] = right[r++];
            } else if (l < left.length) {
                result[i] = left[l++];
            }
        }

        return result;
    }
}
