# -------- Build Stage --------
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Gradle Wrapper & Build-Skripte
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./
RUN chmod +x gradlew

# Dependencies cachen
RUN ./gradlew dependencies --no-daemon

# Source code
COPY src src
RUN ./gradlew bootJar --no-daemon

# -------- Runtime Stage --------
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8087
ENTRYPOINT ["java","-jar","app.jar"]