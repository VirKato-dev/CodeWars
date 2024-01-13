package nolimit.task1;

import java.util.Scanner;

/**
 * Костя подключен к мобильному оператору «Мобайл».
 * Абонентская плата Кости составляет A рублей в месяц.
 * За эту стоимость Костя получает B мегабайт интернет-трафика.
 * Если Костя выйдет за лимит трафика, то каждый следующий мегабайт будет стоить ему C рублей.
 * <p>
 * Костя планирует потратить D мегабайт интернет-трафика в следующий месяц.
 * Помогите ему сосчитать, во сколько рублей ему обойдется интернет.
 */
public class Solution {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner("100  10  12  15");
//        Scanner in = new Scanner("100  10  12  1");

        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int D = in.nextInt();

        int over = D - B;
        over = over > 0 ? over * C : 0;
        System.out.println(A + over);

    }
}
