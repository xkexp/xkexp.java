package com.xkyss.mockneat.util;

import net.andreinc.aleph.AlephFormatter;
import net.andreinc.mockneat.abstraction.MockUnit;
import net.andreinc.mockneat.abstraction.MockUnitString;
import net.andreinc.mockneat.abstraction.MockUnitValue;
import net.andreinc.mockneat.abstraction.MockValue;
import net.andreinc.mockneat.utils.ValidationUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Formatterx implements MockUnitString {

    private final Map<String, MockValue<?>> fields = new HashMap();
    private String fmt = "";

    public <T> Formatterx append(MockUnit<T> mock) {
        ValidationUtils.notNull(mock, "mock");
        String param = String.format("p%d", fields.size()+1);
        append(String.format("#{%s}", param));
        this.fields.put(param, MockUnitValue.unit(mock));
        return this;
    }

    public Formatterx append(String s) {
        ValidationUtils.notNull(s, "string");
        this.fmt = this.fmt + s;
        return this;
    }

    @Override
    public Supplier<String> supplier() {
        return () -> {
            Map<String, Object> args = (Map)this.fields.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, (e) -> {
                return ((MockValue)e.getValue()).getStr();
            }));
            return AlephFormatter.str(this.fmt).args(args).fmt();
        };
    }
}
