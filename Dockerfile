# Use a base image that has Java installed
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file into the container
COPY target/mailerservice-1.0.jar app.jar

# Expose the port the application will run on
EXPOSE 8080

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
