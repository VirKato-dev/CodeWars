package a.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;


public class CollectionsExample {

    static class A {
        public String v = "A"; // статическое связывание

        public String t() { // динамическое связывание
            return "A";
        }
    }

    static class B extends A {
        public String v = "B";

        public String t() {
            return "B";
        }
    }

    static class C extends B {
        public String v = "C";

        public String t() {
            return "C";
        }
    }

    // PECS
    public static void main(String[] args) {
        // Consumer - super
        List<? super B> l1 = new ArrayList<>();
        l1.add(new C()); // можно добавлять B и его потомков
        Object b = l1.get(0); // возвращаемый тип не младше Object
        List<C> l2 = new ArrayList<>();
        l2.add(new C()); // можно хранить B и его потомков
        A c = l2.get(0); // возвращаемый тип не младше B
        A obj = get(l2); // аргументом метода может быть список с типом не старше B
        System.out.println(obj.getClass().getSimpleName()); // C
        System.out.println(obj.t() + " -- " + obj.v); // C -- A
    }

    // Producer - extends
    private static <T extends B> T get(List<T> list) { // T коллекции может быть от B и младше
        return list.get(0); // возвращаемый тип не младше B (но объект может быть потомком B)
    }


    {
        enum Test {T1, T2, T3}
        Set<Test> sTest = EnumSet.allOf(Test.class);

        Map<String, String> mapL = new LinkedHashMap<>();
        Map<String, String> mapT = new TreeMap<>();

        Set<String> tSet = new TreeSet<>();
        Set<String> hSet = new HashSet<>();

        CopyOnWriteArrayList<String> cowal = new CopyOnWriteArrayList<>();
        ConcurrentMap<String, String> cMap = new ConcurrentHashMap<>();

    }
}
