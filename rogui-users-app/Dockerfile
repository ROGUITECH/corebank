FROM openjdk:11
LABEL maintance="Osmar Araujo Garcao"
Volume /tmp
ADD ./target/rogui-users-app-0.0.1-SNAPSHOT.jar rogui-users-app.jar
ENTRYPOINT ["java","-jar","/rogui-users-app.jar"]