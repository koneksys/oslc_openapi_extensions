package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.ServiceProvidersApiService;
import io.swagger.api.factories.ServiceProvidersApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.TestScript;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import org.eclipse.lyo.oslc4j.core.annotation.*;
import javax.validation.constraints.*;

@OslcService("http://open-services.net/ns/qm#")

@Path("/serviceProviders")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-05-01T13:27:13.952-05:00[America/Mexico_City]")public class ServiceProvidersApi  {
   private final ServiceProvidersApiService delegate;

   public ServiceProvidersApi(@Context ServletConfig servletContext) {
      ServiceProvidersApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("ServiceProvidersApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (ServiceProvidersApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = ServiceProvidersApiServiceFactory.getServiceProvidersApi();
      }

      this.delegate = delegate;
   }

    @POST
    @OslcCreationFactory(
        title = "Test Script Creation Factory"
        , resourceShapes = "resourceShapes/testScript"
        , resourceTypes = "http://open-services.net/ns/qm#TestScript")
    @Path("/{serviceProviderId}/testScripts/create")
    @Consumes({ "application/rdf+xml", "application/xml", "application/json", "text/turtle" })
    
    @Operation(summary = "Creation factory for resources of type {TestScript}", description = "Creation factory for resources of type {<a href=\"http://open-services.net/ns/qm#TestScript\">TestScript</a>}, with respective resource shapes {<a href=\"../services/resourceShapes/testScript\">TestScript</a>}", tags={ "OSLC Service for {TestScript}" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation") })
    public Response createTestScript(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("serviceProviderId") String serviceProviderId
,@Parameter(in = ParameterIn.DEFAULT, description = "" ) TestScript body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createTestScript(serviceProviderId,body,securityContext);
    }
    @GET
    @Path("/{serviceProviderId}/testScripts/{testScriptId}")
    
    @Produces({ "application/rdf+xml", "application/xml", "application/json", "text/turtle", "text/html", "application/x-oslc-compact+xml" })
    @Operation(summary = "GET for resources of type {TestScript}", description = "GET for resources of type {<a href=\"http://open-services.net/ns/qm#TestScript\">TestScript</a>}, with respective resource shapes {<a href=\"../services/resourceShapes/testScript\">TestScript</a>}", tags={ "OSLC Service for {TestScript}" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = TestScript.class))) })
    public Response getTestScript(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("serviceProviderId") String serviceProviderId
,@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("testScriptId") String testScriptId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getTestScript(serviceProviderId,testScriptId,securityContext);
    }
    @GET
    @Path("/{serviceProviderId}/testScripts/{testScriptId}/largePreview")
    
    
    @Operation(summary = "", description = "", tags={ "OSLC Service for {TestScript}" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation") })
    public Response getTestScriptAsHtmlLargePreview(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("serviceProviderId") String serviceProviderId
,@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("testScriptId") String testScriptId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getTestScriptAsHtmlLargePreview(serviceProviderId,testScriptId,securityContext);
    }
    @GET
    @Path("/{serviceProviderId}/testScripts/{testScriptId}/smallPreview")
    
    
    @Operation(summary = "", description = "", tags={ "OSLC Service for {TestScript}" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation") })
    public Response getTestScriptAsHtmlSmallPreview(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("serviceProviderId") String serviceProviderId
,@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("testScriptId") String testScriptId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getTestScriptAsHtmlSmallPreview(serviceProviderId,testScriptId,securityContext);
    }
    @GET
    @OslcQueryCapability(
        title = "Test Script Query Capability"
        , resourceShape = ""
        , resourceTypes = "http://open-services.net/ns/qm#TestScript")
    @Path("/{serviceProviderId}/testScripts/query")
    
    @Produces({ "application/rdf+xml", "application/xml", "application/json", "text/turtle", "text/html" })
    @Operation(summary = "Query capability for resources of type {TestScript}", description = "Query capability for resources of type {<a href=\"http://open-services.net/ns/qm#TestScript\">TestScript</a>}, with respective resource shapes {<a href=\"../services/resourceShapes/testScript\">TestScript</a>}", tags={ "OSLC Service for {TestScript}" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = TestScript.class)))) })
    public Response queryTestScripts(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("serviceProviderId") String serviceProviderId
,@Parameter(in = ParameterIn.QUERY, description = "") @QueryParam("oslc.where") String oslcWhere
,@Parameter(in = ParameterIn.QUERY, description = "") @QueryParam("page") String page
,@Parameter(in = ParameterIn.QUERY, description = "") @QueryParam("limit") String limit
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.queryTestScripts(serviceProviderId,oslcWhere,page,limit,securityContext);
    }
}
