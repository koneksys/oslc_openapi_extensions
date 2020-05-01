package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;


import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;
import java.net.URISyntaxException;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import org.eclipse.lyo.oslc4j.core.model.ResourceShape;
import org.eclipse.lyo.oslc4j.core.model.ResourceShapeFactory;
import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;

import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-05-01T13:06:33.109-05:00[America/Mexico_City]")public class ResourceShapesApiServiceImpl extends ResourceShapesApiService {
    @Override
    public Response resourceShapesResourceTypeGet(String resourceType, SecurityContext securityContext) throws NotFoundException {
        ResourceShape shape;
        Class<?> resourceClass;
        Response.ResponseBuilder builder;
        String className = "io.swagger.model." + resourceType;
        try {
            String base = "http://localhost:8082/adaptor-testing/services";
            resourceClass = Class.forName(className);
            shape = ResourceShapeFactory.createResourceShape(
                base,
                "resourceShapes",
                resourceType,
                resourceClass);
            builder = Response.ok(shape);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        builder = Response.status(HttpServletResponse.SC_NOT_FOUND);
        } catch (OslcCoreApplicationException | URISyntaxException ex) {
            builder = Response.serverError();
        }
        return builder.build();
    }
}
