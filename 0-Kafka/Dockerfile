FROM openjdk:8

ENV KAFKA_VERSION=1.0.2 \
	KAFKA_HOME=/opt/kafka \
    SCALA_VERSION=2.11

RUN mkdir -p ${KAFKA_HOME} \
  && curl https://archive.apache.org/dist/kafka/${KAFKA_VERSION}/kafka_$SCALA_VERSION-${KAFKA_VERSION}.tgz | tar -xz --strip-components=1 -C ${KAFKA_HOME} \
  && rm -rf ${KAFKA_HOME}/site-docs

WORKDIR ${KAFKA_HOME}

CMD ["/bin/bash", "bin/kafka-server-start.sh", "config/server.properties", "--override", "zookeeper.connect=zoo:2181"]