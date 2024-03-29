package tasks;

/**
 * Даны три неубывающих массива чисел. Найти число, которое присутствует во всех трех массивах.
 * Input: [1,2,4,5], [3,3,4], [2,3,4,5,6]
 * Output: 4
 * Целевое решение работает за O(p + q + r), где p, q, r – длины массивов,
 * доп. память O(1), но эту информацию интервьюер не сообщает.
 */
public class FindGeneralNumber {

    public static void main(String[] args) {
        System.out.println(findGeneralNumber(
                new int[]{1, 2, 4, 5},
                new int[]{3, 3, 6},
                new int[]{2, 3, 4, 5, 6}
        ));
    }


    private static Integer findGeneralNumber(int[] arr1, int[] arr2, int[] arr3) {
        int p1 = 0, p2 = 0, p3 = 0;

        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {

            if (arr1[p1] == arr2[p2] && arr1[p1] == arr3[p3]) {
                return arr1[p1];
            }

            if (arr1[p1] < arr2[p2] || arr1[p1] < arr3[p3]) {
                p1++;
            }
            if (p1 < arr1.length &&
                    (arr2[p2] < arr1[p1] || arr2[p2] < arr3[p3])) {
                p2++;
            }
            if (p1 < arr1.length && p2 < arr2.length &&
                    (arr3[p3] < arr1[p1] || arr3[p3] < arr2[p2])) {
                p3++;
            }

            if (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
                System.out.println(arr1[p1] + ", " + arr2[p2] + ", " + arr3[p3]);
            } else {
                System.out.println("out of bounds");
            }
        }

        return null;
    }
}
