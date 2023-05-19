package codewars.directions.reduction.v2;

import java.util.Stack;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        Stack<String> result = new Stack<String>();
        for (String s : arr) {
            if (!result.isEmpty()
                    && ((result.peek().equals("NORTH") && s.equals("SOUTH"))
                    || (result.peek().equals("SOUTH") && s.equals("NORTH"))
                    || (result.peek().equals("EAST") && s.equals("WEST"))
                    || (result.peek().equals("WEST") && s.equals("EAST")))) {
                result.pop();
            } else {
                result.push(s);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}