package codewars.round;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class RoundAndRound {

    public static void main(String[] args) {
        System.out.println(roundTo2DecimalPlaces(7.487));
        System.out.println(roundTo2DecimalPlaces(-16.345));
    }

    public static double roundTo2DecimalPlaces1(double number) {
        if (number < 0) return -roundTo2DecimalPlaces(-number);
        if ((number * 1000) % 10 == 5) number += 0.001;
        return Math.round(number * 100.00) / 100.00;
    }

    public static double roundTo2DecimalPlaces2(double number) {
        return Double.parseDouble(String.format(Locale.ENGLISH, "%.2f", number));
    }

    public static double roundTo2DecimalPlaces3(double number) {
        double a = Math.round(Math.abs(number * 1e7) / 1e5) / 100.0;
        return number < 0 ? -a : a;
    }

    public static double roundTo2DecimalPlaces4(double number) {
        return BigDecimal.valueOf(number).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static double roundTo2DecimalPlaces5(double number) {
        String s = number + "00";
        int l = s.indexOf(".") + 3;
        char b = (s.charAt(l) - '0') > 4 ? '6' : '0';
        double a = Double.parseDouble(s.substring(0, l) + b);
        return Math.round(a * 100) / 100.0;
    }

    public static double roundTo2DecimalPlaces6(double number) {
        if (number == (int) number) return number;
        var s = String.valueOf(number);
        var i = s.indexOf('.');
        s = s.replace(".", "");
        var m = Double.parseDouble(s.substring(0, i + 2) + "." + s.substring(i + 2));
        return Math.round(Math.abs(m)) / 100.0 * (m < 0 ? -1 : 1);
    }

    public static double roundTo2DecimalPlaces(double number) {
        if (number < 0) return -roundTo2DecimalPlaces(-number);
        number = new BigDecimal("" + number).multiply(new BigDecimal(100)).doubleValue();
        return Math.round(number) / 100.0;
    }

}
