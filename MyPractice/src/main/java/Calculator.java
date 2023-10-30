import java.util.Scanner;

public class Calculator {

    // нам нужны числа до 100
    static int[] arabic = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};

    static String[] roman = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    static String allActions = "+\t-\t*\t/"; // \t для предотвращения использования ** например
    static String allRoman = "CLXVI";

    public static void main(String[] args) {
        // System.out.println(calculate(new Scanner(System.in).nextLine()));
        System.out.println(calculate("IX * X"));
        System.out.println(calculate("X * X + I"));
        System.out.println(calculate("X + 3"));
        System.out.println(calculate("XS - X"));
        System.out.println(calculate("L / V"));
        System.out.println(calculate("IX / X"));
        System.out.println(calculate("III - IV"));
        System.out.println(calculate("III -- IV"));
    }


    private static String calculate(String input) {
        System.out.print(input + " = ");
        try {
            boolean isRoman = false;
            // разбить строку на части по пробелам между числами и действием
            String[] part = input.split("\\s+");

            // какое арифметическое действие выполняется
            String action = part[1]; // возможно исключение

            // только 1 из 4 арифметических действий допустимо
            if (!allActions.contains(action)) throw new IllegalArgumentException("неверная операция");

            // только 3 элемента выражения допустимо
            if (part.length != 3) throw new IllegalArgumentException("ошибка выражения");

            // соответствие типов значений
            if (allRoman.contains(Character.toString(part[0].charAt(0)))) {
                if (!allRoman.contains(Character.toString(part[2].charAt(0)))) {
                    // если первое число римское, то и второе обязано быть римским
                    throw new IllegalArgumentException("разные типы");
                }
                isRoman = true;
            } else if (allRoman.contains(Character.toString(part[2].charAt(0)))) {
                // если первое число не римское, то и второе обязано быть не римским (арабским)
                throw new IllegalArgumentException("разные типы");
            }

            // недопустимо в римском числе использовать более 3-х одинаковых цифр подряд
            if (!part[0].replaceAll(".{4}", "").equals(part[0])
                    || !part[2].replaceAll(".{4}", "").equals(part[2])) {
                throw new IllegalArgumentException("неверная запись числа");
            }

            int num1, num2;

            if (isRoman) {
                // возможно исключение при конвертировании
                num1 = toArabic(part[0]);
                num2 = toArabic(part[2]);
            } else {
                // возможно исключение при конвертировании
                num1 = Integer.parseInt(part[0]);
                num2 = Integer.parseInt(part[2]);
            }

            // допустимы числа не более 10
            if (num1 > 10 || num2 > 10) {
                throw new IllegalArgumentException("недопустимое значение");
            }

            int result = 0;
            switch (action) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("недопустимая операция");
            }

            if (isRoman) {
                return toRoman(result);
            }

            return "" + result;
        } catch (RuntimeException e) {
            System.out.print(e.getMessage());
            return "";
        }
    }


    private static int toArabic(String number) {
        int result = 0;
        for (int j = 0; j < roman.length; j++) {
            while (!number.isEmpty() && number.startsWith(roman[j])) {
                result += arabic[j];
                number = number.substring(roman[j].length());
            }
        }
        if (result > 0 && number.isEmpty()) return result;
        // 0 - конвертирование с ошибкой
        throw new IllegalArgumentException("ошибка конвертации");
    }


    private static String toRoman(int input) {
        String result = "";
        for (int j = 0; j < arabic.length; j++) {
            while (input >= arabic[j]) {
                input -= arabic[j];
                result += roman[j];
            }
        }
        if (input == 0 && !result.isEmpty()) return result;
        // число < 1 недопустимо
        throw new IllegalArgumentException("недопустимый результат");
    }
}
