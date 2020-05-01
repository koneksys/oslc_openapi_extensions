package io.swagger.api.factories;

import io.swagger.api.ResourceShapesApiService;
import io.swagger.api.impl.ResourceShapesApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-05-01T14:12:36.744-05:00[America/Mexico_City]")public class ResourceShapesApiServiceFactory {
    private final static ResourceShapesApiService service = new ResourceShapesApiServiceImpl();

    public static ResourceShapesApiService getResourceShapesApi() {
        return service;
    }
}
