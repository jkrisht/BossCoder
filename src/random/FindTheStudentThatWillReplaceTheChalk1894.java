package random;

public class FindTheStudentThatWillReplaceTheChalk1894 {
    public static void main(String[] args) {
        int[] chalk = {};
        int k = 134221332;
        System.out.println(new FindTheStudentThatWillReplaceTheChalk1894().chalkReplacer(chalk, k));
    }

    public int chalkReplacer(int[] chalk, int k) {
        if (chalk == null || chalk.length == 0) {
            return 0;
        }

        long sum = 0;

        for (int num : chalk) {
            sum += num;
        }

        long left = k % sum;

        for (int i = 0; i < chalk.length; i++) {
            if (left >= chalk[i]) {
                left -= chalk[i];
            } else {
                return i;
            }
        }

        return -1;
    }
}
