FROM amazoncorretto:21-alpine-jdk as build
WORKDIR /usr/app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM amazoncorretto:21-alpine-jdk as deploy
VOLUME /tmp
ARG JAR_FILE=/usr/app/target/*.jar
COPY --from=build $JAR_FILE /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]