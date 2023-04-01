package a.collections;

import java.lang.reflect.InvocationTargetException;

public class ArrayOfGeneric {
    public static void main(String[] args) {
        String[] arr = new String[3];
        fill(arr, String.class);
    }

    /**
     * Заполнить массив объектами указанного класса
     * @param a
     * @param clazz
     */
    static void fill(Object[] a, Class<?> clazz) {
        try {
            for (int i = 0; i < a.length; i++) {
                a[i] = clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ignored) {

        }
    }
}
