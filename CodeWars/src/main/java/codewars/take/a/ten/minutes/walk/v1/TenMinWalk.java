package codewars.take.a.ten.minutes.walk.v1;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        String s = new String(walk);
        return s.chars().filter(p -> p == 'n').count() == s.chars().filter(p -> p == 's').count()
                && s.chars().filter(p -> p == 'e').count() == s.chars().filter(p -> p == 'w').count()
                && s.chars().count() == 10;
    }
}