package curriculum.C28;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public static void main(String[] args) {
        String num = "3456237490";
        int target = 9191;
        // System.out.println(new ExpressionAddOperators().addOperators1(num, target));
        System.out.println(new ExpressionAddOperators().addOperators(num, target));
        System.out.println(new ExpressionAddOperators().addOperators2(num, target));
    }

    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) {
            return List.of();
        }
        List<String> result = new ArrayList<>();
        addOperators(num, target, result, "", 0, 0, 0);
        return result;
    }

    private void addOperators(String num, int target, List<String> result, String expression, long eval, int position, long prevMul) {
        if (position == num.length()) {
            if (target == eval) {
                result.add(expression);
            }
            return;
        }

        for (int i = position; i < num.length(); i++) {
            if (i != position && num.charAt(position) == '0') break;
            long current = Long.parseLong(num.substring(position, i + 1));

            if (position == 0) {
                addOperators(num, target, result, expression + current, current, i + 1, current);
            } else {
                addOperators(num, target, result, expression + "+" + current, eval + current, i + 1, current);
                addOperators(num, target, result, expression + "-" + current, eval - current, i + 1, -current);
                addOperators(num, target, result, expression + "*" + current, eval - prevMul + prevMul * current, i + 1, prevMul * current);
            }
        }
    }

    public List<String> addOperators2(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if (num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }

    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval)
                rst.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

                helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }

    public List<String> addOperators1(String num, int target) {
        if (num == null || num.length() == 0) {
            return List.of();
        }

        List<String> result = new ArrayList<>();

        int sum = 0, sub = 0, mul = 1, div = 1;
        StringBuilder sumExp = new StringBuilder();
        StringBuilder subExp = new StringBuilder();
        StringBuilder mulExp = new StringBuilder();
        StringBuilder divExp = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {
            int num1 = Integer.parseInt("" + num.charAt(i));
            sum += num1;
            sumExp.append(num1).append("+");

            sub -= num1;
            subExp.append(num1).append("-");

            mul *= num1;
            mulExp.append(num1).append("*");

            div /= num1;
            divExp.append(num1).append("/");
        }

        if (sum == target) {
            result.add(sumExp.substring(0, sumExp.length() - 1));
        }

        if (sub == target) {
            result.add(subExp.substring(0, subExp.length() - 1));
        }

        if (mul == target) {
            result.add(mulExp.substring(0, mulExp.length() - 1));
        }
        System.out.println(mul);

        if (div == target) {
            result.add(divExp.substring(0, divExp.length() - 1));
        }

        return result;
    }
}
