FROM openjdk:8
COPY target/KafkaInfiniteProducer-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/myapp/
WORKDIR /usr/myapp
CMD ["java", "-jar", "KafkaInfiniteProducer-1.0-SNAPSHOT-jar-with-dependencies.jar"]