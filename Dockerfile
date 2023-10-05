FROM openjdk:17
VOLUME /tmp
ARG JAR_FILE=build/libs/imaginarium.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
