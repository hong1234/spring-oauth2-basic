# oauth-rest-client #

Execute the below command using Gradle from the project directory:

```shell
./gradlew bootRun
```

Alternatively, if you're using Maven, execute the following command from the project directory:

```shell
./mvnw spring-boot:run
```


We need to ensure that the `authorization-server` and `resource-server` applications are running and ready to take OAuth 2 requests from clients.

We can then start the `oauth2-rest-client`.

It will expose a RESTful endpoint that will call our resource server to access the configured events located at `/teams` on the remote resource, and will return the following result by running http://localhost:8888/.

```json
[

]
```

