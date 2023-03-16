package codewars.ones.and.zeros.v1;

import java.util.List;

public class BinaryArrayToNumber {
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        StringBuilder numS = new StringBuilder();
        for (int num : binary) numS.append(num);
        return Integer.parseInt((numS.toString()), 2);
    }
}