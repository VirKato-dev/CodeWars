package javarush;

import java.util.Scanner;


public class SecondMin2 {
    public static void main(String[] args) {
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int value;
        Scanner scan = new Scanner("8 4 7 4 5 9 5 e");
        while (scan.hasNextInt()) {
            value = scan.nextInt();
            if (value < min) {
                min2 = min;
                min = value;
            }
            if (value > min && value < min2) {
                min2 = value;
            }
        }
        System.out.println(min2);
    }
}
