import java.io.*;
import java.util.Scanner;

public class AplusB2 {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
             OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file))) {
            Scanner in = new Scanner(isr);
            int res = in.nextInt() + in.nextInt();
            osw.write("" + res);
        }
    }
}
