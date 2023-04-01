package a.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListName {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Иван", "Стас"));

        names.removeIf(str -> !str.startsWith("И"));

//        names = names.stream().filter(s -> s.startsWith("И")).toList();

//        for (int j = names.size() - 1; j >= 0; j--) {
//            if (!names.get(j).startsWith("И")) names.remove(j);
//        }

//        Iterator<String> iterator = names.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next().startsWith("И")) {
//                iterator.remove();
//            }
//        }
        System.out.println(names);
    }
}
