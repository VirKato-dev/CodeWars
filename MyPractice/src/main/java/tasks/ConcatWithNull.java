package tasks;

/**
 * Конкатенация строк при помощи оператора «+» и метода concat отличается по своей реализации.
 * Оператор «+», если разложить код дизассемблером и проанализировать, развернется в нечто вроде
 *
 * String s1 = new StringBuilder()
 *      .append(s1)
 *      .append(s2)
 *      .toString();
 *
 * При этом s1 и s2 неявно преобразуются в String (т. е. null -> «null») и NullPointerException’а не возникнет.
 * В случае же с concat оно будет брошено, т. к. метод вызывается у null-объекта.
 *
 * Поэтому первые две строки отработают как ожидается.
 * Третья строка успешно пройдет компиляцию, т. к. null-объект явно преобразовывается в строку со значением «null».
 */
public class ConcatWithNull {
    public static void main(String[] args) {
        String nullString = null;
        System.out.print(null + nullString);
        System.out.print(nullString + null);
        System.out.print((String) null);
    }
}
