FROM registry.isspaas.com/library/java:8.0
RUN mkdir /app
ADD target/cable-common*.jar /app/cable-common.jar
WORKDIR /app
ENTRYPOINT ["java", "-Dfile.encoding=utf-8", "-Dspring.profiles.active=production", "-jar", "cable-common.jar"]