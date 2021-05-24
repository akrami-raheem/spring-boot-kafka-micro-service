FROM openjdk:8-jre-alpine
USER root
# Add a volume pointing to /tmp
VOLUME /tmp
# Make port 8080 available to the world outside this container
EXPOSE 8080
#COPY . .
ADD target/ms-config-server-0.0.1-SNAPSHOT.jar ms-config-server.jar
RUN mkdir /deployments/logs
RUN chmod -R 777 /opt/

RUN echo $JAVA_HOME
RUN chmod 777 ms-config-server.jar
RUN nohup sh java -jar $JAVA_OPTS -Dserver.port=8080 ms-config-server.jar