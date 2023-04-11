package a.collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapEx {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(null, "test1");
        map.put(0, "test2");
        System.out.println(map.get(null));
        System.out.println(map.get(0));

        for (Map.Entry<Integer, String> entry : map.entrySet()) {

        }
    }
}
