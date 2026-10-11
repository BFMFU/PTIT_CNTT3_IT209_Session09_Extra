# Stage 1: Build stage
FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

# Copy gradle wrapper files
COPY gradlew settings.gradle build.gradle ./
COPY gradle ./gradle

# Normalize line endings and set execution permission
RUN sed -i 's/\r$//' gradlew && chmod +x gradlew

# Copy source code
COPY src ./src

# Build application jar without running tests
RUN ./gradlew bootJar --no-daemon -x test

# Stage 2: Runtime stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy executable jar from builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose gateway port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
