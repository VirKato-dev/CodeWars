package tasks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;


public class Brackets {
    public static void main(String[] args) {
        System.out.println(check("[()]"));
    }


    private static boolean check(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                deque.addFirst(ch);
            } else {
                if (!deque.isEmpty() &&
                        ((deque.peekFirst() == '{' && ch == '}') ||
                         (deque.peekFirst() == '[' && ch == ']') ||
                         (deque.peekFirst() == '(' && ch == ')'))) {
                    deque.removeFirst();
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    static boolean check2(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}