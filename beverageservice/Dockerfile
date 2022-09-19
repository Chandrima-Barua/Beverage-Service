FROM adoptopenjdk/openjdk11:alpine-jre
FROM gradle:7.3.3-jdk-alpine
WORKDIR /opt

ADD --chown=gradle:gradle . /opt/beverageservice

RUN chown -R gradle:gradle /opt/beverageservice
RUN chmod 755 /opt/beverageservice
WORKDIR /opt/beverageservice
USER gradle

EXPOSE 8080
ENTRYPOINT gradle build && gradle run
