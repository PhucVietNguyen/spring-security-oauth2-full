FROM openjdk:11
ADD target/profile-service-0.0.1-SNAPSHOT.jar profile.jar
EXPOSE 8191
ENTRYPOINT ["java", "-jar", "profile.jar"]