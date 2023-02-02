package com.codewars.range.extraction.v2;

class Solution {
    public static String rangeExtraction(int[] arr) {
        String res = "";
        boolean isStart = true;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isDiapason = (arr[i] + 1 != arr[i + 1]);
            res += isDiapason ? arr[i] + "," : isStart ? arr[i] + "~" : "~";
            isStart = isDiapason;
        }
        return res.replaceAll("(~{2,})", "-").replace("~", ",") + arr[arr.length - 1];
    }
}