FROM maven


COPY target/cod2d-api*.jar /app/cod2d-api.jar
COPY pom.xml /app
COPY checkstyle.xml /app
ENTRYPOINT ["java","-Duser.timezone=America/Sao_Paulo","-jar","/app/cod2d-api.jar"]
EXPOSE ${PORT}:5000

