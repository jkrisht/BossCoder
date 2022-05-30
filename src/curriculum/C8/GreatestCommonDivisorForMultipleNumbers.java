package curriculum.C8;

public class GreatestCommonDivisorForMultipleNumbers {
    public static void main(String[] args) {
        int[] arr = {0, 0, 2, 2, 4};
        System.out.println(findGCD(arr));
    }

    public static int findGCD(int[] arr) {
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);

            if (result == 1) {
                return 1;
            }
        }

        return result;
    }

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }
}
