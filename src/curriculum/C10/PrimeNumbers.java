package curriculum.C10;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
    public static void main(String[] args) {
        new PrimeNumbers().primeNumbers();
    }

    public void primeNumbers() {
        int num = 1000000;
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for (int i = 2; i < num; i++) {
            if (isPrime(i)) {
                list.add(i);
            }
        }

        System.out.println(list);
    }

    public boolean isPrime(int n) {
        if (n >= 1 && n <= 3) {
            return true;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
