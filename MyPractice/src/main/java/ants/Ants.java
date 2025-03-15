package ants;

// ___>__<_
// Муравьи стартуют из произвольных точек на отрезке
// При встрече идут в обратном направлении
// Кто первый достигнет края отрезка

// ____><__
// ___<__>_
// __<____>
// _<______
// правый ушёл первым за 4 раунда

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Ants {

    public static void main(String[] args) {
        int result = whoFirst(8, 4, 7);
        System.out.println(abs(result) + " : " + (result < 0 ? "Левый" : "Правый"));

        int result2 = whoFirst2(8, 4, 7);
        System.out.println(abs(result2) + " : " + (result2 < 0 ? "Левый" : "Правый"));
    }

    public static int whoFirst(int length, int first, int second) {
        int round = 0;
        System.out.println("_".repeat(first - 1) + "%" + "_".repeat(second - first) + "&" + "_".repeat(length - second));

        while (first < second - 1) {
            round++;
            if (first < second + 1) {
                first++;
            }
            if (second > first + 1) {
                second--;
            }
            System.out.println("_".repeat(first - 1) + "%" + "_".repeat(second - first) + "&" + "_".repeat(length - second));
        }
        while (first-- > 1 && second++ < length) {
            round++;
            System.out.println("_".repeat(first - 1) + "%" + "_".repeat(second - first) + "&" + "_".repeat(length - second));
        }

        if (first < 1) round *= -1;
        return round;
    }

    public static int whoFirst2(int length, int first, int second) {
        int round = 0;

        int distance = second - first;
        int distanceLeft = first + distance / 2;
        int distanceRight = length - second + distance / 2;

        return min(distanceLeft, distanceRight) * (distanceLeft < distanceRight ? -1 : 1);
    }
}
