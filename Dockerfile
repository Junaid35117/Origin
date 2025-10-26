FROM openjdk:17-jdk-slim

# Copy the fat JAR
COPY target/seMethods-1.0-SNAPSHOT-shaded.jar /tmp/

WORKDIR /tmp

FROM openjdk:17-jdk-slim


CMD ["java", "-jar", "original-seMethods-1.0-SNAPSHOT-shaded.jar"]


# Run the fat JAR
ENTRYPOINT ["java", "-cp", "/tmp/seMethods-1.0-SNAPSHOT-jar-with-dependencies.jar", "com.napier.devops.App"]

