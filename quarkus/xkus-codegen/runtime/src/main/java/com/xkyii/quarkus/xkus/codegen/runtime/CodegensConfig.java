package com.xkyii.quarkus.xkus.codegen.runtime;

import io.quarkus.datasource.common.runtime.DataSourceUtil;
import io.quarkus.runtime.annotations.*;

import java.util.Collections;
import java.util.Map;

@ConfigRoot(name = "xkus.codegen", phase = ConfigPhase.BUILD_AND_RUN_TIME_FIXED)
public class CodegensConfig {

    /**
     * The default config
     */
    @ConfigItem(name = ConfigItem.PARENT)
    public CodegenConfig defaultConfig = CodegenConfig.defaultConfig();

    /**
     * Additional named config.
     */
    @ConfigDocSection
    @ConfigDocMapKey("codegen-name")
    @ConfigItem(name = ConfigItem.PARENT)
    public Map<String, CodegenConfig> namedConfigs = Collections.emptyMap();

    public CodegenConfig getConfig(String name) {
        if (DataSourceUtil.isDefault(name)) {
            return defaultConfig;
        }
        return namedConfigs.getOrDefault(name, CodegenConfig.defaultConfig());
    }
}
