
#TODO: change from latest to a fixed version to avoid breaking changes.

FROM adoptopenjdk:latest
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]

