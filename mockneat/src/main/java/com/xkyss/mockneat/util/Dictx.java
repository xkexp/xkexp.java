package com.xkyss.mockneat.util;


import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.abstraction.MockUnitBase;
import net.andreinc.mockneat.abstraction.MockUnitString;
import net.andreinc.mockneat.utils.ValidationUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Dictx extends MockUnitBase {

    private final static String ROOT = "dictx/";
    private final Filex fx = Filex.getInstance();

    protected Dictx() {
    }

    public Dictx(MockNeat mockNeat) {
        super(mockNeat);
    }

    public MockUnitString of(String path) {
        ValidationUtils.notNull(path, "path");
        return () -> {
            MockUnitString unit = this.mockNeat.fromStrings(this.fx.getLines(ROOT + path));
            Objects.requireNonNull(unit);
            return unit::val;
        };
    }

    public List<String> data(String path) {
        ValidationUtils.notNull(path, "path");
        return Collections.unmodifiableList(this.fx.getLines(ROOT + path));
    }
}
