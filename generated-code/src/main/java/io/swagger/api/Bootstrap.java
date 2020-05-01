package io.swagger.api;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

import org.eclipse.lyo.oslc4j.provider.jena.JenaProvidersRegistry;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = { "io.swagger.model", "io.swagger.api" })
public class Bootstrap extends ResourceConfig implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Bootstrap.class).run(args);
    }

    @PostConstruct
    public void init() {
        registerClasses(JenaProvidersRegistry.getProviders());
        registerEndpoints();
        configureSwagger();
    }

    private void registerEndpoints() {
        packages("io.swagger.api");
    }

    private void configureSwagger() {
        OpenApiResource openApiResource = new OpenApiResource();
        Set<String> apiPackage = new HashSet<>();
        apiPackage.add("io.swagger.api");
        openApiResource.resourcePackages(apiPackage);
        register(openApiResource);
    }
    

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }

}