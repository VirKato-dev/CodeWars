package codewars.take.a.ten.minutes.walk.v2;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10) return false;
        int n = 0, s = 0, w = 0, e = 0;
        for (char c : walk) {
            switch (c) {
                case 'n' -> n++;
                case 's' -> s++;
                case 'w' -> w++;
                case 'e' -> e++;
            }
        }
        return n == s && w == e;
    }
}