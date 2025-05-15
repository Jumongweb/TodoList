FROM maven:3.8.7 as build
COPY . .
RUN mvn -B clean package -DskipTests

FROM openjdk:17
COPY --from=build target/*.jar todolist.jar
EXPOSE 7171

ENTRYPOINT ["java", "-jar", "-Dserver.port=7171", "todolist.jar"]