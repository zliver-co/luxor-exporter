FROM gradle:jdk11 as builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:11-jre-slim
EXPOSE 8080
COPY --from=builder /home/gradle/src/build/distributions/luxor-exporter-1.2.0-SNAPSHOT.tar /app/luxor-exporter.tar
WORKDIR /app
RUN tar -xvf luxor-exporter.tar
WORKDIR /app/luxor-exporter-1.2.0-SNAPSHOT
CMD bin/luxor-exporter
