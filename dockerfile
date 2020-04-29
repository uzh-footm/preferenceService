FROM openjdk:8-jdk

COPY config.yml /data/preferenceservice/config.yml
COPY target/preferenceservice-1.0-SNAPSHOT.jar /data/preferenceservice/preferenceservice-1.0-SNAPSHOT.jar

WORKDIR /data/preferenceservice

RUN java -version

CMD ["java","-jar","preferenceservice-1.0-SNAPSHOT.jar","server","config.yml"]

EXPOSE 8080-8081