package binarySearch;

import java.util.HashSet;

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        System.out.println(new SumOfSquareNumbers().anotherApproach(2147483600));
    }

    public boolean anotherApproach(int c) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i <= Math.sqrt(c); i++) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                System.out.println(c - i * i);
                System.out.println(i*i);
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum(int c) {
        if (c == 0 || c == 1) {
            return true;
        }

        int start = 0, end = (int) Math.sqrt(c);

        while (start <= end) {
            int val = start * start + end * end;

            if (val == c) {
                return true;
            } else if (val > c) {
                end--;
            } else {
                start++;
            }
        }

        return false;
    }
}
