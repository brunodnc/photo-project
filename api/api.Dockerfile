#TODO: change from latest to a fixed version to avoid breaking changes.

### STAGE 1: Build ###
FROM maven:3.8.6-eclipse-temurin-19-alpine AS build
WORKDIR /usr/src/app
COPY . .
RUN mvn clean package -DskipTests

### STAGE 2: Run ###
FROM amazoncorretto:19-alpine-jdk
ARG JAR_FILE=*.jar
COPY --from=build /usr/src/app/target/${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
