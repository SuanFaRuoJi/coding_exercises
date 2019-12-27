import java.util.ArrayList;

public class wsz_java_224 {
    int cursor = 0;
    String source = null;
    public int calculate(String s) {
        source = s;
        ArrayList<ArrayList<Integer>> memory = new ArrayList<>();
        memory.add(new ArrayList<>());
        ArrayList<Character> ops = new ArrayList<>();
        while(cursor < source.length()) {
            int cur_num = consume_integer();
            if (cur_num == -1) { // operator
                char cur_op = consume_op();
                if (cur_op == '(') {
                    ArrayList<Integer> new_stack = new ArrayList<>();
                    memory.add(new_stack);
                }
                if (cur_op == ')') {
                    ArrayList<Integer> cur_stack = memory.get(memory.size()-1),
                            prev_stack = memory.get(memory.size()-2);
                    prev_stack.add(cur_stack.get(cur_stack.size()-1));
                    memory.remove(memory.size()-1);
                    /*
                    * Use operators is any.
                    * */
                }
                if (cur_op == '+' || cur_op == '-') {
                    ops.add(cur_op);
                }
            } else {
                ArrayList<Integer> cur_stack = memory.get(memory.size()-1);
                cur_stack.add(cur_num);
            }
            ArrayList<Integer> cur_stack = memory.get(memory.size()-1);
            if (cur_stack.size() >= 2) {
                int opreand2 = cur_stack.remove(cur_stack.size()-1),
                        operand1 = cur_stack.remove(cur_stack.size()-1);
                int op = ops.remove(ops.size()-1);
                if (op == '+') {
                    cur_stack.add(operand1 + opreand2);
                }
                if (op == '-') {
                    cur_stack.add(operand1 - opreand2);
                }
            }
        }
        ArrayList<Integer> last_exp = memory.get(memory.size()-1);
        return last_exp.get(last_exp.size()-1);
    }

    private int consume_integer() {
        if (!Character.isDigit(source.charAt(cursor))) {
            return -1;
        }
        int result = 0;
        while (cursor < source.length() && Character.isDigit(source.charAt(cursor))) {
            result = result * 10 + source.charAt(cursor) - '0';
            cursor ++;
        }
        return result;
    }

    private char consume_op() {
        while (cursor < source.length() && source.charAt(cursor)==' ') {
            cursor++;
        }
        if (cursor >= source.length() || Character.isDigit(source.charAt(cursor))) {
            return '\0';
        }
        return source.charAt(cursor++);
    }
}
