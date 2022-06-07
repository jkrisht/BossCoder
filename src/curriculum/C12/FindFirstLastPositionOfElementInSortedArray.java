package curriculum.C12;

import java.util.Arrays;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(new FindFirstLastPositionOfElementInSortedArray().smartSolution(arr, 8)));
    }

    public int[] smartSolution(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        result[0] = findFirst(nums, target);

        if (result[0] != -1) {
            result[1] = findLast(nums, result[0], target);
        }

        return result;
    }

    public int findFirst(int[] nums, int target) {
        int pos = -1;
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            if (nums[mid] == target) {
                pos = mid;
            }
        }

        return pos;
    }

    public int findLast(int[] nums, int first, int target) {
        int pos = -1;
        int start = first, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            if (nums[mid] == target) {
                pos = mid;
            }
        }

        return pos;
    }


    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        if (nums == null || nums.length == 0) {
            return result;
        }

        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                int first = mid, last = mid;

                while (first >= 0 && last <= nums.length - 1) {
                    if (nums[first] != target && nums[last] != target) {
                        break;
                    }

                    if (nums[first] == target) {
                        first++;
                    }

                    if (nums[last] == target) {
                        last++;
                    }
                }

                return new int[]{first - 1, last - 1};
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
