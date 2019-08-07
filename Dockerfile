FROM openjdk:11.0.3
ADD target/muzix-app-hibernate.jar muzix-app-hibernate.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "muzix-app-hibernate.jar"]
