package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.ProviderApiService;
import io.swagger.api.factories.ProviderApiServiceFactory;

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



@Path("/provider")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-05-01T14:16:00.487-05:00[America/Mexico_City]")public class ProviderApi  {
   private final ProviderApiService delegate;

   public ProviderApi(@Context ServletConfig servletContext) {
      ProviderApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("ProviderApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (ProviderApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = ProviderApiServiceFactory.getProviderApi();
      }

      this.delegate = delegate;
   }

    @GET
    @Path("/{serviceProviderId}")
    
    
    @Operation(summary = "", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation") })
    public Response providerServiceProviderIdGet(@Parameter(in = ParameterIn.PATH, description = "",required=true) @PathParam("serviceProviderId") String serviceProviderId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.providerServiceProviderIdGet(serviceProviderId,securityContext);
    }
}
