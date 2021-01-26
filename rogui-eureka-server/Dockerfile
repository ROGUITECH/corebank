FROM openjdk:11
LABEL maintance="Edvaldo Santiago de Matos"
VOLUME /tmp
EXPOSE 8761
ADD ./target/rogui-eureka-server-0.0.1-SNAPSHOT.jar rogui-eureka-server.jar
ENTRYPOINT ["java","-jar","/rogui-eureka-server.jar"]