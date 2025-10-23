FROM openjdk:17-jdk-slim

# Copy the fat JAR
COPY target/seMethods-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp/

WORKDIR /tmp

# Run the fat JAR
ENTRYPOINT ["java", "-jar", "seMethods-1.0-SNAPSHOT-jar-with-dependencies.jar"]
