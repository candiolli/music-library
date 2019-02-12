FROM openjdk:8-jre-alpine
MAINTAINER Riachuelo Developer Team
VOLUME /config
EXPOSE 8080
ADD target/cliente-spring-data-rest-1.0-SNAPSHOT.jar cliente-spring-data-rest.jar
COPY target/classes/config/* /config/
ENV JAVA_OPTS="-Xmx256m -Xms256m -XX:MetaspaceSize=48m -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Djava.security.egd=file:/dev/./urandom"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar cliente-spring-data-rest.jar" ]