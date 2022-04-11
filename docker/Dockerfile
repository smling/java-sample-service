## Open JDK latest version.
## Reference: https://catalog.redhat.com/software/containers/ubi8/openjdk-11/5dd6a4b45a13461646f677f4?container-tabs=gti
FROM ubi8/openjdk-17/1.11-2.1648459725
USER root

ARG PROJECT_NAME=sample-service
ARG PROJECT_VERSION=0.0.1
ARG JAR_FILE=libs/${PROJECT_NAME}-${PROJECT_VERSION}.jar
ARG ENVIR=uat
ARG AWS_CONFIG_FILE=/mnt/$SERVER/conf/config
ARG AWS_CREDENTIAL_PROFILES_FILE=/mnt/$SERVER/conf/credentials
ARG ELASTIC_APM_AGENT_VERSION=1.24.0

COPY ${JAR_FILE} /opt/${PROJECT_NAME}-${PROJECT_VERSION}.jar

ENV SERVER=${PROJECT_NAME}-${ENVIR}
ENV JAR=${PROJECT_NAME}-${PROJECT_VERSION}.jar

ADD https://search.maven.org/remotecontent?filepath=co/elastic/apm/elastic-apm-agent/$ELASTIC_APM_AGENT_VERSION/elastic-apm-agent-$ELASTIC_APM_AGENT_VERSION.jar /tmp/elastic-apm-agent.jar
RUN cp /tmp/elastic-apm-agent.jar /opt/elastic-apm-agent.jar

WORKDIR /opt

ENTRYPOINT java -jar -Dlog4j.configurationFile=/mnt/$SERVER/conf/log4j2.xml -javaagent:elastic-apm-agent.jar -Delastic.apm.config_file=/mnt/$SERVER/conf/elasticapm.properties -Dspring.config.location=file:/mnt/$SERVER/conf/application.properties -Xms200m -Xmx900m $JAR
