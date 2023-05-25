package tasks;

import java.util.Stack;

// Дана неправильная скобочная последовательность из открывающих и закрывающих скобок.
// Нужно выяснить, можно ли заменить одну из открывающих скобок на закрывающую
//  или наоборот так, чтобы получилась правильная скобочная последовательность.
// Если можно, то вывести индекс скобки, которую надо заменить.
// Если нельзя, то вывести -1.
// ()(( => 3
public class FindBracketToReplace {

    public static void main(String[] args) {
        System.out.println(findBracketToReplace("))")); // 0 - ожидалось 0
        System.out.println(findBracketToReplace("((")); // 1 - ожидалось 1
        System.out.println(findBracketToReplace(")(")); // -1 - ожидалось -1
        System.out.println(findBracketToReplace(")")); // -1 - ожидалось -1
        System.out.println(findBracketToReplace("((((")); // -1 - ожидалось -1
        System.out.println(findBracketToReplace("))))")); // -1 - ожидалось -1
        System.out.println(findBracketToReplace("))()")); // 0 - ожидалось 0
    }


    public static int findBracketToReplace2(String s) {
        Stack<Integer> stack = new Stack<>();
        int wrong = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    wrong = wrong < 0 ? i : wrong;
                }
            }
        }
        if (s.length() % 2 != 0) {
            System.out.println("Лишняя скобка для " + s);
            return -1;
        } else if (wrong >= 0) {
            if (stack.isEmpty()) {
                System.out.println("Ожидается открывающая для " + s);
                return wrong;
            } else {
                System.out.println("Больше одной замены для " + s);
                return -1;
            }
        } else if (stack.size() > 0 && stack.size() < 3) {
            int ri = stack.pop();
            if (ri == 0 || s.charAt(ri) == '(') {
                System.out.println("Ожидается закрывающая для " + s);
                return ri;
            }
        } else {
            System.out.println("Не требуется замен для " + s);
        }
        return -1;
    }


    public static int findBracketToReplace(String s) {
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        boolean hasOpen = false;
        int wrong = -1;

        if (len % 2 != 0) return wrong; // odd

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                hasOpen = true;
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) { // first missed (
                    wrong = wrong < 0 ? i : wrong;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            if (wrong >= 0 || stack.size() > 2) {
                wrong = -1; // many
            } else {
                wrong = stack.pop(); // replace to )
            }
        } else {
            if (!hasOpen && len > 2) wrong = -1; // has ) only
        }
        return wrong; // replace to ( or -1
    }

}




















