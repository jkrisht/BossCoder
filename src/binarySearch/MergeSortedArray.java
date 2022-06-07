package binarySearch;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {0};
        int[] arr2 = {1};
        int m = 0, n = 1;
        // new MergeSortedArray().merge(arr1, m, arr2, n);
        new MergeSortedArray().smartMerge(arr1, m, arr2, n);
    }

    public void smartMerge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return;
        }

        int l1 = m - 1, l2 = n - 1;

        for (int i = m + n - 1; i >= 0; i--) {
            if (l2 == -1) {
                break;
            } else if (l1 == -1 || nums2[l2] >= nums1[l1]) {
                nums1[i] = nums2[l2--];
            } else {
                nums1[i] = nums1[l1--];
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return;
        }

        if (nums1.length == 1 && nums2.length == 1) {
            if (nums1[0] < nums2[0]) {
                nums1[0] = nums2[0];
            }
        }

        int lArr = 0, rArr = 0;
        int lLen = m, rLen = n;
        int[] result = new int[lLen];

        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] == 0 && nums1[i] < nums1[i - 1]) {
                nums1[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (lArr < lLen && rArr < rLen && nums1[i] != 0) {
                if (nums1[lArr] > nums2[rArr]) {
                    result[i] = nums2[rArr++];
                } else {
                    result[i] = nums1[lArr++];
                }
            } else if (lArr < lLen) {
                result[i] = nums1[lArr++];
            } else if (rArr < rLen) {
                result[i] = nums2[rArr++];
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = result[i];
        }

        System.out.println(Arrays.toString(nums1));
    }
}
