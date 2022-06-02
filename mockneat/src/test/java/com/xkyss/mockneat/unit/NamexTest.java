package com.xkyss.mockneat.unit;

import com.xkyss.mockneat.Mockx;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NamexTest {

    @Test
    public void test_01() {
        Mockx m = new Mockx();
        Assertions.assertNotNull(m.namex().first().get());
        Assertions.assertNotNull(m.namex().last().get());
        Assertions.assertNotNull(m.namex().single().get());
        Assertions.assertNotNull(m.namex().multi().get());
        Assertions.assertNotNull(m.namex().full().get());
        Assertions.assertNotNull(m.namex().get());
    }
}
