package codewars.find.the.parity.outlier;

import java.util.Arrays;

public class FindTheParityOutlier {
    public static void main(String[] args) {
        int[] exampleTest1 = {2, 6, 8, -10, 3};
        int[] exampleTest2 = {206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781};
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
        System.out.println(3 == FindOutlier.find(exampleTest1));
        System.out.println(206847684 == FindOutlier.find(exampleTest2));
        System.out.println(0 == FindOutlier.find(exampleTest3));
        System.out.println(11 == FindOutlier.find(new int[]{2, 4, 0, 100, 4, 11, 2602, 36}));
        System.out.println(160 == FindOutlier.find(new int[]{160, 3, 1719, 19, 11, 13, -21}));
    }
}

class FindOutlier {
    static int find(int[] integers) {
        int state = 0;
        for (int j = 0; j < 3; j++) state += integers[j] % 2 == 0 ? 1 : -1;
        for (int num : integers) {
            if (state > 0 && num % 2 != 0) return num;
            if (state < 0 && num % 2 == 0) return num;
        }
        return -1;
    }

    static int find2(int[] integers) {
        int[] array = Arrays.stream(integers).filter(i -> i % 2 == 0).toArray();
        return array.length == 1
                ? array[0]
                : Arrays.stream(integers).filter(i -> i % 2 != 0).findAny().getAsInt();
    }

    static int find3(int[] integers) {
        int[] evens = Arrays.stream(integers).filter(i -> i % 2 == 0).toArray();
        int[] odds = Arrays.stream(integers).filter(i -> i % 2 != 0).toArray();
        return (evens.length == 1) ? evens[0] : odds[0];
    }
}