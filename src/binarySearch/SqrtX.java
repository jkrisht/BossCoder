package binarySearch;

public class SqrtX {
    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(new SqrtX().mySqrt(x));
        System.out.println(new SqrtX().smartSqrt(x));
    }

    public int smartSqrt(int x) {
        if (x == 0) {
            return x;
        }

        long start = 0, end = x;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sq = mid * mid;

            if (sq == x) {
                return (int) mid;
            } else if (sq < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return (int) end;
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }


        int start = 1, end = x;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }
}
