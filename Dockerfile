FROM openjdk:11
ADD target/diamond-server.jar diamond-server.jar
VOLUME /tmp
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "diamond-server.jar"]
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=container", "-jar", "/diamond/diamond.jar"]
#RUN mkdir -p /diamond/
#RUN mkdir -p /diamond/logs
# WORKDIR /diamond
# COPY maven/diamond.jar diamond.jar
# COPY maven/diamond.jar diamond.jar