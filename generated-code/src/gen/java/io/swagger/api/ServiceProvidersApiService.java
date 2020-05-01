package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.TestScript;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-05-01T13:27:13.952-05:00[America/Mexico_City]")public abstract class ServiceProvidersApiService {
    public abstract Response createTestScript(String serviceProviderId,TestScript body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getTestScript(String serviceProviderId,String testScriptId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getTestScriptAsHtmlLargePreview(String serviceProviderId,String testScriptId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getTestScriptAsHtmlSmallPreview(String serviceProviderId,String testScriptId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response queryTestScripts(String serviceProviderId, String oslcWhere, String page, String limit,SecurityContext securityContext) throws NotFoundException;
}
