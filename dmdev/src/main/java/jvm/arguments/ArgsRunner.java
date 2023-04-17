package jvm.arguments;

import java.util.Arrays;

public class ArgsRunner {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        System.out.println(System.getProperty("author"));
    }
}
