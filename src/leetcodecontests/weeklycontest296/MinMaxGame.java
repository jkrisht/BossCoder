package leetcodecontests.weeklycontest296;

public class MinMaxGame {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 7, 1}; // 3, 6, 1
        System.out.println(new MinMaxGame().minMaxGame(nums));
    }

    public int minMaxGame(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException("Invalid array");
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] newNums = new int[nums.length / 2];

        while (newNums.length != 1) {
            for (int i = 0; i < newNums.length; i++) {
                if (i % 2 == 0) {
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }

            nums = newNums;
            newNums = new int[newNums.length / 2];
        }

        return Math.min(nums[0], nums[1]);
    }
}
