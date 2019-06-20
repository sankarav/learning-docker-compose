FROM openjdk:8
COPY target/KafkaInfiniteConsumer-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/myapp/
WORKDIR /usr/myapp
CMD ["java", "-jar", "KafkaInfiniteConsumer-1.0-SNAPSHOT-jar-with-dependencies.jar"]