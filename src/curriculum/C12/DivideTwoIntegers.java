package curriculum.C12;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend = -2147483648, divisor = -1;
        // System.out.println(new DivideTwoIntegers().divide(dividend, divisor));
    }

    public int smartApproach(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MIN_VALUE;
        }

        boolean sign = (dividend >= 0) && (divisor >= 0);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;

        while (dividend - divisor >= 0) {
            int count = 0;
        }

        return result;
    }

    public int divide(int dividend, int divisor) {
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        System.out.println(((dividend < 0) ^ (divisor < 0)));

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (divisor == 1) {
            return sign == -1 ? -dividend : dividend;
        }

        if (dividend == 1) {
            return 0;
        }

        int quotient = 0;

        while (dividend >= divisor) {
            dividend -= divisor;
            quotient++;
        }

        return sign == -1 ? quotient : -quotient;
    }
}
