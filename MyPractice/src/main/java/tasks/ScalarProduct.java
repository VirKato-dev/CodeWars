package tasks;

import java.util.LinkedList;

// (1,1,2): A = [(2,1),(1,2)] - упакованный вектор
// (3,2,2): B = [(1,3),(2,2)] - упакованный вектор
// scalar product = 1*3 + 1*2 + 2*2 = 9
// (2*1) + (1*3) + (1*2) + (2*2)
public class ScalarProduct {
    public static void main(String[] args) {
        System.out.println(scalarProduct(
                new int[][]{{1, 1}, {1, 1}, {1, 2}},
                new int[][]{{1, 3}, {2, 2}}
        ));
    }

    private static int scalarProduct(int[][] vectorOne, int[][] vectorTwo) {
        int scalarProduct = 0;
        LinkedList<Integer> numsA = new LinkedList<>();
        numsA.add(0);
        LinkedList<Integer> numsB = new LinkedList<>();
        numsB.add(0);
        int pair = 0;
        do {
            // распаковка очередного элемента упакованного вектора
            // минимум одно число добавится в распакованные векторы
            if (pair < vectorOne.length) {
                scalarProduct += vectorOne[pair][0] * vectorOne[pair][1];
                for (int j = 0; j < vectorOne[pair][0]; j++)
                    numsA.add(vectorOne[pair][1]);
            }
            if (pair < vectorTwo.length) {
                scalarProduct += vectorTwo[pair][0] * vectorTwo[pair][1];
                for (int j = 0; j < vectorTwo[pair][0]; j++)
                    numsB.add(vectorTwo[pair][1]);
            }
            pair++;
            // произведение очередной пары чисел numsA и numsB
            scalarProduct += numsA.removeFirst() * numsB.removeFirst();
        } while (!numsA.isEmpty() && !numsB.isEmpty());
        if (numsA.size() + numsB.size() > 0)
            throw new IllegalArgumentException("Распакованные векторы имеют разную длину");
        return scalarProduct;
    }

//    private static int scalarProduct2(int[][] vectorOne, int[][] vectorTwo) {
//        int scalarProduct = 0;
//        int pair = 0;
//        List<Integer> numsA = new ArrayList<>();
//        List<Integer> numsB = new ArrayList<>();
//        while (pair < vectorOne.length || pair < vectorTwo.length) {
//            if (pair < vectorOne.length) {
//                scalarProduct += vectorOne[pair][0] * vectorOne[pair][1];
//                for (int j = 0; j < vectorOne[pair][0]; j++) numsA.add(vectorOne[pair][1]);
//            }
//            if (pair < vectorTwo.length) {
//                scalarProduct += vectorTwo[pair][0] * vectorTwo[pair][1];
//                for (int j = 0; j < vectorTwo[pair][0]; j++) numsB.add(vectorTwo[pair][1]);
//            }
//            pair++;
//        }
//        for (int j = 0; j < numsA.size(); j++) {
//            scalarProduct += numsA.get(j) * numsB.get(j);
//        }
//        return scalarProduct;
//    }
}
