package tasks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Существует справка прописки и выбытия по месту жительства.
 * Справка состоит из полей (documentId, personId, addressId, type).
 * Справка прописки имеет тип 3, справка выбытия имеет тип 11.
 * Справка выбытия отменяет справку прибытия, если personId и addressId совпадают.
 * На вход метода передаётся список справок и список documentId для фильтрации входных данных.
 * Пример входных данных.
 * Справки: [{1,1,1,3}, {2,1,1,11}, {3,1,2,3}, {4,2,1,3}, {5,3,1,3}]
 * Фильтр: [1,2,3,5]
 * Результат: [{3,1,2,3}, {5,3,1,3}]
 */
public class SpravkaTask {
    public static void main(String[] args) {
        List<Spravka> l = List.of(
                new Spravka(1, 1, 1, 3),
                new Spravka(2, 1, 1, 11),
                new Spravka(3, 1, 2, 3),
                new Spravka(4, 2, 1, 3),
                new Spravka(5, 3, 1, 3)
        );
        System.out.println(method(l, List.of(1L, 2L, 3L, 5L)));
    }

    private static List<Spravka> method(List<Spravka> list, List<Long> filter) {
        Map<String, Spravka> result = new HashMap<>();
        for (Spravka spravka : list) {
            if (filter.contains(spravka.dId)) {
                String key = spravka.pId + "_" + spravka.aId;
                switch (spravka.t) {
                    case 3: { // add
                        result.put(key, spravka);
                        break;
                    }
                    case 11: { // remove
                        result.remove(key);
                        break;
                    }
                    default: { // nothing
                    }
                }
            }
        }
        return result.values().stream().toList();
    }
}


class Spravka {
    public long dId;
    public long pId;
    public long aId;
    public int t;

    public Spravka(long documentId, long personId, long addressId, int type) {
        dId = documentId;
        pId = personId;
        aId = addressId;
        t = type;
    }

    @Override
    public String toString() {
        return "{" + dId + ", " + pId + ", " + aId + ", " + t + "}";
    }
}
