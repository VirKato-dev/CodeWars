package codewars.find.the.missing.letter.v3;

public class Kata {
    public static char findMissingLetter(char[] array) {
        int n = 0;
        while (1 + (int) array[n] == (int) array[++n]) {}
        return ++array[--n];
    }
}