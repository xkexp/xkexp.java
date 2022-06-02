package com.xkyss.mockneat.util;

import com.xkyss.mockneat.Mockx;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FormatterxTest {

    @Test
    public void test_01() {
        Mockx m = new Mockx();
        String s = Mockx.fmtx().append("牛牛街").append(m.ints().range(100, 999)).append("号").get();
        Assertions.assertNotNull(s);
        Assertions.assertTrue(s.startsWith("牛牛街"));
        Assertions.assertTrue(s.endsWith("号"));
    }
}
