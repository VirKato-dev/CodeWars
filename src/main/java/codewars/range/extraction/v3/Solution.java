package codewars.range.extraction.v3;

class Solution {
    public static String rangeExtraction(int[] arr) {
        String str = String.valueOf(arr[0]);
        for (int i = 1; i < arr.length; i++)
            str += (arr[i - 1] == arr[i] - 1 ? "<" : ",") + String.valueOf(arr[i]);
        return str.replaceAll("<([^,]*<)+", "-").replaceAll("<", ",");
    }
}