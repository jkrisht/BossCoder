package random;

import java.util.PriorityQueue;


class Apple {
    int apples;
    int days;

    public Apple(int apples, int days) {
        this.apples = apples;
        this.days = days;
    }
}

public class MaximumNumberOfEatenApples1705 {
    public static void main(String[] args) {
        int[] apples = {2, 1, 10};
        int[] days = {2, 10, 1};

        System.out.println(new MaximumNumberOfEatenApples1705().eatenApplesSmartly(apples, days));
    }

    public int eatenApplesSmartly(int[] apples, int[] days) {
        int count = 0;

        if (apples == null || apples.length == 0) {
            return 0;
        }

        PriorityQueue<Apple> applePQ = new PriorityQueue<>((a, b) -> a.days - b.days);

        for (int i = 0; i < apples.length || !applePQ.isEmpty(); i++) {
            if (i < apples.length && apples[i] != 0) {
                applePQ.add(new Apple(apples[i], i + days[i]));
            }

            while (!applePQ.isEmpty() && applePQ.peek().days <= i) {
                applePQ.poll();
            }

            if (!applePQ.isEmpty()) {
                Apple apple = applePQ.poll();
                apple.apples -= 1;

                if (apple.apples > 0) {
                    applePQ.add(apple);
                }

                count++;
            }
        }

        return count;
    }

    public int eatenApples(int[] apples, int[] days) {
        int count = 0;
        int n = 1;

        if (apples == null || apples.length == 0) {
            return 0;
        }

        for (int i = 0; i < apples.length; i++) {
            int totalApples = apples[i];
            int totalDays = i + days[i];
            System.out.println(totalApples + ", " + totalDays + ", " + n);

            while (n <= totalDays && totalApples != 0) {
                --totalApples;
                ++count;
                n++;
            }
            System.out.println(count);
        }

        return count;
    }
}
