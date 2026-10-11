# Stage 1: Build stage
FROM gradle:8.8-jdk21-alpine AS builder
WORKDIR /app

# Copy gradle build configuration
COPY build.gradle settings.gradle ./

# Copy source code
COPY src ./src

# Build bootJar without running tests
RUN gradle bootJar --no-daemon -x test

# Stage 2: Runtime stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy executable jar from builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose search-service-v1 port
EXPOSE 8081

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
