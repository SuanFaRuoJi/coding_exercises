import java.util.List;
import java.util.Stack;

public class jcy_lc636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] content = log.split(":");
            int id = Integer.parseInt(content[0]);
            String action = content[1];
            int currTime = Integer.parseInt(content[2]);
            if (action.equals("start")) {
                if (!stack.empty())
                    res[stack.peek()] += currTime - prevTime;
                stack.push(id);
                prevTime = currTime;
            } else {
                res[stack.pop()] += currTime - prevTime + 1;
                prevTime = currTime + 1;
            }
        }
        return res;
    }
}