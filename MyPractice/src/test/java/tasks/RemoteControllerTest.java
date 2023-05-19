package tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoteControllerTest {
    private RemoteController rc;

    @BeforeEach
    void init() {
        rc = new RemoteController();
    }

    @Test
    void firstButton() {
        System.out.println("-".repeat(10));
        rc.secondButton();
        assertEquals(1, rc.firstButton());
    }

    @Test
    void secondButton() {
        System.out.println("-".repeat(10));
        IntStream.range(0, 10).forEach((i) -> rc.secondButton());
        rc.firstButton();
        rc.secondButton();
        assertEquals(2, rc.secondButton());
    }

    @Test
    void thirdButton() {
        System.out.println("-".repeat(10));
        rc.firstButton();
        rc.thirdButton();
        rc.firstButton();
        rc.thirdButton();
        assertEquals(-2, rc.thirdButton());
    }
}