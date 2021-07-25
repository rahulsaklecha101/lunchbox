FROM openjdk:8
MAINTAINER Rahul Saklecha <rahulsaklecha101@gmail.com>

ADD ./target/utils.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/utils.jar"]

EXPOSE 5030