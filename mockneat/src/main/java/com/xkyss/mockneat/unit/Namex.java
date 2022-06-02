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
     * 男名
     */
    public MockUnitString male() {
        return dictx.of("names/male");
    }

    /**
     * 女名
     */
    public MockUnitString female() {
        return dictx.of("names/female");
    }

    public MockUnitString single() {
        return single(50.0);
    }

    public MockUnitString multi() {
        return multi(50.0);
    }

    public MockUnitString full() {
        return full(50.0, 50.0);
    }

    /**
     * 单名
     *  p: 男女概率, 区间[0, 100]
     */
    public MockUnitString single(double p) {
        return () -> () -> mockNeat.bools().probability(p).val()
                ? male().val()
                : female().val();
    }

    /**
     * 多名
     *  p: 男女概率, 区间[0, 100]
     */
    public MockUnitString multi(double p) {
        return () -> () -> mockNeat.bools().probability(p).val()
                ? (male().val() + male().val())
                : (female().val() + female().val());
    }

    /**
     * 全名
     *  p1: 男女概率, 区间[0, 100]
     *  p2: 单双概率, 区间[0, 100]
     */
    public MockUnitString full(double p1, double p2) {
        return () -> () -> first().val() + (mockNeat.bools().probability(p2).val() ? single(p1).val() : multi(p1).val());
    }

    @Override
    public Supplier<String> supplier() {
        return full(50.0, 50.0).supplier();
    }
}
