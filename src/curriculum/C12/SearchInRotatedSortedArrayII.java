package curriculum.C12;

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 13;
        // System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));
        System.out.println(new SearchInRotatedSortedArrayII().smartSolution(nums, target));
    }

    public boolean smartSolution(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] == nums[end]) {
                end--;
            } else if (nums[mid] < nums[end]) {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            } else {
                if (target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }

        return false;
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        if (nums[0] == target) {
            return true;
        }

        if (nums[nums.length - 1] == target) {
            return true;
        }

        int pivot = findPivot(nums);
        System.out.println(pivot);

        if (pivot == -1) {
            return isTargetExists(nums, 0, nums.length - 1, target);
        } else if (nums[pivot] == target) {
            return true;
        } else if (target > nums[pivot - 1]) {
            return isTargetExists(nums, 0, pivot - 1, target);
        }

        return isTargetExists(nums, pivot + 1, nums.length - 1, target);
    }

    public int findPivot(int[] nums) { // 1, 0, 1, 1, 1
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid >= 1 && nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[mid] <= nums[0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public boolean isTargetExists(int[] nums, int start, int end, int target) {
        System.out.println(start + ", " + end);
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) { // 2, 5, 6, 0, 0, 1, 2
                return true;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
