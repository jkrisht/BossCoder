package LinkedlIist;

public class Test1 {
    public static void main(String[] args) {
        // lower case and 9 characters
        // split into 3 parts of each 3 chars
        // first and 3r letter should be converted to corresponding number
        // reverese second part
        // replace next charater of 7 8 and 9
        // part3 + part1 + part2

        // moirarose
        // ptf13o9rar

        System.out.println((int) 'z');

        String message = "moirarose";

        System.out.println(solution(message));
    }

    public static String solution(String message) {
        if (message == null || message.length() == 0 || message.length() > 9) {
            return "invalid";
        }

        String[] parts = new String[3];
        int start = 0, end = 3;

        for (int i = 0; i < 3; i++) {
            parts[i] = message.substring(start, end);
            start = end;
            end = end + 3;
        }

        int aValue = 97;
        String part1 = parts[0];
        int first = part1.charAt(0) - aValue + 1;
        int third = part1.charAt(2) - aValue + 1;
        part1 = String.valueOf(first) + part1.charAt(1) + third;

        StringBuilder builder = new StringBuilder(parts[1]);
        builder.reverse();
        String part2 = builder.toString();

        String part3 = parts[2];
        int part3First = part3.charAt(0) + 1;
        int part3Second = part3.charAt(1) + 1;
        int part3Third = part3.charAt(2) + 1;
        StringBuilder lastBuilder = new StringBuilder();
        lastBuilder.append((char) part3First);
        lastBuilder.append((char) part3Second);
        lastBuilder.append((char) part3Third);
        part3 = lastBuilder.toString();

        return part3 + part1 + part2;
    }
}
