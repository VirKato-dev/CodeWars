package com.codewars.persistent.bugger.v0;

class Persist {

    public static void main(String[] args) {
        System.out.println(persistence(39));
        System.out.println(persistence(999));
        System.out.println(persistence(4));
    }

    public static int persistence(long n) {
        int res = 0;
        while (n > 9) {
            long i = n;
            n = 1;
            while (i > 0) {
                n *= i % 10;
                i /= 10;
            }
            res++;
        }
        return res;
    }
}