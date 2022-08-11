package org.amazon;

import java.util.Arrays;

// https://prepfortech.in/interview-topics/sorting/check-if-a-person-can-attend-all-meetings/
public class MeetingsCollision {
    public static void main(String[] args) {
        int[][] intervals = {{0, 20}, {30, 40}, {20, 29}, {41, 50}};
        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            throw new RuntimeException("Intervals are empty");
        }

        if (intervals.length == 1) {
            return true;
        }

        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[1] < o2[1]) {
                return 1;
            }

            return 0;
        }));

        System.out.println(Arrays.deepToString(intervals));

        for (int i = 1; i < intervals.length; i++) {
            if (!(intervals[i][0] >= intervals[i - 1][1])) {
                return false;
            }
        }

        return true;
    }
}
