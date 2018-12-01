FROM java:8-jre-alpine

WORKDIR /igt-spring-trening

COPY dependencies/* dependencies/
#COPY snapshot-dependencies/* dependencies/
COPY igt-spring-trening.jar igt-spring-trening.jar

ENV _JAVA_OPTIONS -Xmx64M

ENTRYPOINT ["java", "-jar", "igt-spring-trening.jar"]
