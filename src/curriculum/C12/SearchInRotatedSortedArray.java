package curriculum.C12;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {1};
        int target = 1;
        // System.out.println(new SearchInRotatedSortedArray().search(arr, target));
        System.out.println(new SearchInRotatedSortedArray().searchNextApproach(arr, target));
    }

    public int smartApproach(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        while (start <= end) { // 4, 5, 6, 7, 0, 1, 2};
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] <= target) {

            } else {
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int result = -1;

        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid] && target >= nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public int searchNextApproach(int[] nums, int target) {
        int result = -1;

        if (nums == null || nums.length == 0) {
            return result;
        }

        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }

        int pivot = findPivotIndex(nums);
        pivot = pivot == -1 ? 0 : pivot;


        if (nums[pivot] == target) {
            return pivot;
        } else if (target < nums[pivot] && target >= nums[0]) {
            return findIndex(nums, target, 0, pivot - 1);
        } else {
            return findIndex(nums, target, pivot + 1, nums.length - 1);
        }
    }

    public int findPivotIndex(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid >= 1 && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            } else if (nums[mid] > nums[0]) {
                start = mid + 1;
            } else {
                end = end - 1;
            }
        }

        return -1;
    }

    public int findIndex(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = end - 1;
            }
        }

        return -1;
    }
}
