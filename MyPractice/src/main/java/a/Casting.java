package a;

public class Casting {
    public static void main(String[] args) {
        long y = 25_000_000L; // тогда нет потерь, потому что число влазит в int (да)
        int x = (int)y; // получилось отрицательный int
        System.out.println(x + " == " + y);
        // потеряны старшие байты - число получилось совсем не то
        // потому что слишком большое число превращается просто в 0 и не видно косяка

        int x1 = (int)2.5f;
        System.out.println(x1);
        // потеря дробной части

        float f = (float) Double.MAX_VALUE;
        System.out.println(f);

        System.out.println(0.0 / 0.0); // на 0.0 делить можно, но смысла нет

        double res = 1 + 1; // не помню с какими числами, но иногда могут быть неточные вычисления
        System.out.println("0.1 + 0.1 = " + res); // не помню как ошибку создать в вычислении double

        // да хз что там может потеряться при неявных
        // есть возможность потери при int -> float, но хз   видимо из-за того, что int целое может хранить
        // целую часть, которая не уместится в целой части float

        float xx = Integer.MAX_VALUE;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(xx);
        int xy = (int)xx;
        System.out.println(xy);
        // есть неточность при обратном преобразовании
        // 2.1474836 5E9  // точность та же, но выглядит иначе просто
        // 2 1474836 47
        // хз     без потери по сути     только отображение немного отличается и всё

        // в int     0xFFffFFff = -1       0x7FffFFff = +2147483647        0x80000000 = -2....
        // в float   те же байты иначе интерпретируются
        // представление числа с плавающей точной     в памяти   для меня тоже магия
        // число состоит из 2 частей          целая часть   и   мантиса какая-то     если хочешь то читай )

        /*
            По умолчанию, вычисления с плавающей точкой ведутся с помощью double.
        */
        testDoubleToFloat(99999999.0 + 1.0 / 3.0); // Добавим периодичности
        testDoubleToFloat(98888888.0 + 1.0 / 3.0); // Вариант без округления девяток
        testDoubleToFloat(2974815.78);
        testDoubleToFloat(-2974815.78);
        // есть потери double --> float
        // происходят из-за потери байтов     в этих байтах дополнительная уточняющая информация
        // без неё и потери
        // тут требуется знать формат хранения числа в памяти   для чисел с плавающей точкой
    }

    static void testDoubleToFloat(double d) {
        float f = (float) d;

        System.out.println();
        System.out.println(String.format("double %.10f\t%s", d, Long.toBinaryString(Double.doubleToRawLongBits(d))));
        System.out.println(String.format("float  %.10f\t   %s", f, Integer.toBinaryString(Float.floatToRawIntBits(f))));
    }

    private static int getChar() {
        return '\\' + 1;
    }

}
