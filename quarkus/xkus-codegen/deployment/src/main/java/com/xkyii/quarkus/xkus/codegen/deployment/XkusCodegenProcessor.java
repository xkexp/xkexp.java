package com.xkyii.quarkus.xkus.codegen.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;

class XkusCodegenProcessor {

    private static final String FEATURE = "xkus-codegen";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }
}
