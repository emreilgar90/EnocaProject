FROM amazoncorretto:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} EnocaProject-0.0.1-SNAPSHOT.jar
CMD apt-get update -y
ENTRYPOINT ["java","-Xmx2048m","-jar","application.jar"]