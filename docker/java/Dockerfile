# Base image
FROM openjdk:8-jre

# Copy main class
COPY bin/MainApplication.class /app/MainApplication.class

# Define the working directory
WORKDIR "/app"

# Define command to run
ENTRYPOINT ["java"]
CMD ["MainApplication"]

