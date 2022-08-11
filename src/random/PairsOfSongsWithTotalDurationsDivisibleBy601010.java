package random;

public class PairsOfSongsWithTotalDurationsDivisibleBy601010 {
    public static void main(String[] args) {
        int[] time = {30, 30, 30, 30, 30};
        // System.out.println(new PairsOfSongsWithTotalDurationsDivisibleBy601010().numPairsDivisibleBy60(time));
        System.out.println(new PairsOfSongsWithTotalDurationsDivisibleBy601010().smartSolution(time));
        int value = (int) ((60000 * (60000-1L)) / 2);
        System.out.println(value);
    }

    public int smartSolution(int[] time) {
        if (time == null || time.length == 0) {
            return 0;
        }

        int count = 0;
        int[] rems = new int[60];

        for (int t : time) {
            rems[t % 60]++;
        }

        count += (rems[0] * (rems[0] - 1)) / 2;
        count += (rems[30] * (rems[30] - 1)) / 2;

        for (int i = 1; i <= 29; i++) {
            count += (rems[i] * rems[60 - i]);
        }

        return count;
    }

    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0) {
            return 0;
        }

        int pairsCount = 0;

        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                int sum = time[i] + time[j];
                if (sum % 60 == 0) {
                    pairsCount++;
                }
            }
        }

        return pairsCount;
    }
}
