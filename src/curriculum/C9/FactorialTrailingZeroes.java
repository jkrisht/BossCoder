package curriculum.C9;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        int n = 200;
        System.out.println(new FactorialTrailingZeroes().smartSolution(n));
        System.out.println(new FactorialTrailingZeroes().calculateFactorial(n));
    }

    public int smartSolution(int n) {
        int count = 0;

        while (n > 0) {
            n /= 5;
            System.out.println(n);
            count += n;
        }

        return count;
    }

    public int trailingZeroes(int n) {
        if (n <= 4) {
            return 0;
        }
        int trailingZeroes = 0;
        System.out.println(calculateFactorial(n));

        return trailingZeroes;
    }

    public int calculateFactorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * calculateFactorial(n - 1);
    }
}
