import java.util.Stack;

public class jcy_lc716 {
    Stack<Integer> stack, maxStack;

    public jcy_lc716() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        int max = maxStack.empty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> helper = new Stack<>();
        while (stack.peek() != max) helper.push(pop());
        pop();
        while (!helper.empty()) push(helper.pop());
        return max;
    }
}