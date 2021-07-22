FROM ubi8/openjdk-11
USER root

ARG PROJECT_NAME=sample-service
ARG VERSION=0.0.1
ARG JAR_FILE=libs/${PROJECT_NAME}-${VERSION}.jar
ARG ENVIR=uat
ARG AWS_CONFIG_FILE=/mnt/$SERVER/conf/config
ARG AWS_CREDENTIAL_PROFILES_FILE=/mnt/$SERVER/conf/credentials

COPY ${JAR_FILE} /opt/${PROJECT_NAME}-${VERSION}.jar

ENV SERVER=${PROJECT_NAME}-${ENVIR}
ENV JAR=${PROJECT_NAME}-${VERSION}.jar

ADD https://search.maven.org/remotecontent?filepath=co/elastic/apm/elastic-apm-agent/1.24.0/elastic-apm-agent-1.24.0.jar /tmp/elastic-apm-agent.jar
RUN cp /tmp/elastic-apm-agent.jar /opt/elastic-apm-agent.jar

WORKDIR /opt

ENTRYPOINT java -jar -Dlog4j.configurationFile=/mnt/$SERVER/conf/log4j2.xml -javaagent:elastic-apm-agent.jar -Delastic.apm.config_file=/mnt/$SERVER/conf/elasticapm.properties -Dspring.config.location=file:/mnt/$SERVER/conf/application.properties $JAR
