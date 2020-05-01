package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;


import java.util.Map;
import java.util.HashMap;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.eclipse.lyo.oslc4j.core.model.Publisher;
import org.eclipse.lyo.oslc4j.core.model.ResourceShape;
import org.eclipse.lyo.oslc4j.core.model.ResourceShapeFactory;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.ServiceProviderFactory;
import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;

import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-05-01T13:06:33.109-05:00[America/Mexico_City]")public class ProviderApiServiceImpl extends ProviderApiService {

    @Override
    public Response providerServiceProviderIdGet(String serviceProviderId, SecurityContext securityContext)
            throws NotFoundException {
        Class<?>[] services = { ServiceProvidersApi.class };
        Publisher publisher = new Publisher("Test Script", "urn:oslc:testscript");
        Map<String, Object> paramValues = new HashMap<>();
        paramValues.put("serviceProviderId", serviceProviderId);
        ServiceProvider provider = null;
        try {
            provider = ServiceProviderFactory.createServiceProvider("http://localhost:8082/adaptor-testing/services",
                       "http://localhost:8082/adaptor-testing", "Test Scripts", "Test Scripts Service Provider",
                            publisher, services, paramValues);
            provider.setAbout(URI.create("http://localhost:8082/adaptor-testing/services/provider"));
        } catch (OslcCoreApplicationException | URISyntaxException e) {
            e.printStackTrace();
        }
        return Response.ok(provider).build();
    }
   
}
