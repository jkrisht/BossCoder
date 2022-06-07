package binarySearch;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(Integer.MAX_VALUE));
    }

    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }

        long start = 1, end = num / 2;

        while (start <= end) {
            long mid = (start + end) / 2;
            long perfSq = mid * mid;

            if (perfSq == num) {
                return true;
            } else if (perfSq < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
