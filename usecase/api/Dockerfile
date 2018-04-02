# Base image for use as the builder
FROM openjdk:10-jdk as java-builder

# Set the workdir to the jlink output path
WORKDIR /jlink/outputdir

# Run jlink tool to generate the custom jre
RUN jlink --module-path /docker-java-home/jmods --strip-debug --compress=2 --output java \
    --add-modules java.base,java.logging,java.xml,jdk.unsupported,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument

# Base image for the custom jre
FROM buildpack-deps:stretch-curl

# Copy custom jre built
COPY --from=java-builder /jlink/outputdir /jre

# Add java the the path
ENV PATH /jre/java/bin:$PATH

# Get the jar file from the args and copy to /app.jar
ARG JAR_FILE
ADD ${JAR_FILE} app.jar

# Set the entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]