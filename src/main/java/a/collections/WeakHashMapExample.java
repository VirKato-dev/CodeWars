package a.collections;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapExample {
    public static void main(String[] args) throws InterruptedException {
        String text1 = new String("text1"); // нужно значение не из пула
        WeakHashMap<String, String> whm = new WeakHashMap<>();
        whm.put(text1, "доп инфо для text1");
        HashMap<String, String> map = new HashMap<>();
        map.put(text1, "доп инфо для text1");
        text1 = null;
        int count = 0;
        int size;
        do {
            count++;
            Thread.sleep(200);
            if (count > 5) {
                map = null; // теперь test1 не содержится в map и нигде больше
            }
            System.gc();
            // с этого момента размер массива может внезапно уменьшиться из-за удаления элемента Сборщиком Мусора
            size = whm.size();
            System.out.println(size + " -- " + count);
        } while (size > 0);
    }
}
