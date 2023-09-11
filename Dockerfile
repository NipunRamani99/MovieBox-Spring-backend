FROM eclipse-temurin:19-jdk
RUN mkdir /usr/local/app
RUN mkdir /usr/local/app/resource
COPY ./output/movies-0.0.1.jar /usr/local/bin/movies-0.0.1.jar
COPY ./src/main/resources/* /usr/local/app/resources/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/bin/movies-0.0.1.jar"]