FROM openjdk:8
MAINTAINER Rahul Saklecha <rahulsaklecha101@gmail.com>

ADD ./target/vendor-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/vendor-service.jar"]

EXPOSE 5040