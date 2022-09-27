package com.xkyii.quarkus.xkus.codegen.runtime;

import io.quarkus.devconsole.runtime.spi.DevConsolePostHandler;
import io.quarkus.devconsole.runtime.spi.FlashScopeUtil;
import io.quarkus.runtime.annotations.Recorder;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.ext.web.RoutingContext;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.Collection;
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

    public Handler<RoutingContext> handler() {

        return new DevConsolePostHandler() {
            @Override
            protected void handlePost(RoutingContext event, MultiMap form) throws Exception {
                String id = form.get("id");
                String operation = form.get("operation");
                Collection<CodegenContainer> containers = new CodegenContainersSupplier().get();
                for (CodegenContainer container: containers) {
                    if (container.getId().equals(id)) {
                        if ("resource".equals(operation)) {
                            // TODO: 生成Resource
                            flashMessage(event, "Resources generated");
                        }
                        else if ("repository".equals(operation)) {
                            // TODO: 生成Repository
                            flashMessage(event, "Repositories generated");
                        }
                        else {
                            flashMessage(event, String.format("Invalid operation: %s", operation), FlashScopeUtil.FlashMessageStatus.ERROR);
                        }
                        return;
                    }
                }
                flashMessage(event, String.format("Generate Id not found: %s", id), FlashScopeUtil.FlashMessageStatus.ERROR);
            }
        };
    }
}
