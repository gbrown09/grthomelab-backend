# syntax=docker/dockerfile:experimental
FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /usr/src/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN --mount=type=cache,target=/root/.m2 ./mvnw install -DskipTests
RUN mkdir -p target/extracted && (cd /usr/src/app/target/extracted; java -Djarmode=layertools -jar /usr/src/app/target/backend.jar extract --destination /usr/src/app/target/extracted)

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG EXTRACTED=/usr/src/app/target/extracted
COPY --from=build ${EXTRACTED}/dependencies/ ./
COPY --from=build ${EXTRACTED}/spring-boot-loader/ ./
COPY --from=build ${EXTRACTED}/snapshot-dependencies/ ./
COPY --from=build ${EXTRACTED}/application/ ./
EXPOSE 8102
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]