package com.xkyii.quarkus.xkus.codegen.deployment.devconsole;

import com.xkyii.quarkus.xkus.codegen.runtime.CodegenSupplier;
import io.quarkus.deployment.IsDevelopment;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.pkg.builditem.CurateOutcomeBuildItem;
import io.quarkus.devconsole.spi.DevConsoleRuntimeTemplateInfoBuildItem;

public class CodegenDevConsoleProcessor {

    @BuildStep(onlyIf = IsDevelopment.class)
    public DevConsoleRuntimeTemplateInfoBuildItem codegenUnits(CurateOutcomeBuildItem curateOutcomeBuildItem) {
        return new DevConsoleRuntimeTemplateInfoBuildItem(
                "codegen",
                new CodegenSupplier(),
                this.getClass(),
                curateOutcomeBuildItem
        );
    }
}
