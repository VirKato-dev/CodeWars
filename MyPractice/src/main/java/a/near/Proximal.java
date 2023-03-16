package a.near;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.abs;

public class Proximal {
    static int a;

    {
        a = 2;
        if (false) {
            throw new Exception();
        }
    }

    public Proximal() throws Exception {
    }

    public static void main(String[] args) {
        System.out.println(get(50, 60));
        System.out.println(get(50, 110));
        System.out.println(get(-50, -110));
        System.out.println(get(-50, 200));

        int[] a = {1,2,3};
        a[1] = Integer.valueOf(5);
        Object[] b = {1,2,3};
        b[1] = new Exception();
        System.out.println(Arrays.toString(b));

        int num = 0;
        for (int i = 0; i < 100; i++) {
            num = num++;
//            0: iconst_0     // положить на стек 0
//            1: istore_1     // сохранение значения в переменную 1
//            2: iload_1      // положить на стек значение из переменной 1
//            3: iinc  1, 1   // увеличение значения переменной с индексом 1 на 1
//            6: istore_1     // сохранение значения 0 в переменную 1
//            7: return
        }
        System.out.println(num);

        String err;
        try { // правильный порядок catch при родственных исключениях
            test();
        } catch (IOException e) {
            err = e.getMessage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int get(int... a) {
        int z = 100;
        return Arrays.stream(a)
                .reduce((y, x) -> (abs(z - x) < abs(z - y)) ? x : y)
                .getAsInt();
    }

    private static void test() throws Exception {
        if (new Random().nextInt(10) > 5) throw new Exception();
        else throw new IOException();
    }
}
