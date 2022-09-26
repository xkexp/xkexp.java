package com.xkyii.quarkus.xkus.codegen.deployment.devconsole;

import com.xkyii.quarkus.xkus.codegen.runtime.CodegenConfig;
import com.xkyii.quarkus.xkus.codegen.runtime.CodegenContainerSupplier;
import com.xkyii.quarkus.xkus.codegen.runtime.CodegenRecorder;
import com.xkyii.quarkus.xkus.codegen.runtime.CodegensConfig;
import io.quarkus.arc.deployment.SyntheticBeansRuntimeInitBuildItem;
import io.quarkus.datasource.common.runtime.DataSourceUtil;
import io.quarkus.deployment.IsDevelopment;
import io.quarkus.deployment.annotations.*;
import io.quarkus.deployment.logging.LoggingSetupBuildItem;
import io.quarkus.deployment.pkg.builditem.CurateOutcomeBuildItem;
import io.quarkus.devconsole.spi.DevConsoleRuntimeTemplateInfoBuildItem;

import java.util.Map;


public class CodegenDevConsoleProcessor {

    @BuildStep(onlyIf = IsDevelopment.class)
    public DevConsoleRuntimeTemplateInfoBuildItem codegenUnits(CurateOutcomeBuildItem curateOutcomeBuildItem) {
        return new DevConsoleRuntimeTemplateInfoBuildItem(
                "codegen",
                new CodegenContainerSupplier(),
                this.getClass(),
                curateOutcomeBuildItem
        );
    }

    @BuildStep
    @Produce(SyntheticBeansRuntimeInitBuildItem.class)
    @Consume(LoggingSetupBuildItem.class)
    @Record(ExecutionTime.RUNTIME_INIT)
    void init(CodegenRecorder recorder, CodegensConfig configs) {
        recorder.resetContainers();

        recorder.addContainer(DataSourceUtil.DEFAULT_DATASOURCE_NAME, configs.defaultConfig);
        if (!configs.namedConfigs.isEmpty()) {
            for (Map.Entry<String, CodegenConfig> entry: configs.namedConfigs.entrySet()) {
                recorder.addContainer(entry.getKey(), entry.getValue());
            }
        }
    }
}
