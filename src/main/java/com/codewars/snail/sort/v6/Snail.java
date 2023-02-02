package com.codewars.snail.sort.v6;

public class Snail {
    public static int[] snail(int[][] array) {
        int n = array.length;           // длина квадрата
        if (array[0].length == 0) return new int[0];     // проверка на пустой переданный массив

        int[] result = new int[n * n];  // создаём результирующий массив
        int endXY = (n - 1) / 2;        // Кол-во слоёв массива
        int index = 0;                  // Текущий индекс результирующего массива
        boolean isEven = n % 2 == 0;    // Проверка на чётность стороны массива

        for (int i = 0; i <= endXY; i++) {
            int x = i;
            int y = i;
            for (; x < n - i - 1; x++) result[index++] = array[y][x];
            for (; y < n - i - 1; y++) result[index++] = array[y][x];
            for (; x > i; x--) result[index++] = array[y][x];
            for (; y >= i + 1; y--) result[index++] = array[y][x];
        }

        // если массив не чётный, то нужно добавить последнюю точку
        if (!isEven) {
            result[index] = array[endXY][endXY];
        }
        return result;
    }
}