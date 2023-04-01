package codewars.binary.multiple.of.three;

import java.util.regex.Pattern;


public class BinaryRegexp {

    public static void main(String[] args) {
        System.out.println(multipleOf3().matcher("000").matches());
        System.out.println(multipleOf3().matcher("110").matches());
        System.out.println(multipleOf3().matcher("1001").matches());
        System.out.println(multipleOf3().matcher("10101").matches());
        System.out.println(Integer.toBinaryString(12345678) + " == " + multipleOf3().matcher(Integer.toBinaryString(12345678)).matches());
        System.out.println("----");
        System.out.println(multipleOf3().matcher(" 0").matches());
        System.out.println(multipleOf3().matcher("abc").matches());
        System.out.println(multipleOf3().matcher("111").matches());
    }

    /**
     * Let's start off by designing a DFA (Deterministic Finite Automaton) representing this problem.
     * <p />
     * Since (at least) every positive integer <code>i</code> may be written as <code>i = 3 * n + r</code> where <code>r</code> is the remainder,
     * we can design a DFA with three states - one for each possible remainder (0, 1, 2).
     * If the remainder is 0, the integer is divisible by 3.
     * So our DFA found a valid input, if it stops in the state for remainder 0.
     * This is also the state we start in.
     * <p />
     * Btw. this is not only works for 3 - we just have to choose our remainder states accordingly.
     * <p />
     * We assume that the leftmost character in our input represents the highest bit.
     * <p />
     * Our DFA may have the following transitions (Read <code>r0 -1-> r1</code> as <code>If we are in state r0 and read a 0, we go to state r1</code>):<br />
     * r0 -0-> r0<br />
     * r0 -1-> r1<br />
     * r1 -0-> r2<br />
     * r1 -1-> r0<br />
     * r2 -0-> r1<br />
     * r2 -1-> r2<br />
     * So we only need to know the current remainder and the next place.
     * <p />
     * Why is it?
     * <p />
     * We can calculate the remainder of a binary number as the remainder of the sum of each binary place modulo 3.<br />
     * Example (1001%3):<br />
     * ((1*2^3)%3 + (0*2^2)%3 + (0*2^1)%3 + (1*2^0)%3)%3 = (2 + 0 + 0 + 1) % 3 = 0
     * <p />
     * There a several techniques to convert a DFA to a regex, but I won't go into detail here.
     */
    public static Pattern multipleOf3() {
        // Regular expression that matches binary inputs that are multiple of 3
        return Pattern.compile("(1(01*0)*1|0)+");
    }

}
