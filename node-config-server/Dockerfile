FROM openjdk:8-jdk-alpine
WORKDIR /config
COPY target/node-config-server-1.0.0.jar node-config-server-1.0.0.jar
CMD echo File copied
ENV JAVA_OPTS="-Xmx256m -Xms256m"
EXPOSE 8888
ENTRYPOINT [ "sh","-c","java ${JAVA_OPTS} -jar node-config-server-1.0.0.jar" ]


