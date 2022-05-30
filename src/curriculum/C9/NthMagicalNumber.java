package curriculum.C9;

public class NthMagicalNumber {
    public static void main(String[] args) {
        int n = 4, a = 2, b = 3;
        System.out.println(new NthMagicalNumber().nthMagicalNumber(n, a, b));
    }

    public int nthMagicalNumber(int n, int a, int b) {
        long left = Math.min(a, b);
        long right = n * left;
        long mod = (long) (Math.pow(10, 9) + 7);
        long lcm = (a * b) / gcd(a, b);

        while (left < right) {
            long mid = (left + right) / 2;

            long val = (mid / a) + (mid / b) - mid / lcm;

            if (val < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int) (left % mod);
    }

    public long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }
}
