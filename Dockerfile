FROM amazoncorretto:22-alpine
WORKDIR /app
COPY gradlew build.gradle settings.gradle ./
COPY gradle ./gradle
COPY src ./src
RUN chmod +x gradlew
RUN ./gradlew build --no-daemon
CMD ["./gradlew", "bootRun"]