package curriculum.recursion;

import java.util.Arrays;

// https://leetcode.com/problems/next-permutation/discuss/13994/Readable-code-without-confusing-ij-and-with-explanation
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {3,1,2};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        /**
         * Find non-decreasing index in the array
         */
        int pivot = findPivot(nums) - 1;
        if (pivot != -1) {
            int index = findNextValue(nums, nums[pivot]);
            swap(nums, pivot, index);
        }
        reverse(nums, pivot + 1);
    }

    public int findPivot(int[] nums) {
        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i - 1] < nums[i]) {
                return i;
            }
        }

        return 0;
    }

    public int findNextValue(int[] nums, int value) {
        for (int i = nums.length - 1; i >= 0; i++) {
            if (value < nums[i]) {
                return i;
            }
        }

        return -1;
    }

    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start <= end) {
            swap(nums, start++, end--);
        }
    }

    public void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }
}
