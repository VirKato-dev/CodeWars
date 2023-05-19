package tasks;

public class CezarCypher {
    public static void main(String[] args) {
        int shift = 13;
        String encoded = cypherCezar("Какой-то текст", shift, true);
        String decoded = cypherCezar(encoded, shift, false);
        System.out.println(encoded + "  ---  " + decoded);
        // Лблпк-уп уёлту  ---  Какой-то текст   (при сдвиге = 1)
        // Чмчыц-яы ясчюя  ---  Какой-то текст   (при сдвиге = 13)
    }

    private static String abc = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    //шифр Цезаря
    public static String cypherCezar(String text, int key, boolean mode) {
        // key - количество символов сдвига таблицы
        // mode - true - шифр / false - дешифр
        String result = "";
        if (key < 0) key = 0;
        //вычитание при дешифровании, либо сложение
        key *= mode ? 1 : -1;
        int tl = text.length();
        int al = abc.length();
        // большие не должны превращаться в маленькие

        for (int i = 0; i < tl; i++) {
            int ti = abc.indexOf(text.charAt(i));
            if (ti >= 0) {
                int ai = (al + (ti + key)) % al;
                //сдвигаем выборку символов из таблицы
                result += abc.charAt(ai);
            } else {
                result += text.charAt(i);
            }
        }
        return result;
    }
}
