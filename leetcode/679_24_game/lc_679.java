import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc_679 {
    private static double threshold = 0.000000001;

    public boolean judgePoint24(int[] nums) {
        int[] cross = new int[4];
        ArrayList<Double> stack = new ArrayList<>();
        return backtrack(nums, 0, cross, stack);
    }

    private boolean backtrack(int[] nums, int used, int[] cross, ArrayList<Double> stack) {
        if (used < nums.length) {
            for (int i=0; i<nums.length; i++) {
                if (cross[i] == 1) {
                    continue;
                }
                cross[i] = 1;
                stack.add((double)(nums[i]));
                if (backtrack(nums, used+1, cross, stack)) {
                    return true;
                }
                stack.remove(stack.size()-1);
                cross[i] = 0;
            }
        }
        if (stack.size() == 1) {
            return Math.abs(stack.get(0)-24) <= threshold && used == 4;
        }
        if (stack.size() == 0) {
            return false;
        }
        Double a = stack.remove(stack.size()-1), b = stack.remove(stack.size()-1);

        Double val = a + b;
        stack.add(val);
        if (backtrack(nums, used, cross, stack)) {
            return true;
        }
        stack.remove(stack.size()-1);

        val = a - b;
        stack.add(val);
        if (backtrack(nums, used, cross, stack)) {
            return true;
        }
        stack.remove(stack.size()-1);

        val = a * b;
        stack.add(val);
        if (backtrack(nums, used, cross, stack)) {
            return true;
        }
        stack.remove(stack.size()-1);

        if (b != 0) {
            val = a / b;
            stack.add(val);
            if (backtrack(nums, used, cross, stack)) {
                return true;
            }
            stack.remove(stack.size()-1);
        }
        stack.add(b);
        stack.add(a);
        return false;
    }

    public static void main(String[] args) {
        double a = 8, b = 8, c = 3, d = 3;
        System.out.println(a / (c - b / d));
    }
}
