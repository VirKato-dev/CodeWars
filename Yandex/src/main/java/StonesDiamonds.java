import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StonesDiamonds {
    public static void main(String[] args) {
        int res = 0;
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            String j = in.nextLine();
            String s = in.nextLine();
            Set<String> last = new HashSet<>();
            for (String c : j.split("")) {
                if (last.add(c)) {
                    res += s.length() - s.replaceAll(c, "").length();
                }
            }
        }
        System.out.println(res);
    }
}
