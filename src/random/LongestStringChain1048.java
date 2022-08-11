package random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain1048 {
    public static void main(String[] args) {
        String[] words = {"abcd", "abcd", "dbqca"};
        // Total Time Complexity: O(nlogn) + n * l * l
        System.out.println(new LongestStringChain1048().longestStrChain(words));
    }

    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        // Time Complexity: O(n*logn)
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> memo = new HashMap<>();
        int count = 0;

        // Time Complexity: O(N)
        for (String word : words) {
            memo.put(word, 1);
            // Time Complexity: O(len(s))
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                // Time Complexity: O(len(s))
                String newString = builder.deleteCharAt(i).toString();
                memo.put(word, Math.max(memo.get(word), memo.getOrDefault(newString, 0) + 1));
            }
            count = Math.max(count, memo.get(word));
        }

        return count;
    }
}
