package tasks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 */
public class ATM {
    private TreeMap<Integer, Integer> banknotes = new TreeMap<>(Collections.reverseOrder());


    public ATM(int... values) {
        for (int value : values) {
            banknotes.merge(value, 1, Integer::sum);
        }
    }


    public void withDraw(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException("Нечего выдавать");
        }
        System.out.println("Выдать: " + amount);

        // снепшот купюр банкомата
        Map<Integer, Integer> snapshot = new HashMap<>(banknotes);

        // набор купюр на выдачу
        Map<Integer, Integer> withdrawal = new HashMap<>();
        for (Integer banknote : banknotes.keySet()) {
            while (amount >= banknote && banknotes.get(banknote) > 0) {
                withdrawal.merge(banknote, 1, Integer::sum);
                banknotes.merge(banknote, -1, Integer::sum);
                amount -= banknote;
            }
        }

        if (amount > 0) {
            System.out.println("Не удаётся выдать ещё: " + amount);
            banknotes = new TreeMap<>(snapshot); // откат
        } else {
            System.out.println("Выдано: " + withdrawal);
        }
    }


    public static void main(String[] args) {
        int[] cash = {50, 100, 500, 1000, 5000, 5000};
        ATM atm = new ATM(cash);
        atm.withDraw(10000);
        atm.withDraw(6000);
        atm.withDraw(50);
    }
}