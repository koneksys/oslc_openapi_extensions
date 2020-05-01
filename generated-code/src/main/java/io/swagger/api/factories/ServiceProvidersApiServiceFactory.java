package io.swagger.api.factories;

import io.swagger.api.ServiceProvidersApiService;
import io.swagger.api.impl.ServiceProvidersApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-05-01T13:27:13.952-05:00[America/Mexico_City]")public class ServiceProvidersApiServiceFactory {
    private final static ServiceProvidersApiService service = new ServiceProvidersApiServiceImpl();

    public static ServiceProvidersApiService getServiceProvidersApi() {
        return service;
    }
}
