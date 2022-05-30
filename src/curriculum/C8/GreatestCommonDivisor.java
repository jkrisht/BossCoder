package curriculum.C8;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(new GreatestCommonDivisor().greatestCommonDivisor(14, 21));
    }

    public int greatestCommonDivisor(int a, int b) {
        if (a == 0) {
            return b;
        }
        return greatestCommonDivisor(b % a, a);
    }

    // Time Complexity: O(log(max(a,b))
}
