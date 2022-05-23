package curriculum.C6;

// https://leetcode.com/problems/max-chunks-to-make-sorted-ii/discuss/1871104/Java-Solution-Beats-100-left-max-and-right-min-approach
public class MaxChunksToMakeSortedII {
    public static void main(String[] args) {
        int[] arr = {4,2,2,1,1};
        System.out.println(new MaxChunksToMakeSortedII().maxChunksToSortedWorkableSolution(arr));
    }

    public int maxChunksToSortedWorkableSolution(int[] arr) {
        int result = 0;

        if (arr == null || arr.length < 1) {
            return result;
        }

        int[] minArr = new int[arr.length + 1];
        minArr[minArr.length - 1] = Integer.MAX_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {
            minArr[i] = Math.min(arr[i], minArr[i + 1]);
        }

        int maxValue = arr[0];

        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(arr[i], maxValue);
            if (maxValue <= minArr[i + 1]) {
                result++;
            }
        }

        return result;
    }

    public int maxChunksToSorted(int[] arr) {
        int result = 0;

        if (arr == null || arr.length < 1) {
            return result;
        }

        int maxValue = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (maxValue <= arr[i]) {
                result++;
            }
        }

        result++;

        return result;
    }

}
