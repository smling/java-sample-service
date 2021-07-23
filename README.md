# Java Service Project Template

Default Java service project template to standardize project creation.

It includes basic project folder structure, sample controller, DockerFile and related K8S YAMLs.

# Initial Setup
1. Global replace `sample-service`, `sample.service` to service name you needed;
2. Global replace `services.sample` to `services.[service name]` for updating namespace;   
3. Update connection string, application name and description in `application.properties`;
4. Update `log4j2.xml` settings;
5. After files added in directory, `.gitkeep` can be removed;

# Build And Debug
```shell
## Using gradle wrapper to eliminate dependency in local computer.

## Build project.
gradlew clean build

## Run unit test.
gradlew test
```

# Project Structure
```text
├───docker
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───bbpos
│   │   │           └───tms2
│   │   │               └───services
│   │   │                   └───sample
│   │   │                       ├───configuration		## Ben configurations.
│   │   │                       ├───data
│   │   │                       │   ├───dao				## JPA entities.
│   │   │                       │   └───repositories	## JPA repositories.
│   │   │                       ├───exceptions			## Service specific excetions.
│   │   │                       ├───services			## Service implementation on business logic.
│   │   │                       └───v1
│   │   │                           ├───controllers		## API Endpoint.
│   │   │                           └───dto				## API object response to client.
│   │   ├───resources
│   │   └───scripts
│   │       ├───batch
│   │       └───sql
│   └───test
│       └───java
│           └───com
│               └───bbpos
│                   └───tms2
│                       └───services
│                           └───sample
│                               └───v1
│                                   └───controllers
└───yaml
    ├───prod
    ├───stag
    └───uat
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