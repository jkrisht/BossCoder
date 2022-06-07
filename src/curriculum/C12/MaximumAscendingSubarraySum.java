package curriculum.C12;

// https://leetcode.com/problems/maximum-ascending-subarray-sum/
public class MaximumAscendingSubarraySum {
    public static void main(String[] args) {
        int[] nums = {6};
        System.out.println(new MaximumAscendingSubarraySum().maxAscendingSum(nums));
    }

    public int smartSolution(int[] nums) {
        int res = nums[0],temp = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] > nums[i-1])
                temp+=nums[i];
            else
                temp = nums[i];
            res = Math.max(res,temp);
        }
        return res;
    }

    public int maxAscendingSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int result = 0;

        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i - 1];

            while (i < nums.length && nums[i - 1] < nums[i]) {
                sum += nums[i];
                i++;
            }

            result = Math.max(result, sum);
        }

        return result;
    }

}
