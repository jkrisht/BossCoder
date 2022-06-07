package curriculum.C12;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/submissions/
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 0, 1, 1};
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(arr));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("Invalid array");
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int start = 0, end = nums.length - 1;

        while (start < end) { // {1, 2, 2, 2, 0, 1, 1};
            int mid = (start + end) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[start]) {
                end = mid;
            } else {
                end--;
            }
        }

        return nums[end];
    }
}
