package date;

import java.time.Instant;
import java.time.ZoneId;

public class Converting {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.printf("%d = '%s'%n", time,
                Instant.ofEpochMilli(time)
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime());
    }
}
