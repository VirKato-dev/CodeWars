package guru;

public class DivideBy0 {

    public static void main(String[] args) {
        System.out.println(0.0/0.0);
        System.out.println(0.0/0);
        System.out.println((1.0/0.0) / (0.0/0.0));
        System.out.println(-1.0/0);
        System.out.println(1.0/0.0f);
        System.out.println(Float.POSITIVE_INFINITY);
        System.out.println(Float.NEGATIVE_INFINITY);
        System.out.println(Float.NaN);
        System.out.println(Float.isFinite(Float.POSITIVE_INFINITY));
        System.out.println(Float.TYPE);
    }
}
