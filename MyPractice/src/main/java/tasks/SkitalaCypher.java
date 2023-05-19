package tasks;

public class SkitalaCypher {

    public static void main(String[] args) {
        int columns = 4;
        String encoded = cypherSkitala("Какой-то текст", columns, true);
        String decoded = cypherSkitala(encoded, columns, false);
        System.out.println(encoded + "  ---  " + decoded);
        // Кй са-тткте*оок*  ---  Какой-то текст
    }


    /**
     * шифр Скитала (жезл)
     * @param text текст для шифрации/расшифровки
     * @param key число колонок
     * @param mode true - шифрация
     * @return
     */
    public static String cypherSkitala(String text, int key, boolean mode) {
        String result = "";
        if (key < 2) key = 6; // минимальное количество колонок
        while (text.length() % key != 0) text += "*"; // символы заполнения
        int tl = text.length();
        int row_count = tl / key; // количество строк шифра

        if (mode) {
            //разбить текст на строки
            String[] row = new String[row_count];
            for (int i = 0; i < row_count; i++) {
                row[i] = text.substring(key * i, key * (i + 1));
            }
            //развернуть ленту
            for (int i = 0; i < key; i++) {           //по колонкам
                for (int j = 0; j < row_count; j++) { //по строкам
                    result += row[j].charAt(i);
                }
            }
        } else {
            //разбить на колонки
            String[] col = new String[key];
            for (int i = 0; i < key; i++) {
                col[i] = text.substring(row_count * i, row_count * (i + 1));
            }
            //свернуть ленту
            for (int i = 0; i < row_count; i++) { //по строкам
                for (int j = 0; j < key; j++) {   //по колонкам
                    result += col[j].charAt(i);
                }
            }
            if (result.indexOf('*') > -1) { //убираем символы заполнения
                result = result.substring(0, result.indexOf('*'));
            }
        }
        return result;
    }

}
