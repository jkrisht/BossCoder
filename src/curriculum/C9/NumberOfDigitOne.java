package curriculum.C9;

// https://leetcode.com/problems/number-of-digit-one/
public class NumberOfDigitOne {
    public static void main(String[] args) {
        int n = 13;
        // System.out.println(new NumberOfDigitOne().countDigitOne(n));
        System.out.println(new NumberOfDigitOne().smartSolution(n));
    }

    public int smartSolution(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
        }
        return ones;
    }

    public int countDigitOne(int n) {
        int count = 0;

        if (n <= 0) {
            return count;
        }

        if (n <= 9) {
            return ++count;
        }

        count = 1;

        for (int i = 10; i <= n; i++) {
            int digit = i;

            while (digit != 0) {
                int num = digit % 10;
                if (num == 1) {
                    count++;
                }
                digit /= 10;
            }
        }

        return count;
    }
}
