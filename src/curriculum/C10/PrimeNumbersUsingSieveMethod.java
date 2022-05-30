package curriculum.C10;

import java.util.Arrays;

public class PrimeNumbersUsingSieveMethod {
    public static void main(String[] args) {
        int n = 21;
        System.out.println(countPrimaryNumbers(n));
    }

    static int countPrimaryNumbers(int num) {
        int[] primes = new int[num + 1];
        Arrays.fill(primes, 1);
        primes[0] = 0;
        primes[1] = 0;

        for (int i = 2; i < Math.sqrt(num); i++) {
            if (primes[i] == 1) {
                for (int j = 2; i * j < num; j++) {
                    primes[i * j] = 0;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i] == 1) {
                count++;
                System.out.print(i + ", ");
            }
        }

        return count;
    }
}
