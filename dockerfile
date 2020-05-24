FROM openjdk:8-jre

COPY config.yml /data/preferenceservice/config.yml

ARG JAR_FILE
COPY ${JAR_FILE} /data/preferenceservice/preferenceservice.jar

WORKDIR /data/preferenceservice

RUN java -version

CMD ["java","-jar","preferenceservice.jar","server","config.yml"]

EXPOSE 8080-8081