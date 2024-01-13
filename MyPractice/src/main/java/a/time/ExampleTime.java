package a.time;

public class ExampleTime {

    private static final double SECONDS_IN_HOUR = 3600;
    private static final double SECONDS_IN_MINUTE = 60;

    public static void main(String[] args) {
        double time = 1 * SECONDS_IN_HOUR + 1 * SECONDS_IN_MINUTE;
        double ch = Math.floor(time / SECONDS_IN_HOUR);
        double m = Math.floor((time - (ch * SECONDS_IN_HOUR)) / SECONDS_IN_MINUTE);
        double s = time - (ch * SECONDS_IN_HOUR + m * SECONDS_IN_MINUTE);
        System.out.println(String.format("%02.0f:%02.0f:%02.0f", ch, m, s));
    }
}
