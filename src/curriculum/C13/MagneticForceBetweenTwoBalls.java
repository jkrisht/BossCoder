package curriculum.C13;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] position = {79, 74, 57, 22};
        int m = 4;
        System.out.println(new MagneticForceBetweenTwoBalls().maxDistance(position, m));
    }

    public int maxDistance(int[] position, int m) {
        if (position == null || position.length == 0 || m == 1) {
            return 0;
        }

        Arrays.sort(position);

        if (m == 2) {
            return position[position.length - 1] - 1;
        }

        int result = 0;

        int start = 0, end = position.length - 1;
        while (start <= end) {
            int mid =  start +(end - start) / 2;

            if (isPossibleToArrange(position, mid, m)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    public boolean isPossibleToArrange(int[] position, int distance, int ballsCount) {
        int previous = position[0];
        ballsCount--;

        for (int i = 1; i < position.length && ballsCount > 0; i++) {
            if (position[i] - previous >= distance) {
                ballsCount--;
                previous = position[i];
            }
        }

        return ballsCount == 0;
    }
}
