package tasks;

/**
 * Проверить возможность получения указанного числа из суммы чисел массива (без повторений)
 */
public class CheckComposite {
    public static void main(String[] args) {
        int[] nums = {1, 9, 7};
        System.out.println(summa(nums,1));
        System.out.println(summa(nums,5));
        System.out.println(summa(nums,16));
    }

    private static boolean checkComposite(int[] n, int c) {
        for (int i : n) if (i == c) return true;
        if (n[0] + n[1] == c || n[0] + n[2] == c || n[1] + n[2] == c) return true;
        return n[0] + n[1] + n[2] == c;
    }

    private static boolean summa(int[] array, int x) {
        int sum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                sum = array[i] + array[j];
                int temp = j + 1;
                while ((sum < x) && (temp < array.length)) {
                    sum += array[temp++];
                }
                if (sum == x) {
                    return true;
                }
            }
        }
        return false;
    }
}
