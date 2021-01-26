FROM openjdk:11
LABEL maintance="Osmar Araujo Garcao"
VOLUME /tmp
EXPOSE 8765
ADD ./target/rogui-api-gateway-zuul-0.0.1-SNAPSHOT.jar rogui-api-gateway-zuul.jar
ENTRYPOINT ["java", "-jar", "/rogui-api-gateway-zuul.jar"]