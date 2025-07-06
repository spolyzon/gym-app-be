FROM eclipse-temurin:17-jre-jammy

WORKDIR /home

COPY target/*.jar app.jar

#EXPOSE 8080

#ENV JAVA_OPTS="-Djavax.net.ssl.trustStore=/home/keystore.jks -Djavax.net.ssl.trustStorePassword=pwd123"

ENTRYPOINT ["java", "-jar", "/home/app.jar"]
