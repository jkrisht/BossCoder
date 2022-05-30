package curriculum.C11;

// https://www.geeksforgeeks.org/check-whether-k-th-bit-set-not/
public class KthBitIsSetOrNot {
    public static void main(String[] args) {
        int n = -75, k = 4;
        System.out.println(new KthBitIsSetOrNot().isKthBitSet(n, k));
    }

    public boolean isKthBitSet(int n, int k) {
        int op = n >> (k - 1) & 1;
        return op == 1;
    }
}
