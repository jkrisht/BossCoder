package curriculum.C11;

// https://leetcode.com/problems/reverse-bits/
public class ReverseBits {
    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(new ReverseBits().reverseBits(n));
    }

    public int reverseBits(int n) {
        int res = 0;

        for (int i = 1; i <= 32; i++) {
            res = (res << 1) + (n & 1);
            n = n >> 1;
        }

        return res;
    }
}
