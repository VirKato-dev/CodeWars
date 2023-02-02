package com.codewars.directions.reduction.v1;

import java.util.Stack;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        Stack<String> stack = new Stack<>();
        for (String dir : arr) {
            String last = stack.size() > 0 ? stack.lastElement() : null;
            switch (dir) {
                case "NORTH" -> {
                    if (last == "SOUTH") {
                        stack.pop();
                    } else {
                        stack.push(dir);
                    }
                }
                case "SOUTH" -> {
                    if (last == "NORTH") {
                        stack.pop();
                    } else {
                        stack.push(dir);
                    }
                }
                case "EAST" -> {
                    if (last == "WEST") {
                        stack.pop();
                    } else {
                        stack.push(dir);
                    }
                }
                case "WEST" -> {
                    if (last == "EAST") {
                        stack.pop();
                    } else {
                        stack.push(dir);
                    }
                }
            }
        }
        return stack.toArray(String[]::new);
    }
}