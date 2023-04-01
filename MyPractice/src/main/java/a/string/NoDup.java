package a.string;

import java.util.StringJoiner;

public class NoDup {
    public static void main(String[] args) {
        String text = "Hhhhalllo!";
        String res = text.replaceAll("(?i)(.)\\1+", "$1");
        System.out.println(res);

//        method();
        System.out.println(join("a", "b", "c"));
        System.out.println(join2("a", "b", "c"));
        System.out.println(join2());
    }


    static int method() {
        return true ? null : 0;
    }


    /**
     * отрефакторить
     * @param args
     * @return
     */
    static String join(String... args) {
        String result = "";
        for (String arg : args) {
            result += arg;
            result += ", ";
        }
        return result;
    }

    /**
     * рефактор
     * @param args
     * @return
     */
    static String join2(String... args) {
        StringJoiner result = new StringJoiner(",");
        for (String arg : args) result.add(arg);
        return result.toString();
    }
}
