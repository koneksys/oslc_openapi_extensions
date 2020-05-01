package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.ResourceShapesApiService;
import io.swagger.api.factories.ResourceShapesApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


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



@Path("/resourceShapes")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-05-01T13:27:13.952-05:00[America/Mexico_City]")public class ResourceShapesApi  {
   private final ResourceShapesApiService delegate;

   public ResourceShapesApi(@Context ServletConfig servletContext) {
      ResourceShapesApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("ResourceShapesApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (ResourceShapesApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = ResourceShapesApiServiceFactory.getResourceShapesApi();
      }

      this.delegate = delegate;
   }

    @GET
    @Path("/{resourceType}")
    
    
    @Operation(summary = "", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation") })
    public Response resourceShapesResourceTypeGet(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("resourceType") String resourceType
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.resourceShapesResourceTypeGet(resourceType,securityContext);
    }
}
