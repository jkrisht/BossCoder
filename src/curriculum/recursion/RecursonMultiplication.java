package curriculum.recursion;

public class RecursonMultiplication {
    public static void main(String[] args) {
        System.out.println(multiply(100, 3));
    }

    public static int multiply(int n, int mul) {
        if (mul == 0) {
            return 0;
        }

        return n + multiply(n, mul - 1);
    }
}
