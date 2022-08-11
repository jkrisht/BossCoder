package random;

import java.util.ArrayList;
import java.util.List;

public class Result1 {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("ACB");
        strs.add("BDC");
        strs.add("CED");
        strs.add("DEF");
        System.out.println(findOdd(strs));
    }

    public static String findOdd(List<String> series) {
        if (series == null || series.size() == 0) {
            return "";
        }

        if (series.size() == 1) {
            return series.get(0);
        }

        List<List<Integer>> calculations = new ArrayList<>();
        String oddString = "";

        for (String s : series) {
            List<Integer> diff = new ArrayList<>();
            char[] chs = s.toCharArray();

            for (int i = 1; i < chs.length; i++) {
                int difference = chs[i] - chs[i - 1];
                diff.add(difference);
            }

            if (calculations.size() == 0) {
                calculations.add(diff);
            } else {
                List<Integer> list = calculations.get(calculations.size() - 1);
                for (int i = 0; i < diff.size(); i++) {
                    if (list.get(i) != diff.get(i)) {
                        oddString = s;
                    }
                }
            }
        }

        return oddString;
    }
}
