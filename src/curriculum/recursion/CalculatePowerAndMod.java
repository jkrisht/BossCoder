package curriculum.recursion;

public class CalculatePowerAndMod {
    public static void main(String[] args) {
        // N = number
        // K = power
        // D = Modular
        int N = 3, K = 4, D = 7;
        System.out.println(calculatePowAndMod(N, K, D));
        System.out.println(calculatePowAndMod1(N, K, D));

        int pow = (int) Math.pow(N, K);
        System.out.println(pow % D);
    }

    public static int calculatePowAndMod(int N, int K, int D) {
        if (K == 0) {
            return 1;
        }

        return (N * calculatePowAndMod(N, K - 1, D)) % D;
    }

    public static int calculatePowAndMod1(int N, int K, int D) {
        if (K == 0) {
            return 1;
        }

        int ans = (calculatePowAndMod(N, K / 2, D));

        return (ans * ans) % D;
    }
}
