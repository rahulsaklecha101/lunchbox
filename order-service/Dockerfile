FROM openjdk:8
MAINTAINER Rahul Saklecha <rahulsaklecha101@gmail.com>

ADD ./target/order-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/order-service.jar"]

EXPOSE 5010