FROM openjdk:8-jdk-alpine
ARG JAR_FILE
COPY target/${JAR_FILE} app.jar
COPY client.ks client.ks
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]