package curriculum.C10;

public class FactorsOfGivenNumber {
    public static void main(String[] args) {
        int N = 125;
        System.out.println(countFactors(N));
    }

    static int countFactors(int N) {
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                count++;
            }
        }

        return count;
    }
}
