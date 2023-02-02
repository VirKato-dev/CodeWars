package com.codewars.roman.numerals.encoder.v4;

public class Conversion {

    public String solution(int n) {
        StringBuilder res = new StringBuilder();
        while (n>0) {
            if (n>=1000) {res.append("M"); n-=1000; continue;}
            if (n/100==9) {res.append("CM"); n-=900; continue;}
            if (n>=500 && n<=899) {res.append("D"); n-=500; continue;}
            if (n/100==4) {res.append("CD"); n-=400; continue;}
            if (n>=100 && n<=399) {res.append("C"); n-=100; continue;}
            if (n/10==9) {res.append("XC"); n-=90; continue;}
            if (n>=50 && n<=89) {res.append("L"); n-=50; continue;}
            if (n==40) {res.append("XL"); n-=40; continue;}
            if (n>=10 && n<=39) {res.append("X"); n-=10; continue;}
            if (n==9) {res.append("IX"); n-=9; continue;}
            if (n>=5 && n<=8) {res.append("V"); n-=5; continue;}
            if (n==4) {res.append("IV"); n-=4; continue;}
            if (n>=1 && n<=3) {res.append("I"); n-=1; continue;}
        }
        return res.toString();
    }
}
