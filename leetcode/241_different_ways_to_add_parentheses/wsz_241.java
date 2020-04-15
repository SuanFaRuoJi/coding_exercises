import java.util.ArrayList;
import java.util.List;

public class wsz_241 {
    public List<Integer> diffWaysToCompute(String input) {
       int i = 0, operand = 0;
       List<Integer> operands = new ArrayList<>();
       List<Character> operators = new ArrayList<>();
       while (i < input.length() && Character.isDigit(input.charAt(i))) {
           operand = operand * 10 + (input.charAt(i) - '0');
           i++;
       }
       operands.add(operand);
       while (i < input.length()) {
           while (i < input.length() && input.charAt(i) == ' ') {
               i ++;
           }
           operators.add(input.charAt(i));
           i ++;
           operand = 0;
           while (i < input.length() && Character.isDigit(input.charAt(i))) {
               operand = operand * 10 + (input.charAt(i) - '0');
               i++;
           }
           operands.add(operand);
       }
       List<Integer>[][] dp = new List[operands.size()][operands.size()];
       for (Integer cur : operands) {
           System.out.println(cur);
       }
       for (Character cur : operators) {
           System.out.println(cur);
       }
       return search(operands, operators, 0, operands.size()-1, dp);
    }

    private List<Integer> search(List<Integer> operands, List<Character> operators, int l, int r, List<Integer>[][] dp) {
        if (dp[l][r] != null) {
            return dp[l][r];
        }
        if (l == r) { // only a number
            List<Integer> result = new ArrayList<>();
            result.add(operands.get(l));
            return result;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = l; i < r; i++) {
            List<Integer> left = search(operands, operators, l, i, dp);
            List<Integer> right = search(operands, operators, i + 1, r, dp);
            char operator = operators.get(i);
            for (int cur_left : left) {
                for (int cur_right : right) {
                    if (operator == '+') {
                        result.add(cur_left + cur_right);
                        continue;
                    }
                    if (operator == '-') {
                        result.add(cur_left - cur_right);
                        continue;
                    }
                    if (operator == '*') {
                        result.add(cur_left * cur_right);
                        continue;
                    }
                    if (operator == '/') {
                        result.add(cur_left / cur_right);
                        continue;
                    }
                }
            }
        }
        dp[l][r] = result;
        return result;
    }
}
