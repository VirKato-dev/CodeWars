package a;

/**
 * Что выведет следующий код?
 *
 * В спецификации Java указано, что при передаче в метод параметра со значением null(без явного преобразования)
 * компилятор вызовет метод с наиболее специфицированным типом. Т. е. при прочих равных будет проанализирована
 * иерархия наследования и компилятор вызовет метод с сигнатурой Long, который более «узок»,
 * чем его предки Number и Object. Стоит отметить, что если в коде будут реализованы методы с параметрами,
 * тип которых не лежит в прямой вертикальной иерархии с остальными (например, printNumber(Short x)),
 * то компилятор не сможет использовать указанное правило и выдаст ошибку компиляции.
 *
 * При явном преобразовании будет вызван соответствующий приводимому типу метод
 * (если вызов будет printNumber((Number)null), то на экран выведется «Number»).
 */
public class Polymorph {
    public static void main(String[] args) {
        printNumber(null);
    }

    static void printNumber(Object x) {
        System.out.println("Object");
    }

    static void printNumber(Long x) {
        System.out.println("Long");
    }

    static void printNumber(Number x) {
        System.out.println("Number");
    }
}
