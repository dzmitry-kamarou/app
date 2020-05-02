FROM openjdk:11
VOLUME /diamond
EXPOSE 8081
ADD target/diamond-0.0.1-SNAPSHOT.jar diamond.jar
ENTRYPOINT ENTRYPOINT ["java","-jar","/diamond.jar"]