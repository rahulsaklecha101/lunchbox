FROM openjdk:8
MAINTAINER Rahul Saklecha <rahulsaklecha101@gmail.com>

ADD ./target/user-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/user-service.jar"]

EXPOSE 5020