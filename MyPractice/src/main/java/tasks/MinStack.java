package tasks;

import java.util.LinkedList;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("" + minStack.getMin());
        minStack.pop();
        System.out.println("" + minStack.getMin());
    }

    private final LinkedList<Integer> min = new LinkedList<>();

    private final LinkedList<Integer> stack = new LinkedList<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.addLast(val);
        if (min.isEmpty()) {
            min.addLast(stack.size() - 1);
        } else {
            if (val < stack.get(min.getLast())) {
                min.addLast(stack.size() - 1);
            }
        }
        System.out.println("STACK: " + stack);
        System.out.println("MIN: " + min);
    }


    public Integer pop() {
        if (!min.isEmpty() && stack.size() - 1 < min.getLast()) {
            min.removeLast();
        }
        return stack.isEmpty() ? null : stack.removeLast();
    }


    public Integer getMin() {
        return min.isEmpty() ? null : stack.get(min.getLast());
    }
}
