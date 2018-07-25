FROM openjdk:8
ADD target/bank-mysql.jar bank-mysql.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","bank-mysql.jar"]