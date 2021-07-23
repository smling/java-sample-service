# Java Service Project Template

Default Java service project template to standardize project creation.

It includes basic project folder structure, sample controller, DockerFile and related K8S YAMLs.

# Initial Setup
1. Global replace `sample-service`, `sample.service` to service name you needed;
2. Global replace `services.sample` to `services.[service name]` for updating namespace;   
3. Update connection string, application name and description in `application.properties`;
4. Update `log4j2.xml` settings;
5. After files added in directory, `.gitkeep` can be removed;
6. Update this file content to align with implemented service;

# Build And Debug
See snippet [Build and Debug](https://bbpos.me/tms/devops/java-service-template/-/snippets/4) for more details.

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
