package a.algo.bigo;

import java.util.List;

public class Onm {
    public static void main(String[] args) {
        inspect(List.of("мама", "папа", "дочь", "сын"));
    }

    /**
     * O(n*m)
     * циклы вложенные - показателя умножаются
     * наборы данных разные - именя показателей разные
     * время работы циклов зависит от размера входных данных - сложность оценивается
     * @param list
     */
    private static void inspect(List<String> list) {
        for (int j = 0; j < list.size(); j++) {
            for (int k = 0; k < list.get(j).length(); k++) {
                System.out.print(list.get(j));
            }
            System.out.println();
        }
    }
}
