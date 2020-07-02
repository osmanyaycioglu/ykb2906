FROM openjdk:8-jdk-alpine
WORKDIR /discovery
COPY target/ms-kitchen-1.0.0.jar ms-kitchen-1.0.0.jar
CMD echo File copied
ENV JAVA_OPTS="-Xmx256m -Xms256m"
EXPOSE 11000
ENTRYPOINT [ "sh","-c","java ${JAVA_OPTS} -Dconfig.server=${CONFIG_SERVER} -jar ms-kitchen-1.0.0.jar" ]
