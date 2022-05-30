package curriculum.C10;

import java.util.Arrays;

public class TotalNumberOfDivisorsForGivenNumber {
    public static void main(String[] args) {
        int[] nums = {21};
        System.out.print(new TotalNumberOfDivisorsForGivenNumber().sumFourDivisors(nums));
    }

    public int sumFourDivisors(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int[] primes = new int[max + 1];
        Arrays.fill(primes, 1);

        for (int i = 2; i < Math.sqrt(max); i++) {
            if (primes[i] != 0) {
                for (int j = 2; i * j < max; j += i) {
                    primes[i * j] = 0;
                }
            }
        }

        int res = 0;

        for (int num : nums) {
            int divisorsSum = findDivisors(primes, num);

            if (divisorsSum == 4) {
                for (int i = 1; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        res += i;
                        if (i != num / i) {
                            res += num / i;
                        }
                    }
                }
            }
        }

        return res;
    }

    public int findDivisors(int[] primes, int num) {
        int count = 1;
        int currentNumCount = 0;
        int index = 2;
        int n = num;

        while (n != 0) {
            if (index < primes.length && primes[index] != 0 && n % index == 0) {
                n = n / index;
                currentNumCount++;
            } else {
                if (index >= primes.length - 1) {
                    break;
                }
                index++;
                count *= (currentNumCount + 1);
                currentNumCount = 0;
            }
        }

        return count;
    }
}