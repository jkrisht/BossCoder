package leetcodecontests.weeklycontest297;

public class CalculateTax {

    public static void main(String[] args) {
        int[][] nums = {{1,0}, {4, 25}, {5, 50}};
        int income = 2;
        System.out.println(new CalculateTax().calculateTax(nums, income));
    }

    public double calculateTax(int[][] brackets, int income) {
        if (brackets == null || brackets.length == 0 || brackets[0].length == 0 || income == 0) {
            return 0;
        }

        double result = 0;
        double prevAmount = 0;

        for (int[] tax : brackets) {
            double amount = Math.abs(tax[0] <= income ? tax[0] - prevAmount : income - prevAmount);
            result +=  amount * (tax[1] / 100.0);
            prevAmount = tax[0];
            if (tax[0] > income) {
                break;
            }
        }

        return result;
    }
}
