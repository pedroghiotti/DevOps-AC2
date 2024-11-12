FROM eclipse-temurin:17-jre

WORKDIR /ac2

COPY target/ac2-0.0.1-SNAPSHOT.jar /ac2/ac2-0.0.1-SNAPSHOT.jar

EXPOSE 8484

CMD ["java", "-XX:+UseContainerSupport", "-Xmx512m", "-Dserver.port=8585", "-jar", "ac2-0.0.1-SNAPSHOT.jar"]