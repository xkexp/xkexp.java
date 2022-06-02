package com.xkyss.mockneat.unit;

import com.xkyss.mockneat.util.Dictx;
import net.andreinc.mockneat.abstraction.MockUnitBase;
import net.andreinc.mockneat.abstraction.MockUnitString;

import java.util.function.Supplier;

public class Namex extends MockUnitBase implements MockUnitString {

    private final Dictx dictx;

    public Namex(Dictx dictx) {
        this.dictx = dictx;
    }

    /**
     * 姓
     */
    public MockUnitString first() {
        return dictx.of("names/first");
    }

    /**
     * 名
     */
    public MockUnitString last() {
        return dictx.of("names/last");
    }

    /**
     * 单名
     */
    public MockUnitString single() {
        return () -> () -> first().val() + last().val();
    }

    /**
     * 双名
     */
    public MockUnitString multi() {
        return () -> () -> first().val() + last().val() + last().val();
    }

    /**
     * 全名(单双均有概率)
     */
    public MockUnitString full() {
        return () -> () -> mockNeat.bools().probability(50.0).val() ? single().val() : multi().val();
    }

    @Override
    public Supplier<String> supplier() {
        return full().supplier();
    }
}
