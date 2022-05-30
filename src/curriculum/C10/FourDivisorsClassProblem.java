package curriculum.C10;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/four-divisors/
public class FourDivisorsClassProblem {
    public static void main(String[] args) {
        int[] arr = {8224};
        System.out.println(new FourDivisorsClassProblem().sumFourDivisorsUsingSqrt(arr));
    }

    public int sumFourDivisorsUsingSqrt(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int res = 0;

        for (int num : nums) {
            int count = 0;
            int sum = 0;
            for (int i = 1; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    System.out.println(num +" -> " + count + " -> " + i);
                    sum += i;

                    if (i != num / i) {
                        count += 2;
                        sum += num / i;
                    } else {
                        count++;
                    }
                }
            }

            if (count == 4) {
                res += sum;
            }
        }

        return res;
    }

    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        if (nums == null || nums.length <= 0) {
            return sum;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int numSum = 0;

            for (int j = 1; j <= nums[i]; j++) {
                if (nums[i] % j == 0) {
                    count++;
                    numSum += j;
                }
            }

            if (count == 4) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], numSum * 2);
                    continue;
                }
                map.put(nums[i], numSum);
            }
        }

        return map.values().stream().reduce(0, Integer::sum);
    }
}
