package a.algo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickTest {

    @Test
    void quickSort() {
        assertArrayEquals(
                Quick.quickSort(new int[]{64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36}),
                new int[]{16, 24, 32, 36, 41, 42, 42, 53, 55, 57, 64, 73, 74});
    }
}