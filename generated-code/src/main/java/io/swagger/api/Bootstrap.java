package io.swagger.api;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
    }

    private void registerEndpoints() {
        packages("io.swagger.api");
    }


    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }

}