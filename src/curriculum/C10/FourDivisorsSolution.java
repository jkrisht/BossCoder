package curriculum.C10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourDivisorsSolution {
    public static void main(String[] args) {
        int[] arr = {21, 3, 4};
        System.out.println(new FourDivisorsSolution().sumFourDivisors(arr));
    }

    public int sumFourDivisors(int[] nums) {
        int res = 0;

        if (nums == null || nums.length <= 0) {
            return res;
        }

        Arrays.sort(nums);
        List<Integer> primes = getPrimeNumbers(nums[nums.length - 1]);

        for (int num : nums) {
            int count = 0;
            int sum = 0;
            int index = 0;
            while (num != 0) {
                num = num % primes.get(index);
                count++;
            }

            if (count == 4) {
                res += sum;
            }
        }

        return res;
    }

    public List<Integer> getPrimeNumbers(int num) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (int i = 4; i <= num; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }

        return list;
    }

    public boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
