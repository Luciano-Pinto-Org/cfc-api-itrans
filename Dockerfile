FROM eclipse-temurin/eclipse-temuri:17-jdk-alpine

RUN echo "America/Manaus" > /etc/timezone

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

WORKDIR /home/spring
ARG JAR_FILE=target/*.jar
COPY $JAR_FILE app.jar

ENTRYPOINT ["java"]
CMD ["-jar", "app.jar"]

EXPOSE 8080

