FROM openjdk:11
LABEL maintance="Osmar Araujo Garcao"
Volume /tmp
ADD ./target/rogui-oauth-0.0.1-SNAPSHOT.jar rogui-oauth.jar
ENTRYPOINT ["java","-jar","/rogui-oauth.jar"]
