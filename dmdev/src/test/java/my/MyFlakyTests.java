package my;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class MyFlakyTests {

    @Test
    @Disabled("flaky, нестабильный")
    void flakyTest() {
    }


    @RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
    void repeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo);
    }

    @Test
    void withTimeout() {
        var result = assertTimeout(Duration.ofMillis(10), () -> {
            Thread.sleep(20);
            return "OK";
        });
    }

    @Test
    void withTimeoutParallel() {
        System.out.println(Thread.currentThread());
        var result = assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
            Thread.sleep(20);
            System.out.println(Thread.currentThread());
            return "OK";
        });
    }
}
