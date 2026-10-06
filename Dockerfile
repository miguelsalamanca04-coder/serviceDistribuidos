FROM maven:3.9.9-eclipse-temurin-21 AS build

ARG GIT_TOKEN

WORKDIR /app

RUN git clone https://${GIT_TOKEN}@github.com/miguelsalamanca04-coder/serviceDistribuidos.git .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/mathservice-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
