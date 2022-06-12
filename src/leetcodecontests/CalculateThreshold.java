package leetcodecontests;

public class CalculateThreshold {
    public static void main(String[] args) {
        int[] nums = {20, 30, 40, 90, 100};
        int totalAmountToPay = 222;
        int start = 0;
        int end = nums.length;
        int h = nums[end - 1];

        while (start <= h) {
            int mid = (start + h) / 2;
            int flag = getThresholdValue(nums, mid, totalAmountToPay);

            if (flag == 0) {
                System.out.println(mid);
                break;
            }

            if (flag == 1) {
                h = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }

    public static int getThresholdValue(int[] nums, int mid, int ans) {
        int sum = 0;
        for (int a = 0; a < nums.length; a++) { // 20, 30, 40, 90, 100
            if (nums[a] <= mid) {
                sum += nums[a];
            } else {
                sum += mid;
            }
        }

        if (sum == ans) {
            return 0;
        } else if (sum < ans) {
            return 2;
        }

        return 1;
    }
}
