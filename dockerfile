# Etapa de construção
FROM maven:3.8.4-openjdk-17 AS build
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn package -DskipTests

# Etapa de execução
FROM openjdk:17-jdk-slim
COPY --from=build /usr/src/app/target/quarkus-app/quarkus-run.jar /app/quarkus-run.jar
CMD ["java", "-jar", "/app/quarkus-run.jar"]
