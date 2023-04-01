package a.streams.unique.elements;

import java.util.*;
import java.util.stream.Collectors;


public class UniqueElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 3, 5, 2};
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .distinct()
                .toList();
        System.out.println(list);
    }
}
