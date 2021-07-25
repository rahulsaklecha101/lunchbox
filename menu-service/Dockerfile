FROM openjdk:8
MAINTAINER Rahul Saklecha <rahulsaklecha101@gmail.com>

ADD ./target/menu-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/menu-service.jar"]

EXPOSE 5000 5000