FROM openjdk:8-jdk-alpine
WORKDIR /discovery
COPY target/node-discovery-server-1.0.0.jar node-discovery-server-1.0.0.jar
CMD echo File copied
ENV JAVA_OPTS="-Xmx256m -Xms256m"
EXPOSE 5555
ENTRYPOINT [ "sh","-c","java ${JAVA_OPTS} -Dconfig.server=${CONFIG_SERVER} -jar node-discovery-server-1.0.0.jar" ]
