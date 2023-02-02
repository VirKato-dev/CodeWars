package a.io;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

public class IoNioExample {

    public static void main(String[] args) {
//        read1();
//        read2();
//        read3();
//        read4();
//        read5();
        System.out.println(0x10); // шестнадцатеричное
        System.out.println(0b1010); // двоичное
        System.out.println(077); // восьмеричное
//        write1("Some text for test");
        loadImageFromUrl("From%20VirKato%20and%20other%20people");
    }

    private static void read1() {
        try (InputStream is = new FileInputStream("src/main/java/org/example/a/io/IoNioExample.java")) {
            int data;
            while ((data = is.read()) >= 0) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void read2() {
        Path filePath = Paths.get("src/main/java/org/example/a/io/IoNioExample.java");
        try {
            Reader fr = new InputStreamReader(Files.newInputStream(filePath));
            int data;
            while ((data = fr.read()) != -1) System.out.print((char) data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void read3() {
        Path filePath = Paths.get("src/main/java/org/example/a/io/IoNioExample.java");

        InputStream is;
        try {
            is = Files.newInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            //
            PushbackInputStream pbis = new PushbackInputStream(is);
            pbis.unread(10); // байт
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            //
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void read4() {
        Path filePath = Paths.get("src/main/java/org/example/a/io/IoNioExample.java");
        Path filePath2 = Paths.get("src/main/java/org/example/a/io/text.txt");
        InputStream is;
        try {
            is = Files.newInputStream(filePath);

            Vector<InputStream> list = new Vector<>();
            list.add(is);
            list.add(Files.newInputStream(filePath2));
            Enumeration<InputStream> eis;
            eis = list.elements();
            try (SequenceInputStream sis = new SequenceInputStream(eis)) {
                int data;
                while ((data = sis.read()) != -1) {
                    System.out.print((char) data);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void read5() {
        Path filePath = Paths.get("src/main/java/org/example/a/io/IoNioExample.java");
        try (FileChannel fc = FileChannel.open(filePath, StandardOpenOption.READ)) {
            // отобразить файл в байтовый буфер
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            // декодируем байты как символы UTF-8
            Charset cs = StandardCharsets.UTF_8;
            CharBuffer cb = cs.decode(mbb);
            // показать текст
//            while (cb.hasRemaining()) System.out.print(cb.get());
            System.out.println(cb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write1(String data) {
        try (FileOutputStream fos = new FileOutputStream("img.txt")) {
            fos.write(data.getBytes());
        } catch (IOException ignored) {
        }
    }

    private static void loadImageFromUrl(String text) {
        String url = "https://apis.xditya.me/write?text=" + text;
        //InputStream iss = new ByteArrayInputStream(url.getBytes());
        try (InputStream is = new URI(url).toURL().openStream();
             FileOutputStream fos = new FileOutputStream("imgWithText.jpg")) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = is.read(buf)) != -1) {
                fos.write(buf,0, len);
            }
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
