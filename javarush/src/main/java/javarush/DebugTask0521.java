package javarush;

/*
Выполни фрагмент кода
*/

/*
Потренируйся выполнять фрагмент кода во время работы программы:
1. Поставь break point напротив вызова метода println и запусти программу в режиме отладки.
2. После остановки нажми Alt+F8 (Option+F8 для macOS) и выполни следующий код:
      loop.replaceAll("\\W", "").split("fahrenheit")[1]
3. Результат выполнения кода присвой полю result (измени исходный код).
В итоге в классе Solution должно быть только одно изменение: поле result должно быть инициализировано при объявлении.
*/

public class DebugTask0521 {

    public static int result; // = 45967;

    public static void main(String[] args) {
        String loop = "    for (double fahrenheit = -459.67; fahrenheit < 451; fahrenheit += 40) {\n";
        System.out.println(loop);
    }
}
