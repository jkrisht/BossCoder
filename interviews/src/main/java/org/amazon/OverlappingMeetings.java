package org.amazon;

import java.util.Arrays;
import java.util.Comparator;

public class OverlappingMeetings {
    public static void main(String[] args) {
        int[][] intervals = {{42, 45}, {0, 20}, {30, 40}, {20, 29}, {41, 50}};
        System.out.println(overlapMeetingsCount(intervals));
    }

    public static int overlapMeetingsCount(int[][] intervals) {
        int count = 0;

        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return count;
        }

        if (intervals.length == 1) {
            return count;
        }

        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        System.out.println(Arrays.deepToString(intervals));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                System.out.println(Arrays.toString(intervals[i]));
                count++;
            }
        }

        return count;
    }
}
