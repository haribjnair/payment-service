FROM openjdk:17 as build

ADD ./target/payment-service.jar payment-service.jar
CMD ["java", "-jar","/payment-service.jar"]


EXPOSE 8092