package curriculum.C11;

// https://leetcode.com/problems/single-number-ii/
public class SingleNumberII {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(new SingleNumberII().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException("Invalid array");
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int res = 0;
        for (int i = 0; i < 64; i++) {
            int sum = 0;

            for (int num : nums) {
                sum += num >> i & 1;
            }

            sum %= 3;
            res |= sum << i;
        }

        return res;
    }
}
