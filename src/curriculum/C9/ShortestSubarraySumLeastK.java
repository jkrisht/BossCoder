package curriculum.C9;

public class ShortestSubarraySumLeastK {
    public static void main(String[] args) {
        int[] arr = {48, 99, 37, 4, -31};
        int k = 140;
        System.out.println(new ShortestSubarraySumLeastK().shortestSubarray(arr, k));
    }

    public int shortestSubarray(int[] nums, int k) {
        int len = 0;

        if (nums == null || nums.length <= 0) {
            return len;
        }

        if (nums.length == 1) {
            return nums[0] == k ? 1 : len;
        }

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while ( i < j) {

        }

        return len;
    }
}
