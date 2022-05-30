package curriculum.C11;

// https://leetcode.com/problems/number-of-1-bits/
public class NumberOf1Bits {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(new NumberOf1Bits().hammingWeight(n));
    }

    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count += (n & 1);
            n = n >>> 1;
        }

        return count;
    }
}
