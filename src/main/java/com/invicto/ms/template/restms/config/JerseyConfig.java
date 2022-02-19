package com.invicto.ms.template.restms.config;

import com.invicto.ms.template.restms.api.ExampleController;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(ExampleController.class);
    }

}
