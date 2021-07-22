# Java Service Project Template

Default Java service project template to standardize project creation.

It includes basic project folder structure, sample controller, DockerFile and related K8S YAMLs.

# Initial Settings
1. Global replace `sample-service` and `sample.service` to service name you needed;
2. Update connection string in `application.properties`;
3. Update `log4j2.xml` settings;

# Build And Debug
```shell
## Using gradle wrapper to elminate dependency in local computer.

## Build project.
gradlew clean build

## Run unit test.
gradlew test
```

# Employed Libraries
|Library|Usage|
|------|-----|
|SpringBoot MVC|Core API. |
|Spring Data| Connect database.
|Spring Actuator| Health check|
|Spring Doc| Open API / Swagger UI|
|Log4j2|Logging|
|Lombok| Getter / Setter / Builder|
|JUnit 5|Unit Tests|