package curriculum.C10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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

        HashMap<String, Integer> map = new HashMap();
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));

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
