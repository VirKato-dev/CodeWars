import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class Problem20ValidParentheses {
    public static void main(String[] args) {
        SolutionBest solution = new SolutionBest();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
    }

    static class Solution {
        public boolean isValid(String s) {
            if (s == null || s.isEmpty()) return true;
            LinkedList<String> stack = new LinkedList<>();
            for (int j = 0; j < s.length(); j++) {
                String c = Character.toString(s.charAt(j));
                if ("([{".contains(c)) {
                    stack.add(c);
                } else if (")]}".contains(c)) {
                    if (stack.isEmpty()) return false;
                    String r = stack.removeLast();
                    if (r == null || "([{".indexOf(r) != ")]}".indexOf(c)) return false;
                }
            }
            return stack.isEmpty();
        }
    }

    static class SolutionBest {
        public boolean isValid(String s) {
            if (s == null || s.length() % 2 != 0) { //checking if null or odd
                return false;
            }
            char[] stack = new char[s.length()]; //created a char implementation of a stack instead of creating a ''Stack<> st' data structure.
            //accessing an element in an array takes constant time (O(1)), whereas accessing an element in a Stack takes linear time i.e. O(n)


            int top = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);  // using the charAt() method instead of converting the whole string array to char at once using .toCharArray method. It saves space (and time).
                if (c == '(' || c == '[' || c == '{') {
                    stack[top++] = c; //adding the brackets to 'top' index. (index 0 here, and then it increments top immediately after.)
                } else if (top == 0
                        || c == ')' && stack[top - 1] != '('
                        || c == ']' && stack[top - 1] != '['
                        || c == '}' && stack[top - 1] != '{') {
                    return false;
                } else {
                    top--;
                }
            }
            return top == 0;
        }
    }


    static class SolutionGood {
        public static boolean isValid(String s) {
            if (s.length() % 2 != 0) {
                return false;
            }
            ArrayDeque<Character> deque = new ArrayDeque<>();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                switch (c) {
                    case '{':
                        deque.add('}');
                        break;
                    case '(':
                        deque.add(')');
                        break;
                    case '[':
                        deque.add(']');
                        break;
                    default:
                        if (deque.isEmpty() || deque.peekLast() != c) {
                            return false;
                        }
                        deque.removeLast();
                }
            }
            return deque.isEmpty();
        }
    }
}
