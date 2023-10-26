package tasks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Группа уличных художников «Цветы жизни» создаёт масштабные картины, высаживая несколько видов растений на улицах города. Во время их цветения группа снимает результат с высоты птичьего полета и выкладывает полученные фотографии в сеть.
 * Свою новую работу художники задумали такой, чтобы её можно было наблюдать с воздуха в любое время года. Картина в течение года будет меняться, так как в зависимости от сезона цветут разные растения.
 * Специально под эту задачу художники подобрали k видов растений. Для каждого из видов растений они определили период начала цветения (start_i, end_i) и его продолжительность flowering−period_i. i-е растение может начать цвести равновероятно в любой из дней в промежутке от
 * start_i до end_i включительно, а flowering−period_i указывает на то, сколько дней после начала цветёт этот вид растения.
 * Главное — картина должна цвести круглый год. В году ровно t дней. На основе данных о выведенных растениях определите, получится ли у художников осуществить задуманное.
 *
 * Формат ввода
 * В первой строке находятся два целых числа k, t (1 ≤ k ≤ 2 ∗ 10^5, 1 ≤ t ≤ 10^18). В следующих k строках содержатся по 3 числа,
 * i-я строка содержит данные об i-м растении:
 * start_i, end_i, flowering−period_i (1 ≤ start_i, end_i, flowering−period_i ≤ t)
 * Формат вывода
 * В единственной строке выведите "Yes" если задумка художников реализуема, и "No" в противном случае.
 */
public class FlowerPicture {

    public static void main(String[] args) {
        System.out.println(can("""
                5 10
                4 6 7
                2 3 3
                1 1 4
                2 3 1
                2 4 5""")
        );
        System.out.println(can("""
                3 10
                1 5 10
                2 3 4
                2 6 5""")
        );
    }

    private static String can(String input) {
        Scanner in = new Scanner(input);
        int num = in.nextInt();
        int days = in.nextInt();
        boolean[] yes1 = new boolean[days];
        boolean[] yes2 = new boolean[days];
        while (num > 0) {
            int start = in.nextInt();
            int stop = in.nextInt();
            int period = in.nextInt();
            int a1 = period;
            int a2 = period;
            for (int j = stop - 1; j < days; j++, a1--) if (a1 > 0) yes1[j] = true;
            for (int j = start - 1; j < days; j++, a2--) if (a2 > 0) yes2[j] = true;
            num--;
        }
        System.out.println(Arrays.toString(yes1));
        System.out.println(Arrays.toString(yes2));
        for (boolean y : yes1) if (!y) return "No";
        for (boolean y : yes2) if (!y) return "No";
        return "Yes";
    }
}
