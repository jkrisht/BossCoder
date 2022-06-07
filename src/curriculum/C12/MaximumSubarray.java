package curriculum.C12;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, -1};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int result = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return result;
    }
}
