package io.swagger.api.factories;

import io.swagger.api.ProviderApiService;
import io.swagger.api.impl.ProviderApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-05-01T13:27:13.952-05:00[America/Mexico_City]")public class ProviderApiServiceFactory {
    private final static ProviderApiService service = new ProviderApiServiceImpl();

    public static ProviderApiService getProviderApi() {
        return service;
    }
}
