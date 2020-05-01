# OSLC Extensions for OpenAPI

## Sample Usage

### Server

1. Generate server code with:

```ssh
swagger-codegen generate -l jaxrs-jersey -i swagger-lyo-codegen-ext.yml -o target/server -t templates-server
```

2. Create a folder at the same level as `src` with the name `resources`. 
3. Create `application.properties` file inside the `resources` file.
4. In the `application.properties` file specify the port and context path according to the OpenAPI spec:

```
server.contextPath=/adaptor-testing/services
server.port=8082
```

5. Run the server with:

```
mvn spring-boot:run
```

6. Check the server is running correctly by calling the following endpoints:

```
OpenAPI spec in JSON format: http://localhost:8082/adaptor-testing/services/openapi.json 

Test Script Resource Shape:  http://localhost:8082/adaptor-testing/services/resourceShapes/TestScript
```