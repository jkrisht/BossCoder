package random;

public class RegularExpressionMatching10 {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        System.out.println(new RegularExpressionMatching10().isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        if (s == null || s.length() == 0) {
            return false;
        }

        if (s.equals(p)) {
            return true;
        }

        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int sI, int pI) {
        if (sI < s.length() && pI < p.length() && (s.charAt(sI) == p.charAt(pI) || p.charAt(pI) == '.')) {
            return true;
        }

        return isMatch(s, p, sI, pI) && isMatch(s, p, sI + 1, pI + 1);
    }
}
