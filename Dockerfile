FROM maven:latest
#FROM selenium/standalone-chrome:latest
COPY ./. /
COPY ./src/test/java/chromedriver /home
RUN mvn test


