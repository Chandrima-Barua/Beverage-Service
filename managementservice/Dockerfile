FROM adoptopenjdk/openjdk11:alpine-jre
FROM gradle:7.3.3-jdk-alpine
WORKDIR /opt

ADD --chown=gradle:gradle . /opt/managementservice

RUN chown -R gradle:gradle /opt/managementservice
RUN chmod 755 /opt/managementservice
WORKDIR /opt/managementservice
USER gradle

EXPOSE 8090
ENTRYPOINT  gradle build && gradle run



