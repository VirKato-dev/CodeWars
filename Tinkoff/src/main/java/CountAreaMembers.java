import java.util.Arrays;

// package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3

// Дан массив A длины N.
// Окрестностью элемента массива называется непрерывный максимальный
// подмассив, который содержит этот элемент, и при этом все элементы
// этого подмассива имеют одинаковую четность.
// Для каждого элемента A вывести размер его окрестности

// Пример:
// [2, 1, 5, 3, 2] → [1, 3, 3, 3, 1]

public class CountAreaMembers {
    public static void main(String[] args) {
//        int[] array = {2, 1, 5, 3, 2};
        int[] array = {1, 2, 3};
        int[] result = solve2(array);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solve(int[] array) {
        // если значения исходного массива нельзя изменять
        // то создаём новый массив
        int[] result = new int[array.length];
        int p1 = 0;
        int count = 1;

        for (int j = 0; j < array.length; j++) {
            if (array[j] % 2 == 0) {
                if (j == 0 || array[j - 1] % 2 != 0) {
                    p1 = fillArea(result, p1, j - p1, count);
                    count = 1;
                } else {
                    count++;
                }
            } else {
                if (j == 0 || array[j - 1] % 2 == 0) {
                    p1 = fillArea(result, p1, j - p1, count);
                    count = 1;
                } else {
                    count++;
                }
            }
        }
        fillArea(result, p1, result.length - p1, count);

        return result;
    }


    private static int fillArea(int[] res, int pos, int len, int cnt) {
        while (len-- > 0) {
            res[pos++] = cnt;
        }
        return pos;
    }


    // O(n) <- O(2n) <- O(n + m) - разные массивы,
    // но с одинаковым количеством элементов,
    // которое зависит от исходного массива
    // и не изменяется во время исполнения
    private static int[] solve2(int[] array) { // n
        int[] result = new int[array.length]; // m
        int start = 0; // начало окрестности
        int pos = 0; // текущий элемент

        // этот цикл лишь для определения момента завершения
        while (pos < array.length) {
            // O(n) - каждый элемент берём 1 раз
            while (pos < array.length &&
                    array[start] % 2 == array[pos] % 2) {
                // пока текущее число той же чётности,
                // что и в начале окрестности
                pos++;
            }
            // количество элементов окрестности
            // pos указывает на следующую окрестность
            // или за пределы массива
            int count = pos - start;
            // O(m) - каждый элемент изменяем 1 раз
            while (start < pos) {
                // заполняем окрестность
                result[start++] = count;
            }
        }

        return result;
    }
}