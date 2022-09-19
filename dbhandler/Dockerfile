FROM adoptopenjdk/openjdk11:alpine-jre
FROM gradle:7.3.3-jdk-alpine
WORKDIR /opt

ADD --chown=gradle:gradle . /opt/dbhandler

RUN chown -R gradle:gradle /opt/dbhandler
RUN chmod 755 /opt/dbhandler
WORKDIR /opt/dbhandler
USER gradle

EXPOSE 9999
ENTRYPOINT  gradle build && gradle run
