package curriculum.C12;

// https://leetcode.com/problems/find-peak-element/submissions/
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 2, 1};
        System.out.println(new FindPeakElement().smartSolution(nums));
    }

    public int smartSolution(int[] nums) {
        int res = -1;

        if (nums == null || nums.length == 0) {
            return res;
        }

        if (nums.length == 1) {
            return 0;
        }

        int n = nums.length - 1;

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[n] > nums[n - 1]) {
            return n;
        }

        int start = 0, end = n;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid >= 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                System.out.println(nums[mid - 1]);
                System.out.println(nums[mid + 1]);
                System.out.println(mid);
                return mid;
            } else if (mid >= 1 && nums[mid - 1] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("Invalid array");
        }

        if (nums.length == 1) {
            return 0;
        }

        if (nums.length == 2) {
            return nums[0] < nums[1] ? 1 : 0;
        }

        int index = -1;

        for (int i = 1; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
                return i;
            } else if (nums[i - 1] < nums[i] && index == -1) {
                index = i;
            }
        }

        return index == -1 ? nums[0] : index;
    }
}
