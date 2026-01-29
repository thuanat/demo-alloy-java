# ===== STAGE 1: build =====
FROM maven:3.9.6-eclipse-temurin-11 AS builder

WORKDIR /build

COPY pom.xml .
RUN mvn -B -q dependency:go-offline

COPY src ./src
RUN mvn -B -q package -DskipTests

# ===== STAGE 2: runtime =====
FROM eclipse-temurin:11-jre

WORKDIR /app

COPY --from=builder /build/target/*.jar app.jar
COPY otel/opentelemetry-javaagent.jar /otel/opentelemetry-javaagent.jar

ENV JAVA_TOOL_OPTIONS="-javaagent:/otel/opentelemetry-javaagent.jar"

ENV OTEL_TRACES_EXPORTER=otlp
ENV OTEL_METRICS_EXPORTER=otlp
ENV OTEL_LOGS_EXPORTER=otlp

ENV OTEL_EXPORTER_OTLP_ENDPOINT=http://alloy-agent.monitor.svc:4317
ENV OTEL_EXPORTER_OTLP_PROTOCOL=grpc
ENV OTEL_SERVICE_NAME=demo-java
ENV OTEL_RESOURCE_ATTRIBUTES=deployment.environment=demo

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
