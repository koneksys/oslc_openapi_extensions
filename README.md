# OSLC Extensions for OpenAPI

## Notes

- Swagger Codegen version: 3.0.18
- Swagger Code Generators version: 1.0.19

## Usage

### Server generation

1. Generate server code with:
```ssh
swagger-codegen generate -l jaxrs-jersey -i swagger-lyo-codegen-ext.yml -o target/server -t templates-server
```
2. Inside the generated server code, create a folder at the same level as `src/main` with the name `resources`. 
3. Create `application.properties` file inside the `resources` file.
4. In the `application.properties` file specify the port according to the OpenAPI spec file:
```
server.port=8082
```
5. Run the server with:
```
mvn spring-boot:run
```
6. Check the server is running correctly by calling the following endpoints:


OpenAPI spec in JSON format: http://localhost:8082/adaptor-testing/services/openapi.json 

Test Script Resource Shape:  http://localhost:8082/adaptor-testing/services/resourceShapes/TestScript

Service provider:  http://localhost:8082/adaptor-testing/services/provider/test

OpenAPI: http://localhost:8082/adaptor-testing/services/openapi.json


#### Optional: Add Swagger UI

The generated project comes with a Maven plugin that downloads the Swagger UI resources into the target/static directory. 

1. Create a folder `static` under `src/main/resources`.
2. Add an `index.html` file in the `static` folder with the following contents: https://raw.githubusercontent.com/swagger-api/swagger-samples/2.0/java/java-jersey2-configfile/src/main/webapp/index.html
3. In the newly created `index.html` file change `url` field of the `SwaggerUIBundle` initializer to the OpenAPI endpoint: `http://localhost:8082/adaptor-testing/services/openapi.json`
4. Download the resources with:
```
mvn clean package
```
5. Start the server.

### Client Generation

1. Generate client library with:
```ssh
swagger-codegen generate -l java -i swagger-lyo-codegen-ext.yml -o target/client --additional-properties library=jersey2 -t templates-client
```
2. The library comes with a suite of tests, located in the `src/test` folder. You can run them using the command:
```ssh
mvn test
```
 
