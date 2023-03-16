package a.proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ByteBuddyProxyTest {

    @Test
    void FirstTest() {
        assertEquals("ВАСЯ", ByteBuddyProxy.what());
    }

}
