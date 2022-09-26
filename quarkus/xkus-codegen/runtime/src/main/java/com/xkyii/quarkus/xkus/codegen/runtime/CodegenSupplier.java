package com.xkyii.quarkus.xkus.codegen.runtime;

import java.util.function.Supplier;

public class CodegenSupplier implements Supplier<String> {

    @Override
    public String get() {
        return "codegen";
    }

}
