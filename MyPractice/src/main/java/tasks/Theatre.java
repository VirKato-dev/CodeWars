package tasks;

import java.util.Arrays;

/**
 * <p>Программист решил пойти в театр. Но он хочет сесть как можно дальше от других людей, чтобы не заразиться covid.
 * Поэтому он хочет написать функцию, которая найдёт максимальное расстояние, на которое можно сесть от других зрителей в одном ряду.</p>
 * Дан массив из 0 и 1 описывающий посадку зрителей в ряду.<br>
 * 0 - место свободно, 1 - место занято другим зрителем.<br>
 * Вывести максимальное расстояние, на котором можно сесть от других зрителей.<br>
 * Гарантируется, что есть 0 и 1.<br>
 * Пример: [1,0,0,0,1] -> 2
 */
public class Theatre {
    public static void main(String[] args) {
        System.out.println("5 = " + findSeat(new int[]{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}));
        System.out.println("5 = " + findSeat(new int[]{0, 0, 0, 0, 0, 1, 0, 0, 0, 0}));
        System.out.println("2 = " + findSeat(new int[]{1, 0, 0, 0, 0, 1}));
        System.out.println("2 = " + findSeat(new int[]{1, 0, 0, 0, 1, 0}));
        System.out.println("3 = " + findSeat(new int[]{0, 0, 0, 1, 0, 0, 0, 0, 1}));
        System.out.println("3 = " + findSeat(new int[]{1, 0, 0, 1, 0, 0, 0, 0, 1}));
    }

    /**
     * Случаи при выборе места
     * 1 - 001 - выбрать крайнее левое
     * 2 - 100 - выбрать крайнее правое
     * 3 - 101 - выбрать среднее
     */

    private static int findSeat(int[] arr) {
        System.out.print(Arrays.toString(arr) + "\t\t");
        int begin = 0;  // начало свободного участка
//        int end = 0;    // конец свободного участка
        int seat = 0;   // позиция для посадки
        int len = 0;    // максимально возможное удаление от зрителя
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0 || (arr[j] ==0 && j == arr.length - 1)) {
                int tmp = j - begin;
                if ((begin == 0 && arr[begin] == 0) || (arr[j] == 0 && j == arr.length - 1)) { // для крайних
                    if (tmp > len) {
                        len = tmp;
                        seat = begin == 0 ? 0 : j;
                    }
                } else {                                 // для средних
                    tmp = tmp / 2 + (tmp % 2 == 0 ? 0 : 0);
                    if (tmp > len) {
                        len = tmp;
                        seat = begin + tmp;
                    }
                }
                begin = j;
            }
        }
        return len;
    }


    private static int findSeatWrong(int[] arr) {
        int count = 0; // длина обрабатываемого участка ряда
        int max = 0; // максимальная длина участка ряда
        boolean edge = true; // участок ряда находится на краю ряда

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) { // свободный участок ряда начался/продолжается
                count++;
                if (count > max) { // при каждом нахождении свободного места
                    max = count;   // если текущий участок длиннее предыдущего
                    // крайность определяется только для самого длинного участка
                    edge = j == 0 || j == arr.length - 1;
                }
            } else { // свободный участок ряда закончился
                count = 0;
            }
        }

        if (edge) { // для крайних берём всю длину
            return max;
        } else { // для средних участков вычисляем середину между зрителями
            return max / 2 + (max % 2 == 0 ? 0 : 1);
        }
        //  return max / (edge ? 1 : 2) + (max % 2 == 0 || edge ? 0 : 1);
    }
}
