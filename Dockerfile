#FROM openjdk:21-jdk-slim
#Start with a base image containing Java runtime
FROM amazoncorretto:21

#Information around who maintains the image
LABEL "org.opencontainers.image.authors"="apshuk21"

# Add the application's jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]
