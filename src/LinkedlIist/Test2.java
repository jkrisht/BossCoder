package LinkedlIist;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        String s = "is2 Thi1s T4est a3";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Integer, String> words = new HashMap<>();
        String[] wordsArr = s.split(" ");

        for (String word : wordsArr) {
            char[] chs = word.toCharArray();
            int index = Integer.MIN_VALUE;
            for (char ch : chs) {
                if (Character.isDigit(ch)) {
                    index = ch - '0';
                    break;
                }
            }

            words.putIfAbsent(index, word.replaceAll("\\d", ""));
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= 9; i++) {
            if (words.containsKey(i)) {
                builder.append(words.get(i) + " ");
            }
        }

        return builder.toString().trim();
    }
}
