package com.xkyii.quarkus.xkus.codegen.runtime;

import io.quarkus.runtime.annotations.Recorder;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;

@Recorder
public class CodegenRecorder {

    private static final Logger log = Logger.getLogger(CodegenRecorder.class);

    static final List<CodegenContainer> CODEGEN_CONTAINERS = new ArrayList<>(2);

    public void resetContainers() {
        CODEGEN_CONTAINERS.clear();
    }

    public void addContainer(String id, CodegenConfig config) {
        CODEGEN_CONTAINERS.add(new CodegenContainer(id, config));
    }
}
