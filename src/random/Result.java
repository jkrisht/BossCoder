package random;

public class Result {
    public static void main(String[] args) {
        System.out.println(getFinalString("AAWSWSS"));
    }

    public static String getFinalString(String s) {
        if (s == null || s.isEmpty()) {
            return "-1";
        }

        boolean isContinue = true;

        while (isContinue) {
            if (s.contains("AWS")) {
                s = s.replace("AWS", "");
            } else {
                isContinue = false;
            }
        }

        return s.isEmpty() ? "-1" : s;
    }
}
